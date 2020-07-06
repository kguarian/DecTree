public class DecTreeTester {

    DecTree<String> srcStr;
    DigitTree<Double> srcInt;
    DigitTree<String> strTree;
    DigitTree<Double> intTree;
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
        System.out.printf("Test %s FAILED. failINFO:%s\n", testNum++);
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
            if (this.intTree.eGet(i) != i || !this.strTree.eGet(i).equals(Double.toString(i))) {
                return callAfterFail("Failed retrieval type 2 (incorrect return value) at index " + i, 2);
            }
        }
        return callAfterPass();
    }

    public int treeAddGetIrrationals() {
        if (this.finished) {
            System.exit(0);
        }
        
        System.out.println("Incrementing from -1/prime -10 to 10 by intervals of 1.\"");
        for (double i = -1/7d - 10; i < 10; i +=1) {
            this.strTree.add(i, Double.toString(i));
        }
        for (double i = -1 / 7d - 10; i < 10; i += 1) {
            System.out.printf("%s\n", strTree.eGet(i));
        }
        return 0;
    }

    public static void testAll(String[] args) {

        DecTreeTester tester = new DecTreeTester();
        tester.treeAddGet();
        tester.treeAddGetIrrationals();
    }
    
    @SuppressWarnings("all")
    public static void main(String[] args) {
        new DecTreeTester().testAll(args);
    }
}