
/**
 * DecTree: Generic-typed Tree/Linkable structure.
 * 
 * @param <E> Whatever java object you need to store.
 * 
 *            METHOD SUMMARY: public DecTree() Does nothing. public DecTree(E
 *            element) creates DecTree
 */

public class DecTree<E> {

    E data;
    // stored
    DecTree<E> dt0;
    DecTree<E> dt1;
    DecTree<E> dt2;
    DecTree<E> dt3;
    DecTree<E> dt4;
    DecTree<E> dt5;
    DecTree<E> dt6;
    DecTree<E> dt7;
    DecTree<E> dt8;
    DecTree<E> dt9;
    // Numerical
    DecTree<E> dtN;
    // negative
    DecTree<E> dtC;
    // child
    DecTree<E> dtD;
    // decimal
    DecTree<E> dtP;
    // dec tree parent
    DecTree<E> dev;
    //for developer use. Be Responsible. Be Creative. Be Productive.
    double ref;
    //
    DecTree<String> tags;
    private int size = 0;

    int type;
    // dev type

    /**
     * Default constructor enables specialized constructors
     */
    public DecTree() {
    }

    /**
     * The Zero Value is usually null, but if you want a null value to represent a
     * nonzero value, feel free to parametrize it here.
     * 
     * @param zeroValue customized zero/null value.
     */
    public DecTree(E element) {
        this.data = element;
    }

    public DecTree(int type) {
        this.type = type;
    }

    public E element() {
        return this.data;
    }

    /**
     * Deep Copy of parametrized DecTree<Operating Type>
     * 
     * @param base
     */
    public DecTree(DecTree<E> base) {
        this.dt0 = new DecTree<E>(base.dt0);
        this.dt1 = new DecTree<E>(base.dt1);
        this.dt2 = new DecTree<E>(base.dt2);
        this.dt3 = new DecTree<E>(base.dt3);
        this.dt4 = new DecTree<E>(base.dt4);
        this.dt5 = new DecTree<E>(base.dt5);
        this.dt6 = new DecTree<E>(base.dt6);
        this.dt7 = new DecTree<E>(base.dt7);
        this.dt8 = new DecTree<E>(base.dt8);
        this.dt9 = new DecTree<E>(base.dt9);
        this.dtN = new DecTree<E>(base.dtN);
        this.dtC = new DecTree<E>(base.dtC);
        this.dtD = new DecTree<E>(base.dtD);
        this.dtP = new DecTree<E>(base.dtP);
        this.data = base.data;
        this.type = base.type;
        this.ref = base.ref;
    }

    /**
     * helper method to create dtC Tree if dtN is null then...
     * 
     * @return this.dtC
     */
    protected DecTree<E> e_dtC() {
        if (this.dtC == null) {
            this.dtC = new DecTree<E>(-3);
            this.dtC.dtP = this;
        }
        return this.dtC;
    }

    /**
     * time-saver.
     * 
     * @param address the double value referencing the Dec holding the DecNode it
     *                will return
     * @return this.tGet(address).node
     */
    public E getData(double address) {
        return this.tGet(address).data;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E element) {
        this.data = element;
    }

    /**
     * returns the tree at opTree.dt[X]
     * 
     * @param mod    = [X], N is -1, D is -10
     * @param opTree
     * @return opTree.dt[mod]
     */
    protected DecTree<E> $getChildWithIdAndParent(int mod, DecTree<E> opTree) throws NullPointerException {
        if (mod == -10) {
            opTree = opTree.dtD;
        }
        if (mod == -3) {
            opTree = opTree.dtC;
        } else if (mod == -1) {
            opTree = opTree.dtN;
        } else if (mod == 0) {
            opTree = opTree.dt0;
        } else if (mod == 1) {
            opTree = opTree.dt1;
        } else if (mod == 2) {
            opTree = opTree.dt2;
        } else if (mod == 3) {
            opTree = opTree.dt3;
        } else if (mod == 4) {
            opTree = opTree.dt4;
        } else if (mod == 5) {
            opTree = opTree.dt5;
        } else if (mod == 6) {
            opTree = opTree.dt6;
        } else if (mod == 7) {
            opTree = opTree.dt7;
        } else if (mod == 8) {
            opTree = opTree.dt8;
        } else {
            opTree = opTree.dt9;
        }
        return opTree;
    }

    /**
     * returns the tree at dt[X]. Creates it first if it is null.
     * 
     * @param mod    = [X], N is -1, D is -10
     * @param opTree
     * @return opTree.dt[mod]
     */
    protected DecTree<E> $ensureChildWithIdAndParent(int mod, DecTree<E> opTree) {

        if (mod == -10) {
            if (opTree.dtD == null) {
                opTree.dtD = new DecTree<E>(mod);
            }
            opTree = opTree.dtD;
        }
        if (mod == -3) {
            if (opTree.dtC == null) {
                opTree.dtC = new DecTree<E>(mod);
            }
            opTree = opTree.dtC;
        }
        if (mod == -1) {
            if (opTree.dtN == null) {
                opTree.dtN = new DecTree<E>(mod);
            }
            opTree = opTree.dtN;
        } else if (mod == 0) {
            if (opTree.dt0 == null) {
                opTree.dt0 = new DecTree<E>(mod);
            }
            opTree = opTree.dt0;
        } else if (mod == 1) {
            if (opTree.dt1 == null) {
                opTree.dt1 = new DecTree<E>(mod);
            }
            opTree = opTree.dt1;
        } else if (mod == 2) {
            if (opTree.dt2 == null) {
                opTree.dt2 = new DecTree<E>(mod);
            }
            opTree = opTree.dt2;
        } else if (mod == 3) {
            if (opTree.dt3 == null) {
                opTree.dt3 = new DecTree<E>(mod);
            }
            opTree = opTree.dt3;
        } else if (mod == 4) {
            if (opTree.dt4 == null) {
                opTree.dt4 = new DecTree<E>(mod);
            }
            opTree = opTree.dt4;
        } else if (mod == 5) {
            if (opTree.dt5 == null) {
                opTree.dt5 = new DecTree<E>(mod);
            }
            opTree = opTree.dt5;
        } else if (mod == 6) {
            if (opTree.dt6 == null) {
                opTree.dt6 = new DecTree<E>(mod);
            }
            opTree = opTree.dt6;
        } else if (mod == 7) {
            if (opTree.dt7 == null) {
                opTree.dt7 = new DecTree<E>(mod);
            }
            opTree = opTree.dt7;
        } else if (mod == 8) {
            if (opTree.dt8 == null) {
                opTree.dt8 = new DecTree<E>(mod);
            }
            opTree = opTree.dt8;
        } else {
            if (opTree.dt9 == null) {
                opTree.dt9 = new DecTree<E>(mod);
            }
            opTree = opTree.dt9;
        }
        opTree.dtP = this;
        opTree.ref = mod;
        return opTree;
    }

    /**
     * navigates to the Dec at the address. Institutes default Decs if the necessary
     * addresses don't exist.
     * 
     * @param address
     * @return the addressed Dec
     */
    protected DecTree<E> paveTo(double address) {
        double copyID = address;
        DecTree<E> opTree = this;
        if (copyID < 0) {
            copyID *= -1;
            opTree = $ensureChildWithIdAndParent(-1, opTree);
        }
        while (copyID >= 1) {
            int mod = (int) copyID % 10;
            copyID /= 10;
            opTree = $ensureChildWithIdAndParent(mod, opTree);
        }
        opTree = $ensureChildWithIdAndParent(-10, opTree);
        while (copyID > 0) {
            copyID *= 10;
            int floorDecaID = (int) copyID;
            copyID -= floorDecaID;
            opTree = $ensureChildWithIdAndParent(floorDecaID, opTree);
        }
        return opTree;
    }

    /**
     * navigates to the Dec at the address.
     * 
     * @param address
     * @return the addressed Dec
     */
    protected DecTree<E> goGrab(double address) throws NullPointerException{
        double copyID = address;
        DecTree<E> opTree = this;
        if (copyID < 0) {
            copyID *= -1;
            opTree = $getChildWithIdAndParent(-1, opTree);
        }
        while (copyID >= 1) {
            int mod = (int) copyID % 10;
            copyID /= 10;
            opTree = $getChildWithIdAndParent(mod, opTree);
        }
        opTree = $getChildWithIdAndParent(-10, opTree);
        while (copyID > 0) {
            copyID *= 10;
            int floorDecaID = (int) copyID;
            copyID -= floorDecaID;
            opTree = $getChildWithIdAndParent(floorDecaID, opTree);
        }
        return opTree;
    }

    /**
     * places a DecNode containing the parametrized element in a decNode under the
     * addressed Dec
     * 
     * @param address
     * @param element
     * @return
     */
    public DecTree<E> add(double address, E element) {
        DecTree<E> opTree = this.paveTo(address);
        while (opTree.dtC != null) {
            opTree = opTree.dtC;
        }
        DecTree<E> retTree = opTree.e_dtC();
        retTree.data = element;
        return retTree;
    }

    public DecTree<E> add(E element) {
        return this.add(size++, element);
    }

    public boolean rm() {
        DecTree<E> opTree = this;
        while (opTree.dtC != null) {
            opTree.data = opTree.dtC.data;
            opTree = opTree.dtC;
        }
        opTree.data = null;
        return true;
    }

    /**
     * returns the Dec at the parametrized address
     * 
     * @param address
     * @return in description
     */
    public DecTree<E> tGet(double address) throws NullPointerException{// read dev0
        return this.goGrab(address).dtC;
    }

    public E get(double address) {
        return this.goGrab(address).dtC.data;
    }

    /**
     * replaces the Dec at the parametrized address with the parametrized tree
     * 
     * @param address
     * @param tree
     */
    public void tGet(double address, DecTree<E> tree) {
        DecTree<E> opTree = this.goGrab(address
                - (address / Math.pow(10, (int) Math.log10(address)) * (Math.pow(10, (int) Math.log10(address) - 1)))); // first//
                                                                                                                        // digit
        $getChildWithIdAndParent(0, opTree);
    }

    public void moldAfter(DecTree<E> tree) {
        this.dt0 = tree.dt0;
        this.dt1 = tree.dt1;
        this.dt2 = tree.dt2;
        this.dt3 = tree.dt3;
        this.dt4 = tree.dt4;
        this.dt5 = tree.dt5;
        this.dt6 = tree.dt6;
        this.dt7 = tree.dt7;
        this.dt8 = tree.dt8;
        this.dt9 = tree.dt9;
        this.dtN = tree.dtN;
        this.dtC = tree.dtC;
        this.dtD = tree.dtD;
        this.data = tree.data;
    }

    /**
     * will pop the prominent tree from the chain of children of the tree at the
     * parametrized address then substitute it with the one added subsequently
     * 
     * @param address
     */
    public boolean rm(double address) {// remove at dev0
        DecTree<E> opTree = this.tGet(address);
        return opTree.rm();
    }

    public void rmAll(double address) {
        this.tGet(address).dt0 = null;
    }

    /**
     * removes the whole chain of entries deposited at the parametrized address
     * 
     * @param address
     */
    public void rmTree(double address) {
        DecTree<E> opTree = this.goGrab(address).dtP;
        byte firstDigit = (byte) (address / Math.pow(10, Math.log10(address)) + Double.MIN_VALUE);

        // gets first digit of address, should account for floating point errors too
        // except those within minval of specified address
        // Extension cord?
        // (constant).
        // also byte's smaller than double XD
        opTree = $getChildWithIdAndParent(firstDigit, opTree);
        opTree = new DecTree<E>(firstDigit);
    }

    public double getAddress() {
        String addressString = "";
        DecTree<E> opTree = this;
        while (opTree.dtP != null) {
            opTree = opTree.dtP;
            if (opTree.ref == -3) {
                return Double.parseDouble(addressString);
            }
            addressString = opTree.ref >= 0 ? Long.toString((long) opTree.ref)
                    : opTree.ref == -1 ? "-" : "." + addressString;
            System.out.println(addressString);
        }
        return Double.parseDouble(addressString);
    }

    @Override
    public String toString() {
        // setup
        char nullElement = 'ɩ';
        char treeInit = '»';
        char dataInit = '>';
        char dataTerm = '<';
        char treeTerm = '«';

        DecTree<E> opTree = this;
        String retString = Character.toString(treeInit);

        if (opTree.data == null) {
            retString += nullElement;
        } else {
            retString += (dataInit + opTree.data.toString() + dataTerm);
        }
        if (opTree.dt0 != null) {
            retString += ('0' + opTree.dt0.toString());
        }
        if (opTree.dt1 != null) {
            retString += ('1' + opTree.dt1.toString());
        }
        if (opTree.dt2 != null) {
            retString += ('2' + opTree.dt2.toString());
        }
        if (opTree.dt3 != null) {
            retString += ('3' + opTree.dt3.toString());
        }
        if (opTree.dt4 != null) {
            retString += ('4' + opTree.dt4.toString());
        }
        if (opTree.dt5 != null) {
            retString += ('5' + opTree.dt5.toString());
        }
        if (opTree.dt6 != null) {
            retString += ('6' + opTree.dt6.toString());
        }
        if (opTree.dt7 != null) {
            retString += ('7' + opTree.dt7.toString());
        }
        if (opTree.dt8 != null) {
            retString += ('8' + opTree.dt8.toString());
        }
        if (opTree.dt9 != null) {
            retString += ('9' + opTree.dt9.toString());
        }
        if (opTree.dtD != null) {
            retString += ('D' + opTree.dtD.toString());
        }
        if (opTree.dtN != null) {
            retString += ('N' + opTree.dtN.toString());
        }
        if (opTree.dtC != null) {
            retString += ('C' + opTree.dtC.toString()); // most frequently used. move to front if toString speed is an
                                                        // issue
        }
        retString += treeTerm;
        return retString;
    }

    // *****TODO: UNFINISHED!!! ONLY COMMITTED FOR RICKY. */
    public DecTree<String> fromString(String input) {
        // setup
        char nullElement = 'ɩ';
        char treeInit = '»';
        char dataInit = '>';
        char dataTerm = '<';
        char treeTerm = '«';

        DecTree<String> retTree = new DecTree<String>();
        DecTree<String> opTree = retTree;

        for (int i = 0; i < input.length(); i++) {
            int nextTree = 401; // Not Found XD
            if (input.charAt(i) == treeTerm) {
                opTree = opTree.dtP;
            }
            else if (input.charAt(i) == nullElement) {
                opTree.data = null;
                continue;
            } else if (input.charAt(i) == dataInit) {
                String newData = "";
                for (int j = i; input.charAt(j) != dataTerm; j++) {
                    newData += input.charAt(j);
                }
                opTree.data = newData;
            } else if (input.charAt(i) == '0') {
                nextTree = 0;
                opTree.dt0 = opTree.$ensureChildWithIdAndParent(0, opTree);
            } else if (input.charAt(i) == '1') {
                nextTree = 1;
                opTree.dt1 = opTree.$ensureChildWithIdAndParent(1, opTree);
            } else if (input.charAt(i) == '2') {
                nextTree = 2;
                opTree.dt2 = opTree.$ensureChildWithIdAndParent(2, opTree);
            } else if (input.charAt(i) == '3') {
                nextTree = 3;
                opTree.dt3 = opTree.$ensureChildWithIdAndParent(3, opTree);
            } else if (input.charAt(i) == '4') {
                nextTree = 4;
                opTree.dt4 = opTree.$ensureChildWithIdAndParent(4, opTree);
            } else if (input.charAt(i) == '5') {
                nextTree = 5;
                opTree.dt5 = opTree.$ensureChildWithIdAndParent(5, opTree);
            } else if (input.charAt(i) == '6') {
                nextTree = 6;
                opTree.dt6 = opTree.$ensureChildWithIdAndParent(6, opTree);
            } else if (input.charAt(i) == '7') {
                nextTree = 7;
                opTree.dt7 = opTree.$ensureChildWithIdAndParent(7, opTree);
            } else if (input.charAt(i) == '8') {
                nextTree = 8;
                opTree.dt8 = opTree.$ensureChildWithIdAndParent(8, opTree);
            } else if (input.charAt(i) == '9') {
                nextTree = 9;
                opTree.dt9 = opTree.$ensureChildWithIdAndParent(9, opTree);
            } else if (input.charAt(i) == 'C') {
                nextTree = -3;
                opTree.dtC = opTree.$ensureChildWithIdAndParent(-3, opTree);
            } else if (input.charAt(i) == 'D') {
                nextTree = -10;
                opTree.dtD = opTree.$ensureChildWithIdAndParent(-10, opTree);
            } else if (input.charAt(i) == 'N') {
                nextTree = -1;
                opTree.dtN = opTree.$ensureChildWithIdAndParent(-1, opTree);
            } else if (input.charAt(i) == treeInit) {
                switch (nextTree) {
                    case 0:
                        opTree = opTree.dt0;
                        break;
                    case 1:
                        opTree = opTree.dt1;
                        break;
                    case 2:
                        opTree = opTree.dt2;
                        break;
                    case 3:
                        opTree = opTree.dt3;
                        break;
                    case 4:
                        opTree = opTree.dt4;
                        break;
                    case 5:
                        opTree = opTree.dt5;
                        break;
                    case 6:
                        opTree = opTree.dt6;
                        break;
                    case 7:
                        opTree = opTree.dt7;
                        break;
                    case 8:
                        opTree = opTree.dt8;
                        break;
                    case 9:
                        opTree = opTree.dt9;
                        break;
                    case -1:
                        opTree = opTree.dtN;
                        break;
                    case -3:
                        opTree = opTree.dtC;
                        break;
                    case -10:
                        opTree = opTree.dtD;
                        break;

                    default:
                        System.out.println(i+", "+nextTree);
                        throw new IllegalArgumentException();
                }
            }

        }
        return retTree;
    }

    /*
     * public DecTree<E> readIn(String origString){ int stringPos = 0; }
     */

    public static void main(String[] args) {
        DecTree<String> demoTree = new DecTree<String>();
        for(long i = 0; true; i++){
            demoTree.dt0=demoTree.$ensureChildWithIdAndParent(0,demoTree);
            demoTree=demoTree.dt0;
            System.out.println(i);
        }
    }

}
