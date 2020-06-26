import java.util.ArrayList;

public class DecTreeTester {

    DecTree<String> srcStr;
    DigitTree<Double> srcInt;
    DigitTree<String> strTree;
    DigitTree<Double> intTree;
    int testNum = 0;
    int retVal = 0;

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
    public int afterPass() {
        System.out.printf("Test %s passed.\n\n", testNum++);
        return 0;
    }

    /**
     * Println: Test [caseNumber] FAILED. NO FURTHER DETAILS NOTED.
     * 
     * @return parametrized exit Code
     */
    public int afterFail(int exitCode) {
        System.out.println("Test %s FAILED. NO FURTHER DETAILS NOTED.");
        testNum++;
        return exitCode;
    }

    /**
     * Println: Test [caseNumber] FAILED. [parametrized failInfo string]
     * 
     * @return parametrized exit Code
     */
    public int afterFail(String failInfo, int exitCode) {
        System.out.printf("Test %s FAILED. failINFO:%s\n", testNum++);
        return exitCode;
    }

    public int treeAddGet() {
        double halfTestRange = 9000;
        
        //
        this.before();
        for (double i = -halfTestRange; i < halfTestRange; i++) {
            this.intTree.add(i, i);
            this.strTree.add(i, Double.toString(i));
        }
        System.out.println("set all");
        for (double i = -halfTestRange; i < halfTestRange; i++) {
            if (this.intTree.tGet(i) == null || this.strTree.tGet(i) == null) {
                return afterFail("Failed retrieval type 1 (null Tree) at index " + i, 1);
            }
        }
        return afterPass();
    }

    public static void testAll(String[] args) {

        DecTreeTester tester = new DecTreeTester();
        tester.treeAddGet();
    }
    
    @SuppressWarnings("all")
    public static void main(String[] args) {
        new DecTreeTester().testAll(args);
    }
}