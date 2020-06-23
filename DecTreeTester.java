import java.util.ArrayList;

public class DecTreeTester {

    DecTree<String> srcStr;
    DigitTree<Double> srcInt;
    DigitTree<String> strTree;
    DigitTree<Double> intTree;

    public void before() {
        this.strTree = new DecTree<String>();
        this.intTree = new DecTree<Double>();
    }

    public void treeAddGet() {
        double halfTestRange = 9000;
        this.before();
        for (double i = -halfTestRange; i < halfTestRange; i++) {
            this.intTree.add(i, i);
            this.strTree.add(i, Double.toString(i));
        }
        System.out.println("set all");
        for (double i = -halfTestRange; i < halfTestRange; i++) {
            if (this.intTree.tGet(i) == null || this.strTree.tGet(i) == null) {
                System.out.println("Failed retrieval type 1 (null Tree) at index " + i);
                System.exit(1);
            }
        }
        System.out.println("treeAddGet() passed");
    }

    public static void main(String[] args) {
        ArrayList<String> isItPossible = new ArrayList<String>();
        ArrayList<Double> isItPossible2 = new ArrayList<Double>();
        for (double i = -9000; i < 9000; i++) {
            isItPossible.add(Double.toString(i));
            isItPossible2.add(i);
        }
        System.out.println("possible\n");
        DecTreeTester tester = new DecTreeTester();
        tester.treeAddGet();
    }
}