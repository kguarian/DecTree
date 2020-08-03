class DecTree<D> {

    protected DecTree parent;
    D dev0;
    DecTree<D> dt0;
    DecTree<D> dt1;
    DecTree<D> dt2;
    DecTree<D> dt3;
    DecTree<D> dt4;
    DecTree<D> dt5;
    DecTree<D> dt6;
    DecTree<D> dt7;
    DecTree<D> dt8;
    DecTree<D> dt9;
    DecTree<D> dtN;
    DecTree<D> dtC;
    DecTree<D> dtD;
    DecTree<D> dev1;
    DecTree<DecTree<D>> dev2;
    double address;
    int type;

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
    public DecTree(D element) {
        this.dev0 = element;
    }

    public DecTree(int type) {
        this.type = type;
    }

    public void element(D element) {
        this.dev0 = element;
    }

    public D element() {
        return this.dev0;
    }

    /**
     * Deep Copy of parametrized DecTree<Operating Type>
     * 
     * @param base
     */
    public DecTree(DecTree<D> base) {
        this.dt0 = base.dt0;
        this.dt1 = base.dt1;
        this.dt2 = base.dt2;
        this.dt3 = base.dt3;
        this.dt4 = base.dt4;
        this.dt5 = base.dt5;
        this.dt6 = base.dt6;
        this.dt7 = base.dt7;
        this.dt8 = base.dt8;
        this.dt9 = base.dt9;
        this.dtN = base.dtN;
        this.dtC = base.dtC;
        this.dtD = base.dtD;
        this.dev2 = base.dev2;
        this.dev1 = base.dev1;
        this.dev0 = base.dev0;
    }

    /**
     * helper method to create dtC Tree if dtN is null then...
     * 
     * @return this.dtC
     */
    protected DecTree<D> ensureDtC() {
        if (this.dtC == null) {
            this.dtC = new DecTree<D>(-3);
            this.dtC.parent = this;
        }
        return this.dtC;
    }

    protected DecTree<DecTree<D>> ensureDev2(){
        if (this.dev2 == null) {
            this.dev2 = new DecTree<DecTree<D>>(-3);
            this.dev2.parent = this;
        }
        return this.dev2;
    }

    protected DecTree<DecTree<D>> ensureDtP() {
        this.dev2 = this.dev2 != null ? this.dev2 : new DecTree<DecTree<D>>();
        return this.dev2;
    }

    /**
     * time-saver.
     * 
     * @param address the double value referencing the DecTree holding the DecNode
     *                it will return
     * @return this.tGet(address).node
     */
    public D dev0(double address) {
        return this.pWdev0(address).dev0();
    }

    public D dev0() {
        return this.dev0;
    }

    public void set(D element) {
        this.dev0 = element;
    }

    /**
     * returns the tree at opTree.dt[X]
     * 
     * @param mod    = [X], N is -1, D is -10
     * @param opTree
     * @return opTree.dt[mod]
     */
    private DecTree<D> $getChildWithIdAndParent(int mod, DecTree<D> opTree) {
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
    protected DecTree<D> $ensureChildWithIdAndParent(int mod, DecTree<D> opTree) {

        if (mod == -10) {
            if (opTree.dtD == null) {
                opTree.dtD = new DecTree<D>(mod);
            }
            opTree = opTree.dtD;
        }
        if (mod == -3) {
            if (opTree.dtC == null) {
                opTree.dtC = new DecTree<D>(mod);
            }
            opTree = opTree.dtC;
        }
        if (mod == -1) {
            if (opTree.dtN == null) {
                opTree.dtN = new DecTree<D>(mod);
            }
            opTree = opTree.dtN;
        } else if (mod == 0) {
            if (opTree.dt0 == null) {
                opTree.dt0 = new DecTree<D>(mod);
            }
            opTree = opTree.dt0;
        } else if (mod == 1) {
            if (opTree.dt1 == null) {
                opTree.dt1 = new DecTree<D>(mod);
            }
            opTree = opTree.dt1;
        } else if (mod == 2) {
            if (opTree.dt2 == null) {
                opTree.dt2 = new DecTree<D>(mod);
            }
            opTree = opTree.dt2;
        } else if (mod == 3) {
            if (opTree.dt3 == null) {
                opTree.dt3 = new DecTree<D>(mod);
            }
            opTree = opTree.dt3;
        } else if (mod == 4) {
            if (opTree.dt4 == null) {
                opTree.dt4 = new DecTree<D>(mod);
            }
            opTree = opTree.dt4;
        } else if (mod == 5) {
            if (opTree.dt5 == null) {
                opTree.dt5 = new DecTree<D>(mod);
            }
            opTree = opTree.dt5;
        } else if (mod == 6) {
            if (opTree.dt6 == null) {
                opTree.dt6 = new DecTree<D>(mod);
            }
            opTree = opTree.dt6;
        } else if (mod == 7) {
            if (opTree.dt7 == null) {
                opTree.dt7 = new DecTree<D>(mod);
            }
            opTree = opTree.dt7;
        } else if (mod == 8) {
            if (opTree.dt8 == null) {
                opTree.dt8 = new DecTree<D>(mod);
            }
            opTree = opTree.dt8;
        } else {
            if (opTree.dt9 == null) {
                opTree.dt9 = new DecTree<D>(mod);
            }
            opTree = opTree.dt9;
        }
        opTree.parent = this;
        opTree.address = mod;
        return opTree;
    }

    /**
     * navigates to the DecTree at the address. Institutes default DecTrees if the
     * necessary addresses don't exist.
     * 
     * @param address
     * @return the addressed DecTree
     */
    protected DecTree<D> paveTo(double address) {
        double copyID = address;
        DecTree<D> opTree = this;
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
     * navigates to the DecTree at the address.
     * 
     * @param address
     * @return the addressed DecTree
     */
    protected DecTree<D> goGrab(double address) {
        double copyID = address;
        DecTree<D> opTree = this;
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
     * addressed DecTree
     * 
     * @param address
     * @param element
     * @return
     */
    public DecTree<D> dev0(double address, D element) {
        DecTree<D> opTree = this.paveTo(address);
        while (opTree.dtC != null) {
            opTree = opTree.dtC;
        }
        DecTree<D> retTree = opTree.ensureDtC();
        retTree.dev0=element;
        return retTree;
    }

    @Override
    public String toString() {
        String retString = this.dev0 != null ? this.type + ": " + this.dev0 + " " : "";

        // CODE BLOCK
        {
            DecTree<D> opTree = this.dt0;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dt1;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dt2;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dt3;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dt4;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dt5;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dt6;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dt7;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dt8;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dt9;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dtN;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dtC;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dtD;
            if (opTree != null) {
                retString += opTree.toString();
            }
            opTree = this.dev1;
            if (opTree != null) {
                retString += opTree.toString();
            }
            if (this.dev2 != null) {
                retString += this.dev2.toString();
            }
        }
        // END CODE BLOCK

        return retString;
    }

    /**
     * returns the DecTree at the parametrized address
     * 
     * @param address
     * @return in description
     */
    public DecTree<D> pWdev0(double address) {
        return this.goGrab(address).dtC;
    }

    public D pGet() {
        return this.dev2.dev0.dev0();
    }

    /**
     * replaces the DecTree at the parametrized address with the parametrized tree
     * 
     * @param address
     * @param tree
     */
    public void r_dev0(double address, DecTree<D> tree) {
        DecTree<D> opTree = this.goGrab(address
                - (address / Math.pow(10, (int) Math.log10(address)) * (Math.pow(10, (int) Math.log10(address) - 1)))); // first//
                                                                                                                        // digit
        $getChildWithIdAndParent(0, opTree);
    }

    public void tr_dev0(DecTree<D> tree) {
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
        this.dev2 = tree.dev2;
        this.dev0 = tree.dev0;
    }

    /**
     * will pop the prominent tree from the chain of children of the tree at the
     * parametrized address then substitute it with the one added subsequently
     * 
     * @param address
     */
    public void eksdev0(double address) {// remove at dev0
        DecTree<D> opTree = this.pWdev0(address);
        while (opTree.dtC != null) {
            opTree.dev0 = opTree.dtC.dev0;
            opTree = opTree.dtC;
        }
        opTree.dev0 = null;
    }

    /**
     * removes the chain of entries deposited at the parametrized address
     * 
     * @param address
     */
    public void eksyldev0(double address) {// remove this and all children at and under dev0
        DecTree<D> opTree = this.goGrab(address);
        opTree.dtC = null;
    }

    /**
     * removes the whole chain of entries deposited at the parametrized address
     * 
     * @param address
     */
    public void rmTree(double address) {
        DecTree<D> opTree = this.goGrab(address).parent;
        byte firstDigit = (byte) (address / Math.pow(10, Math.log10(address)) + Double.MIN_VALUE);

        // gets first digit of address, should account for floating point errors too
        // except those within minval of specified address
        // Extension cord?
        // (constant).
        // also byte's smaller than double XD
        opTree = $getChildWithIdAndParent(firstDigit, opTree);
        opTree = new DecTree<D>(firstDigit);
    }

    public DecTree<D> dev1(double address) {
        return this.dev2.dev0(address);
    }

    protected DecTree<DecTree<D>> dev2() {
        return this.dev2;
    }
    // TODO: REMOVE dev2() BEFORE FINAL!!!

    public DecTree<D> dev1(double address, D element) {
        this.dev2 = this.dev2 != null ? this.dev2 : new DecTree<DecTree<D>>();
        return this.ensureDev2().dev0(address, new DecTree<D>(element)).dev0();
    }

    public DecTree<DecTree<D>> dev2(double address) {
        return this.ensureDev2().goGrab(address).dtC;
    }

    public DecTree<DecTree<D>> dev2(double address, DecTree<D> tree) {
        return this.ensureDev2().dev0(address, tree);
    }

    public void tie(DecTree<D> otherTree) {
        otherTree.dev1 = this;
        this.dev1 = otherTree;
    }

    public double getAddress() {
        String addressString = "";
        DecTree<D> opTree = this;
        while (opTree.parent != null) {
            opTree = opTree.parent;
            if (opTree.address == -3) {
                return Double.parseDouble(addressString);
            }
            addressString = opTree.address >= 0 ? Long.toString((long) opTree.address)
                    : opTree.address == -1 ? "-" : "." + addressString;
            System.out.println(addressString);
        }
        return Double.parseDouble(addressString);
    }
}
