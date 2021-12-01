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
     * Constructeur utilisé lors d'une résolution demandant un affichage sur la console. Ne change par le HanoiDisplayer
     * déclaré par défaut
     *
     * @param nbDisques Nombre de disque utilisé pour résoudre les tours de hanoi
     */
    public Hanoi(int nbDisques){
        this.nbDisques = nbDisques;
        finished = true;
        for(int i = this.nbDisques; i > 0; --i){
            aiguille1.push(i);
        }
    }

    /**
     * Constructeur utilisé par JHanoi pour l'interface graphique. Permet de changer le HanoiDisplayer par défaut
     *
     * @param nbDisques Nombre de disque utilisé pour résoudre les tours de hanoi
     * @param display Nouveau HanoiDisplayer à utilisé à la place de celui déclaré par défaut
     */
    public Hanoi(int nbDisques, HanoiDisplayer display) {
        this(nbDisques);
        this.display = display;
    }

    /**
     * Algorithme de résolution récursif des tours de hanoi. Il s'agit d'un algorithme repris sur internet.
     *
     * @param n Nombre de disque sur la tour from_rod
     * @param from_rod Tour d'où on retire un disque
     * @param to_rod Tour où on va poser le disque
     * @param aux_rod Tour dont les disques ne sont pas bougé
     */
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

    /**
     * Méthode permettant de démarrer la résolution des tours de hanoi
     */
    public void solve(){
        finished = false;
        nbCoups = 0;
        display.display(this);
        resolution(nbDisques, aiguille1, aiguille3, aiguille2);
        finished = true;
    }

    /**
     * Méthode permettant de tester si on a finit de résoudre les tours de hanoi
     *
     * @return Retourne true si la résolution est finie et false si la résolution est toujours en cours ou
     * n'a pas commencé
     */
    public boolean finished(){
        return finished;
    }

    /**
     * Méthode pour connaître le nombre de déplacement effectué depuis le lancement de la résolution
     *
     * @return Nombre de déplacement effectués
     */
    public int turn(){
        return nbCoups;
    }

    /**
     * Méthode utilisée pour obtenir un tableau à deux dimensions représentant l'état actuel des 3 tours de hanoi
     *
     * @return Retourne un tableau à 2 dimension contenant l'état des 3 tours. Le tableau sera donc toujours de taille
     * int[3][*], le '*' dépendant du nombre de disque sur la tour.
     */
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

    /**
     * Méthode permettant d'obtenir un String représentant les 3  et leurs états actuel sur 3 lignes différentes
     *
     * @return Retourne un String contenant l'état des 3 tours.
     */
    @Override
    public String toString(){
        return "Aiguille 1: " + aiguille1.toString() + "\nAiguille 2: " + aiguille2.toString() + "\nAiguille 3: " + aiguille3.toString();
    }
}
