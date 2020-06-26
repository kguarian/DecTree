public class DecTree<E> extends DigitTree<E> {

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
    DecTree<E> dtD;
    DecTree<E> dtC;
    DecTree<E> dtN;
    DigitNode<E> node;

    public DecTree() {
    }

    public DigitNode<E> getNode() {
        return this.node;
    }

    @Override
    public E eGet(double ident) {
        return this.tGet(ident).getNode().getElement();
    }

    private DecTree<E> $getChildWithIdAndParent(int mod, DecTree<E> opTree) {
        if (mod == -1) {
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

    private DecTree<E> $ensureChildWithIdAndParent(int mod, DecTree<E> opTree) {
        if (mod == -1) {
            if (opTree.dtN == null) {
                opTree.dtN = new DecTree<E>();
            }
            opTree = opTree.dtN;
        } else if (mod == 0) {
            if (opTree.dt0 == null) {
                opTree.dt0 = new DecTree<E>();
            }
            opTree = opTree.dt0;
        } else if (mod == 1) {
            if (opTree.dt1 == null) {
                opTree.dt1 = new DecTree<E>();
            }
            opTree = opTree.dt1;
        } else if (mod == 2) {
            if (opTree.dt2 == null) {
                opTree.dt2 = new DecTree<E>();
            }
            opTree = opTree.dt2;
        } else if (mod == 3) {
            if (opTree.dt3 == null) {
                opTree.dt3 = new DecTree<E>();
            }
            opTree = opTree.dt3;
        } else if (mod == 4) {
            if (opTree.dt4 == null) {
                opTree.dt4 = new DecTree<E>();
            }
            opTree = opTree.dt4;
        } else if (mod == 5) {
            if (opTree.dt5 == null) {
                opTree.dt5 = new DecTree<E>();
            }
            opTree = opTree.dt5;
        } else if (mod == 6) {
            if (opTree.dt6 == null) {
                opTree.dt6 = new DecTree<E>();
            }
            opTree = opTree.dt6;
        } else if (mod == 7) {
            if (opTree.dt7 == null) {
                opTree.dt7 = new DecTree<E>();
            }
            opTree = opTree.dt7;
        } else if (mod == 8) {
            if (opTree.dt8 == null) {
                opTree.dt8 = new DecTree<E>();
            }
            opTree = opTree.dt8;
        } else {
            if (opTree.dt9 == null) {
                opTree.dt9 = new DecTree<E>();
            }
            opTree = opTree.dt9;
        }
        return opTree;
    }

    @Override
    public DecTree<E> tGet(double ident) {
        double copyID = ident;
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
        if (copyID == 0) {
            return opTree;
        } else {
            while (copyID > 0) {
                copyID *= 10;
                int floorDecaID = (int) copyID;
                copyID -= floorDecaID;
                opTree = opTree.$getChildWithIdAndParent(floorDecaID, opTree);
            }
        }
        return opTree;
    }

    @Override
    public void add(double ident, E element) {
        double copyID = ident;
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
        if (copyID == 0) {
            while (opTree.node != null) {
                if (opTree.dtC == null) {
                    opTree.dtC = new DecTree<E>();
                    opTree.dtC.node = new DigitNode<E>(ident, element);
                }
                opTree = opTree.dtC;
            }

        } else {
            while (copyID > 0) {
                copyID *= 10;
                int floorDecaID = (int) copyID;
                copyID -= floorDecaID;
                opTree = opTree.$ensureChildWithIdAndParent(floorDecaID, opTree);
            }
        }
        while (opTree.node != null) {
            if (opTree.dtC == null) {
                opTree.dtC = new DecTree<E>();
                opTree = opTree.dtC;
                break;
            }
            opTree = opTree.dtC;
        }
        opTree.node = new DigitNode<E>(ident, element);
    }

    @Override
    public DigitNode<E> eReplace(double ident, E element) {
        DecTree<E> tree = this.tGet(ident);
        DigitNode<E> retNode = tree.node;
        tree.node = new DigitNode<E>(retNode, element);
        return retNode;

    }

    @Override
    public boolean tReplace(double ident, DigitTree<E> tree) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean init(double ident, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean con(double ident) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertB(double ident, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertA(double ident, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertInit(double ident, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertTerm(double ident, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public DecTree<E> tNext(double ident) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E eNext(double ident, E element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DecTree<E> tPrev(double ident) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E ePrev(double ident, E element) {
        // TODO Auto-generated method stub
        return null;
    }

}