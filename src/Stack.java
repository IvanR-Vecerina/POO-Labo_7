import java.util.EmptyStackException;

public class Stack<T> {
    private Stack<T> previous;
    private T value;

    Stack() {};

    Stack(T val) {
        this.value = val;
    }

    Stack(Stack<T> prev, T val){
        this.previous = prev;
        this.value = val;
    }

    public void push(T val){
        this.previous = new Stack<T>(this.previous, this.value);
        this.value = val;
    }

    public T pop(T val){
        if (this.previous == null)
            throw EmptyStackException("Cannot pop element from empty stack");

//        this.previous = new Stack<T>(this.previous, this.value);
//        this.value = val;

        return this.value;
    }

}
