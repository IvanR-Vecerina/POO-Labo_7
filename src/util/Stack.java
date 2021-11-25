package util;

import java.util.EmptyStackException;

public class Stack<T> {
    private Element<T> first;
    private int      height;

    public Stack() {
        this.first = null;
        this.height = 0;
    }

    public Stack(T val) {
        this.first    = new Element<>(val);
        this.height   = 1;
    }

    public Element<T> getFirst() {
        return first;
    }

    public void push(T val){
        this.first = new Element<>(val, this.first);
        ++this.height;
    }

    public T pop(){
        if (this.first == null) {
            throw new EmptyStackException();
        }

        T poppedVal = this.first.getValue();

        this.first = this.first.getPrevious();
        --this.height;

        return poppedVal;
    }

    public Object[] state(){
        Object[] t = new Object[this.height];

        ElementIterator<T> it = new ElementIterator<>(this);

        for (int i = 0; i < this.height; i++){
            t[i] = it.getElementValue();
            it.next();
        }

        return t;
    }

    @Override
    public String toString() {
        String s = "[ ";

        ElementIterator<T> it = new ElementIterator<>(this);

        for (int i = 0; i < this.height; i++){
            s += "<" + it.getElementValue().toString() + "> ";
            it.next();
        }
        s += "]";

        return s;
    }
}
