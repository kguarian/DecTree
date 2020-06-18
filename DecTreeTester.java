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
        double halfTestRange = 3.141543214543092876820345739;
        this.before();
        for (double i = -halfTestRange; i < halfTestRange; i+=.0015748350234587106948317509181) {
            this.intTree.add(i, i);
            this.strTree.add(i, Double.toString(i));
        }
        System.out.println("set all");
        for (double i = -halfTestRange; i < halfTestRange; i+=.0015748350234587106948317509181) {
            if (this.intTree.tGet(i) == null || this.strTree.tGet(i) == null) {
                System.out.println("Failed retrieval type 1 (null Tree) at index " + i);
                System.exit(1);
            }

            if (this.intTree.eGet(i) != i || !this.strTree.eGet(i).equals(Double.toString(i))) {
                System.out.println("Failed retrieval type 2 (failed/bad node reach) at index " + i);
                System.exit(1);
            }
            System.out.println("index "+i+" passed");
        }
        System.out.println("treeAddGet() passed");
    }

    public static void main(String[] args) {
        DecTreeTester tester = new DecTreeTester();
        tester.treeAddGet();
    }
}