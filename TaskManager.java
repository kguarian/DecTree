import java.util.Scanner;

//TinkerToy
public class TaskManager {
    DecTree<String> tasks = new DecTree<String>();
    DecTree<String> idents = new DecTree<String>();

    public final String greeting = "Program Title: Task Manager\n\nINSTRUCTIONS: r: read\nw: write\nrm: remove\n ls: List\nseq: sequence\n";
    public final String menu = "menu: r w rm ls seq(inop.)";
    public final String address = "Prompt: in Address";
    public final String badAddress = "Bad Address.";
    boolean end = false;
    public final Scanner UserIn = new Scanner(System.in);

    private String getter(String ident) {
        return tasks.get(ident.hashCode());
    }

    private double StringHasher(String ident) {
        int max = 0;
        for (int i = 0; i < ident.length(); i++) {
            if (ident.charAt(i) > max) {
                max = ident.charAt(i);
            }
        }

        double retVal = 0;
        for (int i = 0; i < ident.length(); i++) {
            retVal += ident.charAt(i) * (Math.pow(max - 31, (double) i / 1007));
        }
        return retVal;
    }

    private String ui$prompt(){
        System.out.println(this.address);
        return UserIn.nextLine();
    }

    public void ui() { // TODO: organize into smaller, functionally distinct methods
        System.out.println(greeting);
        System.out.println(menu);
        String storeInput = UserIn.nextLine();
        if (storeInput.equals("r")) {
            System.out.println(address);
            String address=UserIn.nextLine();

            {boolean exitLoop = false;
            while(!exitLoop){
                try{
                    System.out.println(tasks.get(StringHasher(address)));
                }catch(NullPointerException e){}
            }}

        } else if (storeInput.equals("w")) {
            System.out.println(address);

            {
                boolean stopAsking = false;
                while (stopAsking == false) {
                    System.out.println("Ident: ");
                    String Ident = UserIn.nextLine();

                    System.out.println("Task: ");
                    String Task = UserIn.nextLine();
                    System.out.println("Task = " + idents.add(StringHasher(Ident), Ident).node.element + " : "
                            + tasks.add(StringHasher(Ident), Task).node.element + ". " + "\n");
                    stopAsking = true;
                }
            }
        } else if (storeInput.equals("rm")) {
            System.out.println(address);

            {
                boolean stopAsking = false;
                while (stopAsking == false) {
                    try {
                        System.out.println(this.address);
                        String Ident = UserIn.nextLine();
                        double hashedDouble = StringHasher(Ident);
                        tasks.rm(hashedDouble);
                        idents.rm(hashedDouble);
                        stopAsking = true;
                        System.out.println("Removed:" + Ident + "\n");
                    } catch (NullPointerException e) {
                        System.out.println(badAddress);
                    }
                }
            }
        } else if (storeInput.equals("wSeq")) {
            //seqWrite();
        } else if (storeInput.equals("rSeq")) {
            seqRead(); // TODO: left of here. I'm Tired AF
        } else if (storeInput.equals("ls")) {
            System.out.println(idents.toString());
        } else if (storeInput.equals("exit")) {
            System.exit(0);
        }
    }

    public void seqRead() {
    }
    /*
    public void seqWrite() {
        System.out.println("Which task's address will we use as our base?");
        DecTree<String> base = this.tasks.tGet(StringHasher(UserIn.nextLine()));
        System.out.println(base);
        System.out.println("'stat', 'std', or 'conventional'");
        String UserInput = UserIn.nextLine();

        DecTree<String> opTree = new DecTree<String>();
        // so I don't get that "element not set" exception.
        DecNode<String> opNode; // TODO: Unusued So Far.

        if (UserInput.equals("stat")) {
            System.out.println("stat");
            System.out.println("pro or anti?");
            UserInput = UserIn.nextLine();
            if (UserInput.equals("pro")) {
                opTree = base.node.pro;// TODO: Wrong types. Review This.
            } else if (UserInput.equals("anti")) {
                opTree = base.node.anti;
            }
            System.out.println("which dimension?");
            opTree = opTree.add(Double.parseDouble(UserIn.nextLine()), new DecTree<String>());
            UserInput = "standard";
        }
        if (UserInput.equals("std")) {
            System.out.println("std");
            System.out.println("pro or anti?");
            UserInput = UserIn.nextLine();
            if (UserInput.equals("pro")) {
                opTree = opTree.node.pro;
            } else if (UserInput.equals("anti")) {
                opTree = base.node.anti;
            }
            System.out.println("which dimension (double value)");
            double address = Double.parseDouble(UserIn.nextLine());
            System.out.println("which address in the written tasks is next?");
            opTree.add(address, tasks.get(StringHasher(UserIn.nextLine())));
        }
    }
    */

    public static void main(String[] args) {
        TaskManager testManager = new TaskManager();
        while (true) {
            testManager.ui();
        }
    }
}
