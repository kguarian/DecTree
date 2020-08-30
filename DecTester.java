import java.util.HashMap;

public class DecTester {
    public static void tsAdd() {
        DecTree<String> tsTree = new DecTree<String>();
        for (double i = 0; i < 10; i += 0.1 / (++i)) {
            tsTree.add(i * i, Double.toString(i));
        }
        try {
            for (double i = 0; i < 10; i += 0.1 / (++i)) {
                System.out.println(tsTree.get(i * i));
            }
        } catch (NullPointerException e) {
            System.out.println("add/get test failed (tsAdd");
        }
    }

    public static void tsNest(){
        DecTree<DecTree> ts = new DecTree<DecTree>();
        DecTree<Integer> tsInt = new DecTree<Integer>();
        DecTree<String> tsStr = new DecTree<String>();
        DecTree<HashMap> tsHash = new DecTree<HashMap>();

        Integer valueInt = Integer.valueOf(512);
        String valueStr = "hello";
        HashMap<Integer, String> valueHash = new HashMap<Integer, String>();

        tsInt.add(512, valueInt);
        tsStr.add(0.1134, valueStr);
        tsHash.add(3453, valueHash);

        ts.add(0,tsInt).add(0,tsStr).add(0,tsHash);

        System.out.println(ts.get(0).get(512)==valueInt);
        System.out.println(ts.tGet(0).get(0).get(0.1134)==valueStr);
        System.out.println(ts.tGet(0).tGet(0).get(0).get(3453)==valueHash);
        System.out.println(ts.toString());
    }

    public static void tsToString(){
        DecTree<String> tsDecTree = new DecTree<String>();
        for(int i = 0; i < 5; i++){
            tsDecTree.add(i,"Element");
        }
        System.out.println(tsDecTree.toString());
    }

    public static void tsToFromString(){
        DecTree<String> tsTree = new DecTree<String>();
        for(int i = 0; i < 5; i++){
            tsTree.add(i,"Element");
        }
        DecTree<String> coTree = tsTree.fromString(tsTree.toString());
        for(int i = 0; i < 5; i++){
            System.out.println(tsTree.get(i));
        }
    }

    public static void tests() {
        tsAdd();
        tsNest();
        tsToString();
        tsToFromString();
    }

    public static void main(String[] args) {
        tests();
    }
}