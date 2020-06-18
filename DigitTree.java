@SuppressWarnings("rawtypes")
public abstract class DigitTree<E> {

    // Value-retrieval methods

    // Element retrieval
    public abstract E eGet(double id);

    // Tree Retrieval
    public abstract DigitTree<E>tGet(double id);

    

    // Value-addition methods
    public abstract boolean add(double id, E element);

    

    // Value Replacement Methods

    // Element Replacement
    public abstract boolean eReplace(double id, E element);

    // Tree Replacement
    public abstract boolean tReplace(double id, DigitTree<E> tree);

    
    // -----------------------------------------------------------------------

    // Set Sequence Init (Initialize)
    public abstract boolean init(double id, E element);

    

    // Set equence Con (Conclude)
    public abstract boolean con(double id);

    

    // Sequence Insert (implementation-optional insert @id0 before @id1)
    // Insert Before
    public abstract boolean insertB(double id, E element);

   

    // Insert After
    public abstract boolean insertA(double id, E element);

    
    
    // Insert as Initial in new Sequence
    public abstract boolean insertInit(double id, E element);

    

    // Insert as optional Termainal in Sequence
    public abstract boolean insertTerm(double id, E element);

    
    // Sequential Retrieval
    public abstract DigitTree<E> tNext(double id);

    

    // Value-addition methods
    public abstract E eNext(double id, E element);

   

    public abstract DigitTree<E> tPrev(double id);

    

    // Value-addition methods
    public abstract E ePrev(double id, E element);

    
}

// no t-retrieval method will return null. The null value of a tree will be a
// static, predefined DigitTree<E>object.
@SuppressWarnings("rawtypes")
class NullValue<E> extends DigitTree<E> {
    @Override
    public E eGet(double id) {
        return null;
    }

    @Override
    public DigitTree<E>tGet(double id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(double id, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean eReplace(double id, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean tReplace(double id, DigitTree<E> tree) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean init(double id, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean con(double id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertB(double id, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertA(double id, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertInit(double id, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean insertTerm(double id, E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public DigitTree<E> tNext(double id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E eNext(double id, E element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DigitTree<E> tPrev(double id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E ePrev(double id, E element) {
        // TODO Auto-generated method stub
        return null;
    }
}