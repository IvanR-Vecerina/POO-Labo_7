package util;

import java.util.EmptyStackException;

/**
 * Classe Stack, permettant le stockage de donnée sous forme de LIFO. Permet l'accès à l'élément au sommet de la pile,
 * l'ajout et la suppression d'un élément au sommet de la pile et l'affichage de tous les éléments dans la pile.
 *
 * @author Ivan Vecerina
 * @author Thibault Seem
 */
public class Stack<T> {
    private Element<T> first;
    private int      height;

    /**
     * Constructeur sans paramètre de la pile
     */
    public Stack() {
        this.first = null;
        this.height = 0;
    }

    /**
     * Constructeur de Stack permettant de mettre "val" au sommet de la pile
     *
     * @param val Valeur que l'on souhaite mettre dans la pile à sa création.
     */
    public Stack(T val) {
        this.first    = new Element<>(val);
        this.height   = 1;
    }

    /**
     * Getter permettant de récupérer l'élémment(iterator) du sommet de la pile
     *
     * @return Retourne l'élément au sommet de la pile
     */
    public Element<T> getFirst() {
        return first;
    }

    /**
     * Méthode permettant d'ajouter une élément contenant "val" au sommet de la pile
     *
     * @param val Valeur que l'on souhaite ajouter à la pile
     */
    public void push(T val){
        this.first = new Element<>(val, this.first);
        ++this.height;
    }

    /**
     * Méthode permettant de retirer un élément du sommet de la pile.
     *
     * @return Retourne la valeur retirée du sommet de la pile
     */
    public T pop() throws EmptyStackException{
        if (this.first == null) {
            throw new EmptyStackException();
        }

        T poppedVal = this.first.getValue();

        this.first = this.first.getPrevious();
        --this.height;

        return poppedVal;
    }

    /**
     * Méthode permettant d'obtenir un array remplis avec le contenu de la pile.
     *
     * @return Retourne un array d'Object contenant tous les élément de la pile.
     */
    public Object[] toArray(){
        Object[] t = new Object[this.height];

        ElementIterator<T> it = new ElementIterator<>(this);

        for (int i = 0; i < this.height; i++){
            t[i] = it.getElementValue();
            it.next();
        }

        return t;
    }

    /**
     * Méthode permettant d'obtenir un String correspondant au contenu de la pile
     *
     * @return Retourne un String avec les élément de la pile sous la forme : [ &lt elem1 &gt &lt elem2 &gt ]
     */
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
