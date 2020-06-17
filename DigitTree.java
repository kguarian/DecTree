@SuppressWarnings("rawtypes")
public abstract class DigitTree<E> {

    public static DigitTree nullValue = new NullValue<String>();

    // Value-retrieval methods

    // Element retrieval
    public abstract E eGet(double id);

    public abstract E eGet(int id);

    public abstract E eGet(long id);

    // Tree Retrieval
    public abstract DigitTree tGet(double id);

    public abstract DigitTree tGet(int id);

    public abstract DigitTree tGet(long id);

    // Value-addition methods
    public abstract boolean add(double id, E element);

    public abstract boolean add(int id, E element);

    public abstract boolean add(long id, E element);

    // Value Replacement Methods

    // Element Replacement
    public abstract boolean eReplace(double id, E element);

    public abstract boolean eReplace(int id, E element);

    public abstract boolean eReplace(long id, E element);

    // Tree Replacement
    public abstract boolean tReplace(double id, DigitTree<E> tree);

    public abstract boolean tReplace(int id, DigitTree<E> tree);

    public abstract boolean tReplace(long id, DigitTree<E> tree);

    // -----------------------------------------------------------------------

    // Set Sequence Init (Initialize)
    public abstract boolean init(double id, E element);

    public abstract boolean init(int id, E element);

    public abstract boolean init(long id, E element);

    // Set equence Con (Conclude)
    public abstract boolean con(double id);

    public abstract boolean con(int id);

    public abstract boolean con(long id);

    // Sequence Insert (implementation-optional insert @id0 before @id1)
    // Insert Before
    public abstract boolean insertB(double id, E element);

    public abstract boolean insertB(int id, E element);

    public abstract boolean insertB(long id, E element);

    // Insert After
    public abstract boolean insertA(double id, E element);

    public abstract boolean insertA(int id, E element);

    public abstract boolean insertA(long id, E element);
    
    // Insert as Initial in new Sequence
    public abstract boolean insertInit(double id, E element);

    public abstract boolean insertInit(int id, E element);

    public abstract boolean insertInit(long id, E element);

    // Insert as optional Termainal in Sequence
    public abstract boolean insertTerm(double id, E element);

    public abstract boolean insertTerm(int id, E element);

    public abstract boolean insertTerm(long id, E element);

    // Sequential Retrieval
    public abstract DigitTree<E> tNext(double id);

    public abstract DigitTree<E> tNext(int id);

    public abstract DigitTree<E> tNext(long id);

    // Value-addition methods
    public abstract E eNext(double id, E element);

    public abstract E eNext(int id, E element);

    public abstract E eNext(long id, E element);

    public abstract DigitTree<E> tPrev(double id);

    public abstract DigitTree<E> tPrev(int id);

    public abstract DigitTree<E> tPrev(long id);

    // Value-addition methods
    public abstract E ePrev(double id, E element);

    public abstract E ePrev(int id, E element);

    public abstract E ePrev(long id, E element);
}

// no t-retrieval method will return null. The null value of a tree will be a
// static, predefined DigitTree object.
@SuppressWarnings("rawtypes")
class NullValue<E> extends DigitTree<E> {
    @Override
    public E eGet(double id) {
        return null;
    }

    @Override
    public E eGet(int id) {
        return null;
    }

    @Override
    public E eGet(long id) {
        return null;
    }

    @Override
    public DigitTree tGet(double id) {
        return null;
    }

    @Override
    public DigitTree tGet(int id) {
        return null;
    }

    @Override
    public DigitTree tGet(long id) {
        return null;
    }

    @Override
    public boolean add(double id, E element) {
        return false;
    }

    @Override
    public boolean add(int id, E element) {
        return false;
    }

    @Override
    public boolean add(long id, E element) {
        return false;
    }

    @Override
    public boolean eReplace(double id, E element) {
        return false;
    }

    @Override
    public boolean eReplace(int id, E element) {
        return false;
    }

    @Override
    public boolean eReplace(long id, E element) {
        return false;
    }

    @Override
    public boolean tReplace(double id, DigitTree<E> tree) {
        return false;
    }

    @Override
    public boolean tReplace(int id, DigitTree<E> tree) {
        return false;
    }

    @Override
    public boolean tReplace(long id, DigitTree<E> tree) {
        return false;
    }

    @Override
    public boolean init(double id, E element) {
        return false;
    }

    @Override
    public boolean init(int id, E element) {
        return false;
    }

    @Override
    public boolean init(long id, E element) {
        return false;
    }

    @Override
    public boolean con(double id) {
        return false;
    }

    @Override
    public boolean con(int id) {
        return false;
    }

    @Override
    public boolean con(long id) {
        return false;
    }

    @Override
    public boolean insertB(double id, E element) {
        return false;
    }

    @Override
    public boolean insertB(int id, E element) {
        return false;
    }

    @Override
    public boolean insertB(long id, E element) {
        return false;
    }

    @Override
    public boolean insertA(double id, E element) {
        return false;
    }

    @Override
    public boolean insertA(int id, E element) {
        return false;
    }

    @Override
    public boolean insertA(long id, E element) {
        return false;
    }

    @Override
    public DigitTree<E> tNext(double id) {
        return null;
    }

    @Override
    public DigitTree<E> tNext(int id) {
        return null;
    }

    @Override
    public DigitTree<E> tNext(long id) {
        return null;
    }

    @Override
    public E eNext(double id, E element) {
        return null;
    }

    @Override
    public E eNext(int id, E element) {
        return null;
    }

    @Override
    public E eNext(long id, E element) {
        return null;
    }

    @Override
    public DigitTree<E> tPrev(double id) {
        return null;
    }

    @Override
    public DigitTree<E> tPrev(int id) {
        return null;
    }

    @Override
    public DigitTree<E> tPrev(long id) {
        return null;
    }

    @Override
    public E ePrev(double id, E element) {
        return null;
    }

    @Override
    public E ePrev(int id, E element) {
        return null;
    }

    @Override
    public E ePrev(long id, E element) {
        return null;
    }
}