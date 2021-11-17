import java.util.EmptyStackException;

public class Stack<T> {
    private Stack<T> previous;
    private T        value;
    private int      height;

    Stack() {
        this.height = 0;
    };

    Stack(T val) {
        this.value  = val;
        this.height = 1;
    }

    Stack(Stack<T> prev, T val){
        this.previous = prev;
        this.value    = val;
        this.height   = this.previous.height + 1;
    }

    public void push(T val){
        this.previous = new Stack<T>(this.previous, this.value);
        this.value    = val;
        this.height   = this.previous.height + 1;
    }

    public T pop(T val){
        if (this.previous == null) {
            throw new EmptyStackException();
        }

        T poppedVal = this.value;

        this.previous = this.previous.previous;
        this.value    = this.previous.value;
        this.height   = this.previous.height;

        return poppedVal;
    }

//    public T[] state(){
//        T[] t = (T[]) new Object[this.height];
//
//
//    }
}
