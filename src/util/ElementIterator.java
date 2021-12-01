package util;

/**
 * Classe ElementIterator,
 *
 * @author Ivan
 * @author Thibault Seem
 */
public class ElementIterator<T> {
    private Element<T> node;

    public ElementIterator(Stack<T> stack){
        this.node = stack.getFirst();
    }

    public boolean hasNext() {
        return (this.node.getPrevious() != null);
    }

    public void next() {
        this.node = this.node.getPrevious();
    }

    public T getElementValue() {
        return this.node.getValue();
    }

}
