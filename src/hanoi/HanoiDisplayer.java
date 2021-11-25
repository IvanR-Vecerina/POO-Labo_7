package hanoi;

public class HanoiDisplayer {
    public void display(Hanoi h){
        System.out.println("--Turn " + h.turn() + ":\n" + h.toString() + "\n");
    }
}
