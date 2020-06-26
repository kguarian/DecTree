@SuppressWarnings("rawtypes")
public abstract class DigitTree<E> {

    // Value-retrieval methods

    // Element retrieval
    public abstract E eGet(double id);

    // Tree Retrieval
    public abstract DigitTree<E>tGet(double id);

    

    // Value-addition methods
    public abstract void add(double id, E element);

    

    // Value Replacement Methods

    // Element Replacement
    public abstract DigitNode<E> eReplace(double id, E element);

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
