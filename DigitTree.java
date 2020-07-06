@SuppressWarnings("rawtypes")
public abstract class DigitTree<E> {

    // Value-retrieval methods

    // Element retrieval
    public abstract E eGet(double ident);

    // Tree Retrieval
    public abstract DigitTree<E> tGet(double ident);

    // Value-addition methods
    public abstract int add(double ident, E element);

    // Value Replacement Methods

    // Element Replacement
    public abstract DigitNode<E> eReplace(double ident, E element);

    // Tree Replacement
    public abstract boolean tReplace(double ident, DigitTree<E> tree);

    // -----------------------------------------------------------------------

    // Set Sequence Init (Initialize)
    public abstract boolean init(double ident, E element);

    // Set equence Con (Conclude)
    public abstract boolean con(double ident);

    // Sequence Insert (implementation-optional insert @id0 before @id1)
    // Insert Before
    public abstract boolean insertB(double ident, E element);

    // Insert After
    public abstract boolean insertA(double ident, E element);

    // Insert as Initial in new Sequence
    public abstract boolean insertInit(double ident, E element);

    // Insert as optional Termainal in Sequence
    public abstract boolean insertTerm(double ident, E element);

    // Sequential Retrieval
    public abstract DigitTree<E> tNext(double ident);

    // Value-addition methods
    public abstract E eNext(double ident, E element);

    public abstract DigitTree<E> tPrev(double ident);

    // Value-addition methods
    public abstract E ePrev(double ident, E element);

}
