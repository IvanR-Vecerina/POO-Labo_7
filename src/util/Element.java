package util;

/**
 * Classe Element, permet le stockage d'un objet quelconque dans une stack. Donne également accès à l'élément
 * le précédant dans la stack.
 *
 * @author Ivan Vecerina
 * @author Thibault Seem
 */
public class Element<T> {

    private Element<T> previous;
    private T          value;

    /**
     * Constructeur du premier élément de la pile (il ne possède donc pas d'élément précédent
     *
     * @param val Valeur d'un élément de la pile
     */
    public Element(T val) {
        this.value = val;
    }

    /**
     * Constructeur d'un élément de la pile, autre que le premier
     *
     * @param val Valeur d'un élément de la pile
     * @param prev Référence sur l'élément précédent de la pile
     */
    public Element(T val, Element<T> prev) {
        this.previous = prev;
        this.value    = val;
    }

    /**
     * Méthode permettant d'obtenir la valeur stockée dans l'élément
     *
     * @return Retourne la valeur de l'élément
     */
    public T getValue(){
        return this.value;
    }

    /**
     * Méthode pour récupérer une référence sur l'élément précédent de la pile
     *
     * @return Retourne l'élément précédent dans la pile
     */
    public Element<T> getPrevious(){
        return this.previous;
    }
}
