public class DigitNode<E> {

    double id;
    E element;
    DigitNode<E> pro;
    DigitNode<E> anti;

    public DigitNode(double id, E element) {
        this.id = id;
    }

    /**
     * creates deep copy of parametrized DigitNode
     */
    public DigitNode(DigitNode<E> copySubject) {
        this.id = copySubject.id;
        this.element = copySubject.element;
        this.pro = copySubject.pro;
        this.anti = copySubject.anti;
    }

    /**
     * creates deep copy of parametrized DigitNode, replacing its data element with
     * the parametrized E value.
     * 
     * @param copySubject deep-copied DigitNode
     * @param element     replacement value.
     */
    public DigitNode(DigitNode<E> copySubject, E element) {
        this.id = copySubject.id;
        this.element = element;
        this.pro = copySubject.pro;
        this.anti = copySubject.anti;
        copySubject.anti.pro = this;
        copySubject.pro.anti = this;
    }

    public DigitNode(E element) {
        this.element = element;
    }

    public DigitNode(DigitNode<E> proSequence, DigitNode<E> antiSequence, E element) {
        this.pro = proSequence;
        this.anti = antiSequence;
        this.element = element;
    }

    public void setAnti(DigitNode<E> anti) {
        this.anti = anti;
    }

    public void setPro(DigitNode<E> pro) {
        this.pro = pro;
    }

    public E getElement() {
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        try{
            return this.equals((DigitNode<E>) o);
        } catch (ClassCastException e) {
            return false;
        }
    }

    public boolean equals(DigitNode<E> comparisonDigitNode) {
        if (comparisonDigitNode == null) {
            return false;
        }
        if(comparisonDigitNode.id == this.id &&
        comparisonDigitNode.element == this.element &&
        comparisonDigitNode.pro == this.pro &&
        comparisonDigitNode.anti == this.anti
        ) {
            return true;
        } else {
            return false;
        }
    }
}
