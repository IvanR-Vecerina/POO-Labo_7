package hanoi;

/**
 * Classe HanoiDisplayer. Permet d'afficher l'état des 3 tours de hanoi
 *
 * @author Ivan Vecerina
 * @author Thibault Seem
 */
public class HanoiDisplayer {

    /**
     * Affiche l'état des tours de hanoi pendant la résolution du problème, ainsi que le tour auquel l'état des tours
     * est affiché.
     * @param h Etat actuel des tours de hanoi
     */
    public void display(Hanoi h){
        System.out.println("--Turn " + h.turn() + ":\n" + h + "\n");
    }
}
