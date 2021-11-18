public class StackIterator<T> {
    private Stack<T> stackElement;
    private Integer  value;

    public StackIterator(){
        this.value = -1;
    }

    public StackIterator(Stack<T> firstElement){
        this.stackElement = firstElement;
        this.value = 0;
    }

    public boolean hasNext() {
        return this.stackElement.hasPrevious();
    }

    public void next() {
        this.stackElement = this.stackElement.getPrevious();
        ++this.value;
    }

    public int getValue() {
        return this.value;
    }

    public T getElementValue() {
        return this.stackElement.getValue();
    }

}
