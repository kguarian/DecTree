import java.io.IOException;
import java.util.Scanner;

public class DBoard {

    private DecTree<String> board;
    private DecTree<String> pinned;
    private int pins = 0;
    private int finished = 0;
    private Scanner scanner = new Scanner(System.in);
    boolean stop = false;

    public DBoard() {
        this.board = new DecTree<String>();
        this.pinned = new DecTree<String>();
        String man = "\nAdd Decs to the board, then pin them by their tags.\n";

        pinned.dev0(0, man);
        this.pins = 1;
    }

    private String prompt(String prompt) {
        System.out.print("" + prompt + "\n: ");
        String retString = scanner.nextLine();
        System.out.println();
        return retString;

    }

    private double stringHasher(String u) {
        double low = Double.POSITIVE_INFINITY;
        double high = 0d;
        double hash = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) < low) {
                low = (double) (int) u.charAt(i);
            }
            if (u.charAt(i) > high) {
                high = (double) (int) u.charAt(i);
            }
        }
        for (int i = 0; i < u.length(); i++) {
            hash += (u.charAt(i) - low) * Math.pow(high - low, i);
        }
        return hash;
    }

    private void menu() throws IOException {
        String menu = "MENU\n****\nadd\nremove\ndis\npin\nunpin\nfinished\nclear\nquit\n_______";
        String add = "add";
        String rm = "rm";
        String dis = "dis";
        String pin = "pin";
        String unpin = "unpin";
        String finished = "finished";
        String clear = "clear";
        String quit = "quit";
        String input = "";

        while (!(input.equals(add) || input.equals(rm) || input.equals(dis) || input.equals(pin) || input.equals(unpin)
                || input.equals(finished) || input.equals(clear) || input.equals(quit))) {
            input = prompt(menu);
        }
        if (input.equals(add)) {
            addDec();
            return;
        } else if (input.equals(rm)) {
            rmDec();
            return;
        } else if (input.equals(dis)) {
            return;
        } else if (input.equals(pin)) {
            boolean finishedLoop = false;
            while (!finishedLoop) {
                String pinAddress = prompt("tag");
                try {
                    String pinString = board.dev0(stringHasher(pinAddress));
                    if (pinString != null) {
                        pinned.dev0(pins++, pinString);
                        finishedLoop = true;
                    }
                } catch (NullPointerException e) {
                    return;
                }
            }
        } else if (input.equals(unpin)) {
            if (pins > 0) {
                this.pinned.eksdev0(--pins);
            }
            return;
        } else if (input.equals(finished)) {
            if (this.finished < this.pins) {
                this.finished++;
            }
        } else if (input.equals(clear)) {
            this.pinned = new DecTree<String>();
            this.pins = 0;
            return;
        } else if (input.equals(quit)) {
            this.stop = true;
            return;
        }
        dis();
    }

    private void addDec() {
        String tag;
        String dec;

        tag = prompt("ADD_tag ");
        dec = prompt("dec ");

        board.dev0(stringHasher(tag), dec);
    }

    private void rmDec() throws IOException {
        String tag = prompt("RM_tag");
        try {
            board.eksdev0(stringHasher(tag));
        } catch (NullPointerException e) {
            boolean leaveLoop = false;
            while (!leaveLoop) {
                tag = prompt("retr(y) or retur(n)?");
                if (tag.equals("y")) {
                    rmDec();
                } else if (tag.equals("n")) {
                    leaveLoop = true;
                }
            }
        }
        return;
    }

    public void dis() throws IOException {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("DecBoard_");
        // clears screen
        // (https://stackoverflow.com/questions/2979383/java-clear-the-console)

        for (int i = finished; i < pins; i++) {
            System.out.println(pinned.dev0(i));
        }
        System.out.println();
        menu();
    }

    public static void main(String[] args) throws IOException {
        DBoard decBoard = new DBoard();
        while (!decBoard.stop) {
            decBoard.dis();
        }
    }
}