public class Element<T> {

    private Element<T> previous;
    private T          value;

    public Element(T val) {
        this.value = val;
    }

    public Element(T val, Element<T> prev) {
        this.previous = prev;
        this.value    = val;
    }

    public T getValue(){
        return this.value;
    }

    public Element<T> getPrevious(){
        return this.previous;
    }
}
