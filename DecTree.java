public class DecTree<E> implements DigitTree<E> {

    protected DecTree<E> parent;
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
    DecTree<E> dtN;
    DecTree<E> dtC;
    DecTree<E> dtD;
    DecNode<E> node;
    int infoTag;
    E zero = null;

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
    public DecTree(E zeroValue) {
        this.zero = zeroValue;
    }

    /**
     * Deep Copy of parametrized DecTree<Operating Type>
     * 
     * @param base
     */
    public DecTree(DecTree<E> base) {
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
        this.node = base.node;
        this.zero = base.zero;
    }

    public DecTree<E> newChild() {
        DecTree<E> retTree = new DecTree<E>();
        retTree.parent = this;
        return retTree;
    }

    /**
     * helper method to create dtN Tree if dtN is null then...
     * 
     * @return this.dtN
     */
    protected DecTree<E> ensureDtD() {
        if (this.dtD == null) {
            this.dtD = newChild();
        }
        return this.dtD;
    }

    /**
     * helper method to create new node id node is null then...
     * 
     * @return this.node
     */
    protected DecNode<E> ensureNode() {
        if (this.node == null) {
            this.node = new DecNode<E>();
        }
        return this.node;
    }

    /**
     * time-saver.
     * 
     * @param address the double value referencing the DecTree holding the DecNode
     *                it will return
     * @return this.tGet(address).node
     */
    public DecNode<E> nGet(double address) {
        return this.tGet(address).node;
    }

    /**
     * sets node instance var to parametrized DecNode<Type>
     * 
     * @param replacement DecNode<Type>
     * @param return      void
     */
    public void nSet(DecNode<E> reset) {
        this.node = reset;
    }

    /**
     * returns data value stored by the DecTree<Type>
     * 
     * @param address the double value address whose data value will be returned
     * @return the addressed data value
     */
    public E get(double address) {
        DecTree<E> opTree = this.goGrab(address).dtD;
        return opTree.node.get();
    }

    /**
     * returns the tree at opTree.dt[X]
     * 
     * @param mod    = [X], N is -1, D is -10
     * @param opTree
     * @return opTree.dt[mod]
     */
    private DecTree<E> $getChildWithIdAndParent(int mod, DecTree<E> opTree) {
        if (mod == -10) {
            opTree = opTree.dtD;
        }
        if (mod == -3) {
            opTree = opTree.dtC;
        }
        else if (mod == -1) {
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
                opTree.dtD = newChild();
            }
            opTree = opTree.dtD;
        }
        if (mod == -3) {
            if (opTree.dtC == null) {
                opTree.dtC = newChild();
            }
            opTree = opTree.dtC;
        }
        if (mod == -1) {
            if (opTree.dtN == null) {
                opTree.dtN = newChild();
            }
            opTree = opTree.dtN;
        } else if (mod == 0) {
            if (opTree.dt0 == null) {
                opTree.dt0 = newChild();
            }
            opTree = opTree.dt0;
        } else if (mod == 1) {
            if (opTree.dt1 == null) {
                opTree.dt1 = newChild();
            }
            opTree = opTree.dt1;
        } else if (mod == 2) {
            if (opTree.dt2 == null) {
                opTree.dt2 = newChild();
            }
            opTree = opTree.dt2;
        } else if (mod == 3) {
            if (opTree.dt3 == null) {
                opTree.dt3 = newChild();
            }
            opTree = opTree.dt3;
        } else if (mod == 4) {
            if (opTree.dt4 == null) {
                opTree.dt4 = newChild();
            }
            opTree = opTree.dt4;
        } else if (mod == 5) {
            if (opTree.dt5 == null) {
                opTree.dt5 = newChild();
            }
            opTree = opTree.dt5;
        } else if (mod == 6) {
            if (opTree.dt6 == null) {
                opTree.dt6 = newChild();
            }
            opTree = opTree.dt6;
        } else if (mod == 7) {
            if (opTree.dt7 == null) {
                opTree.dt7 = newChild();
            }
            opTree = opTree.dt7;
        } else if (mod == 8) {
            if (opTree.dt8 == null) {
                opTree.dt8 = newChild();
            }
            opTree = opTree.dt8;
        } else {
            if (opTree.dt9 == null) {
                opTree.dt9 = newChild();
            }
            opTree = opTree.dt9;
        }
        opTree.parent = this;
        opTree.infoTag = mod;
        return opTree;
    }

    /**
     * navigates to the DecTree at the address. Institutes default DecTrees if the
     * necessary addresses don't exist.
     * 
     * @param address
     * @return the addressed DecTree
     */
    protected DecTree<E> paveTo(double address) {
        double copyID = address;
        DecTree<E> opTree = this;
        if (copyID < 0) {
            copyID *= -1;
            opTree = opTree.$ensureChildWithIdAndParent(-1, opTree);
        }
        while (copyID >= 1) {
            int mod = (int) copyID % 10;
            copyID /= 10;
            opTree = opTree.$ensureChildWithIdAndParent(mod, opTree);
        }
        opTree = opTree.$ensureChildWithIdAndParent(-10, opTree);
        while (copyID > 0) {
            copyID *= 10;
            int floorDecaID = (int) copyID;
            copyID -= floorDecaID;
            opTree = opTree.$ensureChildWithIdAndParent(floorDecaID, opTree);
        }
        return opTree;
    }

    /**
     * navigates to the DecTree at the address.
     * 
     * @param address
     * @return the addressed DecTree
     */
    protected DecTree<E> goGrab(double address) {
        double copyID = address;
        DecTree<E> opTree = this;
        if (copyID < 0) {
            copyID *= -1;
            opTree = opTree.$getChildWithIdAndParent(-1, opTree);
        }
        while (copyID >= 1) {
            int mod = (int) copyID % 10;
            copyID /= 10;
            opTree = opTree.$getChildWithIdAndParent(mod, opTree);
        }
        opTree = opTree.$getChildWithIdAndParent(-10, opTree);
        while (copyID > 0) {
            copyID *= 10;
            int floorDecaID = (int) copyID;
            copyID -= floorDecaID;
            opTree = opTree.$getChildWithIdAndParent(floorDecaID, opTree);
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
    public DecTree<E> add(double address, E element) {
        DecTree<E> opTree = this.paveTo(address);
        opTree.ensureDtD().ensureNode().set(element);
        return opTree.dtD;
    }

    @Override
    public String toString() {
        int[] indexes = new int[] { -3, -10, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        StringBuilder retSB = new StringBuilder();
        DecTree<E> opTree = this;
        for (int i = 0; i < indexes.length; i++) {
            try {
                if (i < 3) {// only place where the special cases come up. saving runtime... kinda greedily.
                    if (i == 0) {// in order of hits I think are most likely to least likely
                        retSB.append("Child: ");
                    } else if (i == 2) {
                        retSB.append("Negative: ");
                    } else if (i == 1) {
                        retSB.append("Point: ");
                    }
                } else {
                    retSB.append(indexes[i - 3]);
                }
                retSB.append($getChildWithIdAndParent(indexes[i], opTree).toString() + "/n");
            } catch (NullPointerException e) {
            }
        }
        return retSB.toString();
    }

    /**
     * returns the DecTree at the parametrized address
     * 
     * @param address
     * @return in description
     */
    public DecTree<E> tGet(double address) {
        return this.goGrab(address).dtD;
    }

    /**
     * replaces the DecTree at the parametrized address with the parametrized tree
     * 
     * @param address
     * @param tree
     */
    public void tReplace(double address, DecTree<E> tree) {
        DecTree<E> opTree = this.goGrab(address);
        opTree.dt0 = tree.dt0;
        opTree.dt1 = tree.dt1;
        opTree.dt2 = tree.dt2;
        opTree.dt3 = tree.dt3;
        opTree.dt4 = tree.dt4;
        opTree.dt5 = tree.dt5;
        opTree.dt6 = tree.dt6;
        opTree.dt7 = tree.dt7;
        opTree.dt8 = tree.dt8;
        opTree.dt9 = tree.dt9;
        opTree.dtN = tree.dtN;
        opTree.dtC = tree.dtC;
        opTree.dtD = tree.dtD;
        opTree.node = tree.node;
        opTree.zero = tree.zero;
    }

    /**
     * will pop the prominent tree from the chain of children of the tree at the
     * parametrized address then substitute it with the one added subsequently
     * 
     * @param address
     */
    public void pop(double address) {
        try {
            DecTree<E> opTree = this.goGrab(address).dtC;
            opTree = opTree.dtC;
        } catch (NullPointerException e) {
        }
    }

    /**
     * removes the chain of entries deposited at the parametrized address
     * 
     * @param address
     */
    public void rmChain(double address) {
        DecTree<E> opTree = this.goGrab(address);
        opTree.dtC = null;
    }

    /**
     * removes the whole chain of entries deposited at the parametrized address
     * 
     * @param address
     */
    public void rmTree(double address) {
        DecTree<E> opTree = this.goGrab(address).parent;
        opTree.dtC = null;
    }
}

class DecNode<E> implements DigitNode<E> {

    DecTree<DecNode<E>> pro;
    DecTree<DecNode<E>> anti;
    boolean vacant;
    DecTree<E> id; // TODO: Do I want id parametrized?? Hackability? Could be a fun tool.
    E element;

    public DecNode() {
        pro = null;
        anti = null;
        vacant = true;
        id = null;
        this.element = null;
    }

    /**
     * Default constructor, plus sets parametrized element in this DecNode;
     * @param element
     */
    public DecNode(E element) {
        pro = null;
        anti = null;
        vacant = true;
        id = null;
        this.element = element;
    }

    /**
     * returns the node stored in the parametrized index of the pro tree. More options, and allows for a tree-stationary  linking
     * @param address
     * @return
     */
    public DecNode<DecNode<E>> proNode(double address) {
        return pro.goGrab(address).node;
    }

    /**
     * returns the node stored in the parametrized index of the anti tree
     * @param address
     * @return
     */
    public DecNode<DecNode<E>> antiNode(double address) {
        return anti.goGrab(address).node;
    }

    /**
     * returns the deposited node at the parametrized address in the pro tree
     * @param address
     * @return
     */
    public DecNode<E> pro(double address) {
        return this.pro.get(address);
    }

    /**
     * returns the deposited node at the parametrized address in the anti tree
     * @param address
     * @return
     */
    public DecNode<E> anti(double address) {
        return this.anti.get(address);
    }

    /**
     * sets new node containing parametrized element as the element value of the immediate pro node to allow for more pro/anti magic.
     * @param address
     * @param element
     * @return the node the method sets
     */
    public DecNode<E> pro(double address, E element) {
        if (this.pro == null) {
            this.pro = new DecTree<DecNode<E>>();
        }
        DecNode<DecNode<E>> opNode = this.pro.paveTo(address).ensureDtD().ensureNode();
        if (opNode.element == null) {
            opNode.element = new DecNode<E>();
        }
        opNode.element.element = element;
        return opNode.element;
    }

    
    public DecNode<E> anti(double address, E element) {
        if (this.anti == null) {
            this.anti = new DecTree<DecNode<E>>();
        }
        DecTree<DecNode<E>> opTree = this.anti.paveTo(address);
        DecTree<DecNode<E>> dtN = opTree.ensureDtD();
        DecNode<DecNode<E>> opNode = dtN.ensureNode();
        if (opNode.element == null) {
            opNode.element = new DecNode<E>();
        }
        opNode.element.element = element;
        return opNode.element;
    }

    /**
     * returns this DecNode's element
     */
    public E get() {
        return element;
    }

    
    /**
     * sets this DecNode's element
     */
    public void set(E element) {
        this.element = element;
        this.vacant = false;
    }

    /**
     * 
     * @param address
     * @param anti_address
     * @return
     */
    public DecNode<DecNode<E>> antiNode(double address, DecNode<DecNode<E>> anti_address) {
        DecTree<DecNode<E>> opTree = this.anti.paveTo(address);
        opTree.ensureDtD().node = anti.node;
        return anti_address;
    }

    public DecNode<E> pro(double address, DecNode<E> pro_address) {
        if (this.pro == null) {
            this.pro = new DecTree<DecNode<E>>();
        }
        DecTree<DecNode<E>> opTree = this.pro.paveTo(address);
        opTree.ensureDtD().ensureNode().element = pro_address;
        return pro_address;
    }

    public DecNode<E> anti(double address, DecNode<E> anti_address) {
        if (this.anti == null) {
            this.anti = new DecTree<DecNode<E>>();
        }
        DecTree<DecNode<E>> opTree = this.anti.paveTo(address);
        opTree.ensureDtD().node.element = anti_address;
        return anti(address);
    }
}
