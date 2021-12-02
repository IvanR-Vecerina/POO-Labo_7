package util;

/**
 * Classe ElementIterator, classe mettant en oeuvre un itérateur pointant sur un élément d'une pile.
 * Elle est utilisé pour parcourir la pile.
 *
 * @author Ivan Vecerina
 * @author Thibault Seem
 */
public class ElementIterator<T> {
    private Element<T> node;

    /**
     * Constructeur d'un itérateur pointant sur le premier élément d'une pile
     *
     * @param stack Pile sur la quelle on veut itérer
     */
    public ElementIterator(Stack<T> stack){
        this.node = stack.getFirst();
    }

    /**
     * Permet de vérifier si l'élément référencé par l'iterateur possède un élément précédent
     *
     * @return Retourne true si l'élément a un élément précédent et false si il n'en a pas
     */
    public boolean hasNext() {
        return (this.node.getPrevious() != null);
    }

    /**
     * Change l'élément référencé par l'itérateur par l'élément précédent
     */
    public void next() {
        this.node = this.node.getPrevious();
    }

    /**
     * Récupère l'objet de l'élément référencé par l'itérateur
     *
     * @return Retourne l'objet stocké dans l'élément référencé par l'itérateur
     */
    public T getElementValue() {
        return this.node.getValue();
    }

}
