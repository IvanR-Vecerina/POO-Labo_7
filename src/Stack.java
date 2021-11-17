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
}
