package hanoi;

import util.Stack;


/**
 * Classe Hanoi. Cette classe permet de résoudre un problème de tours de Hanoi à 3 tours. La résolution est effectuée à
 * l'aide de l'algorithme récursif. Le nombre de disque est décidé à la création de l'objet Hanoi. Durant la résolution,
 * l'état des trois tours est affichée après chaque déplacement de disque.
 *
 * @author Ivan Vecerina
 * @author Thibault Seem
 */
public class Hanoi {
    Stack<Integer> aiguille1 = new Stack<>();
    Stack<Integer> aiguille2 = new Stack<>();
    Stack<Integer> aiguille3 = new Stack<>();
    HanoiDisplayer display = new HanoiDisplayer();
    int nbDisques;
    int nbCoups;
    boolean finished;

    /**
     * Constructeur utilisé pour résoudre un problème de tours hanoi sans changer le HanoiDisplayer utilisé par défaut
     *
     * @param nbDisques
     */
    public Hanoi(int nbDisques){
        this.nbDisques = nbDisques;
        finished = true;
        for(int i = this.nbDisques; i > 0; --i){
            aiguille1.push(i);
        }
    }

    public Hanoi(int nbDisques, HanoiDisplayer display) {
        this(nbDisques);
        this.display = display;
    }

    private void resolution(int n, Stack<Integer> from_rod, Stack<Integer> to_rod, Stack<Integer> aux_rod){
        Integer tmp;
        if (n == 1)
        {
            tmp = from_rod.pop();
            to_rod.push(tmp);
            nbCoups++;
            display.display(this);

            return;
        }
        resolution(n - 1, from_rod, aux_rod, to_rod);

        tmp = from_rod.pop();
        to_rod.push(tmp);
        nbCoups++;
        display.display(this);

        resolution(n - 1, aux_rod, to_rod, from_rod);
    }

    public void solve(){
        finished = false;
        nbCoups = 0;
        display.display(this);
        resolution(nbDisques, aiguille1, aiguille3, aiguille2);
        finished = true;
    }

    public boolean finished(){
        return finished;
    }

    public int turn(){
        return nbCoups;
    }

    public int[][] status(){
        int[][] tmp = new int[3][];

        tmp[0] = new int[aiguille1.toArray().length];
        tmp[1] = new int[aiguille2.toArray().length];
        tmp[2] = new int[aiguille3.toArray().length];

        Object[] one = aiguille1.toArray(),
                 two = aiguille2.toArray(),
                 three = aiguille3.toArray();

        for(int i = 0; i < one.length; ++i){
            tmp[0][i] = (int)one[i];
        }
        for(int i = 0; i < two.length; ++i){
            tmp[1][i] = (int)two[i];
        }
        for(int i = 0; i < three.length; ++i){
            tmp[2][i] = (int)three[i];
        }

        return tmp;
    }

    @Override
    public String toString(){
        return "Aiguille 1: " + aiguille1.toString() + "\nAiguille 2: " + aiguille2.toString() + "\nAiguille 3: " + aiguille3.toString();
    }
}
