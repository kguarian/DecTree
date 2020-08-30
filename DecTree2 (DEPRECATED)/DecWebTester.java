public class DecWebTester {
    int testNo = -1;

    public void start(){
        System.out.printf("TEST %s START\n", ++testNo);
    }

    public void fail(){
        System.out.printf("test %s failed\n", testNo);
    }
    
    public void basicAddGet(){
        start();
        DecWeb<String> tsWeb = new DecWeb<String>();
        tsWeb.add("simple add");
        if(!tsWeb.get().equals("simple add")){
            fail();
        }

        tsWeb = new DecWeb<String>();
        tsWeb.add(tsWeb.long_boolArray(8), "hello");
        tsWeb.get(8);
    }

    public void runAllTests(){
        basicAddGet();
    }

    public static void main(String[] args) {
        new DecWebTester().runAllTests();
    }
}