/*
 * DEVELOPER NOTE: Modular memory is NOT our problem. Modular memory can be handled by Generic Arrays.
 * 
 * Semantic Conventions:
 *  CS: Constructor
 *  SM: Static Method
 *  M: Method
 *  TS: Test
 *  opX: the X on which "we" are operating
 *  retX: the X object this method will return
 * 
 *  ^^DON'T OVERUSE THOSE^^
 * 
 * METHOD SUMMARY:
 * 
 * ----STATIC METHODS FIRST----
 * long_boolArray(long value){
 *      turns user valueinto a bit array
 * }
 * 
 * @param <S> Stored Type
 */
public class DecWeb<S> {
    private int P = 64; // P debites the size of the standard infinitesimal value. It stands for "puny".
    // This is its the DecWeb's fundamental relevance.
    public boolean[] tag;
    private DecWeb<S>[] node;
    protected DecWeb<S> sub;

    private S[] stored_data;
    private S data_unit;

    private int localSize;

    // CS (Constructors)

    public DecWeb() {
        // everything else is already null
    }

    public DecWeb(int size) {
        node = (DecWeb<S>[]) new DecWeb[size];
        stored_data = (S[]) new Object[size];
        data_unit = null;
    }

    public DecWeb(int size, int byteSize) {
        {
            node = (DecWeb<S>[]) new DecWeb[size];
            stored_data = (S[]) new Object[size];
            data_unit = null;
        }

        this.P = byteSize;
    }

    public DecWeb(S data_unit) {
        this.data_unit = data_unit;
    }

    public DecWeb(String startupCommand) {
        char SEMANTIC_SEPARATOR = ':';
        String[] operatorList = new String[] { "bootstrap:", "tag:" };

        // string search algorithm
        String command = "";
        int commandLength;
        for (int i = 0; i < operatorList.length; i++) {
            boolean ruledOut = false;
            for (int j = 0; j < operatorList[i].length(); j++) {
                StringBuilder parser = new StringBuilder();
                if (operatorList[i].charAt(j) != startupCommand.charAt(j)) {
                    break;
                }
                if (startupCommand.charAt(j) == ':') {
                    command = parser.toString();
                    commandLength = command.length();
                }
            }
        }

        if (command.equals("bootstrap:")) {

        }

        // execution:
        if (command.equals("tag:")) {
            // will fill in later.
        }
    }

    // SM (Static Methods)
    public boolean[] long_boolArray(long value) {
        int boolean_array_length = 0;
        long temp = value;
        while (temp != 0) {
            temp = temp >> 1;
            boolean_array_length++;
        }

        boolean[] retArr = new boolean[boolean_array_length];
        for (int current_retArr_index = 0; current_retArr_index < P; current_retArr_index++) {
            retArr[current_retArr_index] = (value % 2 == 1);
            value /= 2;
        }

        return retArr;
    }

    protected S add(S stored) {

        this.data_unit = stored;
        return stored;
    }

    public DecWeb<S> add(boolean[] address, S stored) {
        if (address == null || address.length == 0) {
            this.data_unit = stored;
            this.localSize++;
            return this;
        } else {
            DecWeb<S> opWeb = this;
            int index = 0;
            for (int i = 0; i < address.length; i++) {
                index <<= 1;
                if (address[i]) {
                    index += 1;
                }
            }
            opWeb.node[index] = genSub(index, 16);
            localSize++;
            return opWeb.node[index];
        }
    }

    public DecWeb<S> get(int address) {
        return this.node[address];
    }

    public DecWeb<S> get(int address, int depth) {
        DecWeb<S> opWeb = this;
        for (int i = 0; i < depth; i++) {
            opWeb = opWeb.node[address];
        }
        return opWeb;
    }

    public S get(){
        return this.data_unit;
    }

    public DecWeb<S> genSub(int index, int size) {
        DecWeb<S> opWeb = this;
        while (opWeb.node[index]!=null) {
            // while the ghost array shows that the indexed slot in node should be open

            opWeb = opWeb.node[index];
        }
        opWeb.node[index] = new DecWeb<S>(size);
        return opWeb.node[index];
    }
}