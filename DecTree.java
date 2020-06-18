public class DecTree<E> extends DigitTree<E> {

    public DecTree<E> dt0;
    public DecTree<E> dt1;
    public DecTree<E> dt2;
    public DecTree<E> dt3;
    public DecTree<E> dt4;
    public DecTree<E> dt5;
    public DecTree<E> dt6;
    public DecTree<E> dt7;
    public DecTree<E> dt8;
    public DecTree<E> dt9;
    public DecTree<E> dtD;
    public DecTree<E> dtC;
    public DecTree<E> dtN;
    DigitNode<E> node;

    public DecTree() {
    }

    public DigitNode<E> getNode(){
        return this.node;
    }

    @Override
    public E eGet(double ident) {
        return this.tGet(ident).getNode().getElement();
    }

    @Override
    @SuppressWarnings("unchecked")
    public DecTree<E> tGet(double ident) {
        try {
            double copyId = ident;
            DecTree<E> opTree = this;
            if (ident < 0) {// negatives stored under primary dt0 container
                opTree = this.dtN;
                copyId *= -1;
            }
            while (copyId >= 1) {
                double copyId_mod10 = copyId % 10;
                try {
                    opTree = (DecTree<E>) DecTree.class.getField("dt" + (int)copyId_mod10).get(opTree);
                    copyId /= 10;
                } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
                        | SecurityException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
            if (copyId == 0) {
                return opTree;
            }
            if (copyId > 0) {
                opTree = opTree.dtD;
            }
            while (copyId > 0) {
                copyId *= 10;
                try {
                    opTree = (DecTree<E>) DecTree.class.getField("dt" + (int) copyId).get(opTree);
                } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException
                        | SecurityException e) {
                    e.printStackTrace();
                    System.exit(2);
                }
                copyId -= (int) copyId%10;
            }
            return opTree;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public boolean add(double ident, E element) {
        double copyId = ident;
        DecTree<E> opTree = this;
        if (ident < 0) {// negatives stored under primary dt0 container
            if (this.dtN == null) {
                this.dtN = new DecTree<E>();
            }
            opTree = this.dtN;
            copyId *= -1;
        }
        while (copyId >= 1) {
            double copyId_mod10 = copyId % 10;
            try {
                DecTree<E> dt$_value = (DecTree<E>) DecTree.class.getField("dt" + (int)copyId_mod10).get(opTree);
                if (dt$_value == null) {
                    DecTree.class.getField("dt" + (int)copyId_mod10).set(opTree, new DecTree<E>());
                }
                opTree = (DecTree<E>) DecTree.class.getField("dt" + (int) copyId_mod10).get(opTree);
                copyId/=10;
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        if (copyId == 0) {
            if (opTree.node != null) {
                while (true) {
                    if (opTree.dtC != null) {
                        opTree.dtC = new DecTree<E>();
                        opTree = opTree.dtC;
                    } else {
                        opTree.node = new DigitNode<E>(element);
                        return false;
                    }
                }
            } else {
                opTree.node = new DigitNode<E>(element);
                return true;
            }
        } else if (copyId > 0) {
            if (opTree.dtD == null) {
                opTree.dtD = new DecTree<E>();
            }
            opTree = opTree.dtD;
        }
        while (copyId > 0) {
            copyId *= 10;
            double copyId_mod10 = copyId % 10;
            try {
                DecTree<E> dt$_value = (DecTree<E>) DecTree.class.getField("dt" + (int)copyId_mod10).get(opTree);
                if (dt$_value == null) {
                    DecTree.class.getField("dt" + (int)copyId_mod10).set(opTree, new DecTree<E>());
                }
                opTree = (DecTree<E>) DecTree.class.getField("dt" + (int) copyId_mod10).get(opTree);
                copyId -= (int) copyId_mod10;
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        if (opTree.node != null) {
            while(true){
            if (opTree.dtC != null) {
                opTree.dtC = new DecTree<E>();
                opTree = opTree.dtC; 
            }else{
                opTree.node = new DigitNode<E>(element);
                return false;
            }               
            }
        } else {
            opTree.node = new DigitNode<E>(element);
                return true;
        }
    }

    @Override
    public boolean eReplace(double ident, E element) {
        // TODO Auto-generated method stub
        return false;
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