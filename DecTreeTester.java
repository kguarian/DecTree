public class DecTreeTester {

    DecTree<String> srcStr;
    DecTree<Double> srcInt;
    DecTree<String> strTree;
    DecTree<Double> intTree;
    int testNum = 0;
    int retVal = 0;
    boolean finished = false;

    public void before() {
        this.strTree = new DecTree<String>();
        this.intTree = new DecTree<Double>();
        System.out.printf("Test %s begin:\n", testNum);
        retVal = 0;
    }

    /**
     * Println: Test [caseNumber] passed [2 x NewLine]
     * @return 0
     */
    public int callAfterPass() {
        System.out.printf("Test %s passed.\n\n", testNum++);
        return 0;
    }

    /**
     * Println: Test [caseNumber] FAILED. NO FURTHER DETAILS NOTED.
     * 
     * @return parametrized exit Code
     */
    public int callAfterFail(int exitCode) {
        System.out.println("Test %s FAILED. NO FURTHER DETAILS NOTED.");
        testNum++;
        return exitCode;
    }

    /**
     * Println: Test [caseNumber] FAILED. [parametrized failInfo string]
     * 
     * @return parametrized exit Code
     */
    public int callAfterFail(String failInfo, int exitCode) {
        System.out.printf("Test %s FAILED. failINFO:%s\n", testNum++, exitCode);
        return exitCode;
    }

    public int treeAddGet() {
        if (this.finished) {
            System.exit(0);
        }
        final double halfTestRange = 9000;
        //
        this.before();
        for (double i = -halfTestRange; i < halfTestRange; i++) {
            this.intTree.add(i, i);
            this.strTree.add(i, Double.toString(i));
        }
        System.out.println("### Set: Integer and String test values.");
        for (double i = -halfTestRange; i < halfTestRange; i++) {
            if (this.intTree.tGet(i) == null || this.strTree.tGet(i) == null) {
                return callAfterFail("Failed retrieval type 1 (null Tree) at index " + i, 1);
            }
            if (this.intTree.get(i) != i || !this.strTree.get(i).equals(Double.toString(i))) {
                return callAfterFail("Failed retrieval type 2 (incorrect return value) at index " + i, 2);
            }
        }
        return callAfterPass();
    }

    public int treeAddGetIrrationals() {
        if (this.finished) {
            System.exit(0);
        }

        final int prime = 7;
        System.out
                .printf("Incrementing from -1/%s-10 to 10 by intervals of 1.\"\n. (Hand Note) Passed: already run: verbose output.\n", prime);
        for (double i = -1 / ((double) prime) - 10; i < 10; i += 1) {
            this.strTree.add(i, Double.toString(i));
        }
        for (double i = -1 / 7d - 10; i < 10; i += 1) {
            System.out.printf("%s\n", strTree.get(i));
        }
        return callAfterPass();
    }
    
    public void DecNodeProAnti() {

        DecTree<Integer> iTree = new DecTree<Integer>();
        DecNode<Integer> opNode = iTree.add(0, 0).node;
        opNode.pro(7, 7);
        opNode.pro(5, 5);
        opNode.pro(3, 3);
        opNode.anti(-5, -5);
        opNode.pro(3).pro(0, opNode.pro(5));
        opNode.pro(7).pro(0, opNode.pro(5));
        opNode.pro(5).pro(0, 55);
        opNode.anti(-5).pro(0, 55);

        int[] solutions = new int[] { 0, 3, 5, 7, 5, 5, 55, -5, 55 };

        int[] answers = new int[] { opNode.get(), opNode.pro(3).get(), opNode.pro(5).get(), opNode.pro(7).get(),
                opNode.pro(7).pro(0).get(), opNode.pro(3).pro(0).get(), opNode.pro(5).pro(0).get(),
                opNode.anti(-5).get(), opNode.anti(-5).pro(0).get() };

        boolean failedTest = false;
        for (int i = 0; i < 9; i++) {
            if (solutions[i] != answers[i]) {
                System.out.println(i);
                failedTest = true;
            }
        }

        if (!failedTest) {
            callAfterPass();
        } else {
            callAfterFail("bad array answers", 0);
        }
    }
    
    public void tsToString1() {
        DecTree<Integer> tree = new DecTree<Integer>();
        DecTree<Integer> tree2 = tree.add(7538.8357, null);
        DecNode<Integer> opNode = tree2.node;
        opNode.pro(7, 7);
        opNode.pro(5, 5);
        opNode.pro(3, 3);
        opNode.anti(-5, -5);
        opNode.pro(3).pro(0, opNode.pro(5));
        opNode.pro(7).pro(0, opNode.pro(5));
        opNode.pro(5).pro(0, 55);
        opNode.anti(-5).pro(0, 55);
        System.out.println(tree);
    }

    public static void testAll(String[] args) {

        DecTreeTester tester = new DecTreeTester();
        tester.treeAddGet();
        tester.treeAddGetIrrationals();
        tester.DecNodeProAnti();
        tester.tsToString1();
    }
    
    @SuppressWarnings("all")
    public static void main(String[] args) {
        new DecTreeTester().testAll(args);
    }
}