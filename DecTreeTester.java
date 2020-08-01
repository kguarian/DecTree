import java.util.ArrayList;

public class DecTreeTester {
    int testNum = 0;
    int retVal = 0;
    boolean finished = false;
    DecTree<Double> intTree;// oops
    DecTree<String> strTree;

    public void before() {
        System.gc();
        this.strTree = new DecTree<String>();
        this.intTree = new DecTree<Double>();
        System.out.printf("Test %s begin:\n", testNum);
        retVal = 0;
    }

    /**
     * Println: Test [caseNumber] passed [2 x NewLine]
     * 
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
        System.out.printf(
                "Incrementing from -1/%s-10 to 10 by intervals of 1.\"\n. (Hand Note) Passed: already run: verbose output.\n",
                prime);
        for (double i = -1 / ((double) prime) - 10; i < 10; i += 1) {
            this.strTree.add(i, Double.toString(i));
        }
        for (double i = -1 / 7d - 10; i < 10; i += 1) {
            System.out.printf("%s\n", strTree.get(i));
        }
        return callAfterPass();
    }

    public void tsPro() {
        before();
        DecTree<Integer> iTree = new DecTree<Integer>();
        /*
         * /3 p0-E5--| iTree-| \7 $ a0--5--|
         */

        iTree.dev1(3, 3);
        iTree.dev1(5, 5);
        iTree.dev1(7, 7);
        iTree.dev1(-5, -5);
        iTree.dev1(3).dev2(0, iTree.dev1(5));
        iTree.dev1(7).dev2(0, iTree.dev1(5));
        iTree.dev1(5).dev2(0, iTree.dev1(5));
        iTree.dev1(5).dev1(55, 55);
        iTree.dev1(5).dev1(55).tie(iTree.dev1(-5));

        int[] solutions = new int[] { 3, 5, 7, 5, 5, 5, 55, -5, 55, 55 };

        DecTree<Integer>[] answers = (DecTree<Integer>[]) new DecTree[] { iTree.dev1(3), iTree.dev1(5), iTree.dev1(7),
                iTree.dev1(3).dev1(0), iTree.dev1(5).dev1(0), iTree.dev1(7).dev1(0), iTree.dev1(5).dev1(55),
                iTree.dev1(-5), iTree.dev1(-5).dev1 };

        boolean failedTest = false;
        for (int i = 0; i < 9; i++) {
            if (solutions[i] != answers[i].get()) {
                failedTest = true;
                System.out.println("i = " + i + ": " + solutions[i] + " " + answers[i].get());
            }
        }

        if (!failedTest) {
            callAfterPass();
        } else {
            callAfterFail("bad array answers", 0);
        }
    }

    public void tsToString1() {
        before();
        DecTree<Integer> tree = new DecTree<Integer>();
        DecTree<Integer> tree2 = tree.add(7538.8357, null);
        tree2.dev1(7, 7);
        tree2.dev1(5, 5);
        tree2.dev1(3, 3);
        tree2.dev1(-5, -5);
        tree2.dev1(3).dev2(0, tree2.dev1(5));
        tree2.dev1(7).dev2(0, tree2.dev1(5));
        tree2.dev1(5).dev1(55, 55);
        tree2.dev1(-5).dev2(55, tree2.dev1(5).dev1(55));
        System.out.println(tree.toString());
        callAfterPass();
    }

    public void tsToString2() {
        before();
        DecTree<String> sTree = new DecTree<String>();
        sTree.add(1, "The Number One");
        sTree.tGet(1).add(1, "'The Number One' under1").add(1, "'The Number One' under2").add(1,
                "The Number One' under3");
        System.out.println(sTree);
        System.out.println("1:->1:->1:->1\n");
        sTree = new DecTree<String>();
        sTree.add(0, "Zero").dev1(218, "Chopper").dev1(80, "Blue");
        sTree.add(30, "Base");
        sTree.add(39205.3342, "Decimal");
        sTree.tGet(39205.3342).add(387, "Extension");
        sTree.add(22 / 7, "imitation pi");
        sTree.tGet(22 / 7).add(0, "extension");
        System.out.println(sTree);
        callAfterPass();
    }

    public void tsAddSpeed() {
        before();
        long[] results = new long[7];
        ArrayList<Double> dList = new ArrayList<Double>();

        for (int j = 0; j < results.length; j++) {
            Long endTime;
            Long startTime = System.nanoTime();
            for (int i = 0; i < Math.pow(10, j); i++) {
                dList.add(i, (double) i);
            }

            endTime = System.nanoTime();
            results[j] = endTime - startTime;
        }
        System.out.println("AL: ");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
        callAfterPass();

        before();

        DecTree<Double> dTree = new DecTree<Double>();
        for (int j = 0; j < results.length; j++) {
            Long endTime;
            Long startTime = System.nanoTime();
            for (int i = 0; i < Math.pow(10, j); i++) {
                dTree.add(i, (double) i);
            }

            endTime = System.nanoTime();
            results[j] = endTime - startTime;
        }

        System.out.println("DecTree: ");
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
        callAfterPass();

    }

    public static void testAll(String[] args) {

        DecTreeTester tester = new DecTreeTester();
        tester.treeAddGet();
        tester.treeAddGetIrrationals();
        tester.tsPro();
        tester.tsToString1();
        tester.tsToString2();
        tester.tsAddSpeed();
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        new DecTreeTester().testAll(args);
    }
}
