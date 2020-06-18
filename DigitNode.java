public class DigitNode<E> {

    double id;
    E element;
    DigitNode<E> pro;
    DigitNode<E> anti;

    public DigitNode(double id, E element) {
        this.id = id;
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
}