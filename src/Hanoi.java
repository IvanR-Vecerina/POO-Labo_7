public class Hanoi {
    Stack<Integer> aiguille1 = new Stack<>();
    Stack<Integer> aiguille2 = new Stack<>();
    Stack<Integer> aiguille3 = new Stack<>();
    public Hanoi(int nbDisques) {
        for(int i = nbDisques; i > 0; --i){
            aiguille1.push(i);
        }
    }

    public int resolve(){
        return 0;
    }
}
