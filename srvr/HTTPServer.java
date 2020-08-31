package srvr;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer implements Runnable {

    static final File WEB_ROOT = new File(".");
    static final String DEFAULT_FILE = "index.html";
    static final String FILE_NOT_FOUND = "404.html";
    static final String METHOD_NOT_SUPPORTED = "not_supported.html";
    static final boolean verbose = true;
    // Port to listen from
    static final int PORT = 8080;

    // verbose mode
    private Socket connect;

    public HTTPServer(Socket c) {
        this.connect = c;
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverConnect = new ServerSocket(PORT);

            // Dev feedback
            System.out.printf("Success. Reading from Port %s\n", PORT);

            // listen until exit
            while (true) {
                HTTPServer myServer = new HTTPServer(serverConnect.accept());

                if (verbose) {
                    System.out.printf("Connection Opened (%s)\n", new Date());
                }

                // create dedicated thread to manage the client connection
                Thread thread = new Thread(myServer);
                thread.start();
            }
        } catch (Exception e) {
            System.err.printf("Error %s.\n", e.getMessage());
        }
    }

    @Override
    public void run() {
        // to manage client connection
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedOutputStream dataOut = null;
        String fileRequested = null;

        try {
            // read chars from input stream from client through "connect" socket
            in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            // char output stream to client for headers
            out = new PrintWriter(connect.getOutputStream());
            // binary output stream to client for file/data transmission
            dataOut = new BufferedOutputStream(connect.getOutputStream());

            // fetch and store first line of request from client
            String input = in.readLine();
            // parse with String.split()
            String[] parsedInput = input.split(input, 2);
            // Client's HTTP method
            String method = parsedInput[0].toUpperCase();
            System.out.println(method);

            // Tutorial scope: GET && HEAD
            fileRequested = parsedInput[1];
            if (!method.equals("GET") && !method.equals("HEAD")) {
                if (verbose) {
                    // Show 501 error
                    System.out.printf("501 Not Implemented: %s method", method);
                }
                // return NOT_SUPPORTED file to client
                File file = new File(WEB_ROOT, METHOD_NOT_SUPPORTED);
                int fileLength = (int) file.length();
                String contentMimeType = "text/html";
                byte[] fileData = readFileData(file, fileLength);

                // send HTTP Headers with data to client
                out.println("HTTP/1.1 501 Not Implemented");
                out.println("Server: Java HTTP Server (Dec): v0.0");
                out.printf("Date: %s\n", new Date());
                out.printf("Content Type: %s\n", contentMimeType);
                out.println("Content-length: " + fileLength);
                out.println();
                out.flush();
                // file
                dataOut.write(fileData, 0, fileLength);
                dataOut.flush();
            } else {
                // GET or HEAD method
                if (fileRequested.endsWith("/")) {
                    fileRequested += DEFAULT_FILE;
                }
                File file = new File(fileRequested);
                int fileLength = (int) file.length();
                String content = getContentType(fileRequested);

                if (method.equals("GET")) { // GET METHOD RETURNS CONTENT
                    byte[] fileData = readFileData(file, fileLength);

                    // send HTTP Headers
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Java HTTP Server (Dec): v0.0");
                    out.printf("Date: %s\n", new Date());
                    out.printf("Content Type: %s\n", content);
                    out.println("Content-length: " + fileLength);
                    out.println();
                    out.flush();

                    dataOut.write(fileData, 0, fileLength);
                    dataOut.flush();
                }

            }

        }catch (FileNotFoundException fnfe) {
            try {
                fileNotFound(out, dataOut, fileRequested);
            } catch (IOException ioe) {
                System.err.printf("IOE: %s\n", ioe.getMessage());
            }
        }
        catch (IOException ioe) {
            System.err.println();
        } finally {
            try {
                in.close();
                out.close();
                dataOut.close();
                connect.close(); //close socket connection
            } catch (IOException ioe) {
                System.err.println("IOE: "+ioe);
            }
            if(verbose){
                System.out.println("Connection closed.\n");
            }
        }

    }

    private byte[] readFileData(File file, int fileLength) throws IOException {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[fileLength];

        try {
            fileIn = new FileInputStream(file);
            fileIn.read(fileData);
        } finally {
            if (fileIn != null) {
                fileIn.close();
            }
        }
        return fileData;
    }

    // return MIME supported types
    private String getContentType(String fileRequested) {
        if (fileRequested.endsWith(".htm") || fileRequested.endsWith(".html")) {
            return "text/html";
        } else {
            return "text/plain";
        }
    }

    private void fileNotFound(PrintWriter out, OutputStream dataOut, String fileRequested) throws IOException{
        File file = new File(WEB_ROOT, FILE_NOT_FOUND);
        int fileLength = (int) file.length();
        String content = "text/html";
        byte[] fileData = readFileData(file, fileLength);

        out.println("HTTP/1.1 404 OK");
        out.println("Server: Java HTTP Server (Dec): v0.0");
        out.printf("Date: %s\n", new Date());
        out.printf("Content Type: %s\n", content);
        out.println("Content-length: " + fileLength);
        out.println();
        out.flush();

        dataOut.write(fileData, 0, fileLength);
        dataOut.flush();

        if(verbose){
            System.out.printf("File %s not found.\n", fileRequested);
        }
    }
}
