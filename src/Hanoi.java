public class Hanoi {
    Stack<Integer> aiguille1 = new Stack<>();
    Stack<Integer> aiguille2 = new Stack<>();
    Stack<Integer> aiguille3 = new Stack<>();
    int nbDisques;
    public Hanoi(int nbDisques) {
        this.nbDisques = nbDisques;
        for(int i = this.nbDisques; i > 0; --i){
            aiguille1.push(i);
        }
    }

    private void resolution(int n, Stack<Integer> from_rod, Stack<Integer> to_rod, Stack<Integer> aux_rod){
        Integer tmp;
        if (n == 1)
        {
            tmp = from_rod.pop();
            to_rod.push(tmp);
            System.out.println("Aiguille 1: " + aiguille1.toString());
            System.out.println("Aiguille 2: " + aiguille2.toString());
            System.out.println("Aiguille 3: " + aiguille3.toString());

            return;
        }
        resolution(n - 1, from_rod, aux_rod, to_rod);
        tmp = from_rod.pop();
        to_rod.push(tmp);

        System.out.println("Aiguille 1: " + aiguille1.toString());
        System.out.println("Aiguille 2: " + aiguille2.toString());
        System.out.println("Aiguille 3: " + aiguille3.toString());

        resolution(n - 1, aux_rod, to_rod, from_rod);
    }

    public void solve(){
        resolution(nbDisques, aiguille1, aiguille2, aiguille3);
    }

    public String toString(){
        return "";
    }
}
