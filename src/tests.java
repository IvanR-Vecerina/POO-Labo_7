import util.*;
import hanoi.*;
import hanoi.gui.*;

import java.util.EmptyStackException;

public class tests {
    public static void main(String[] args) {
        if(args.length == 1){
            try {
                int nbDisques = Integer.parseInt(args[0]);
                Hanoi n = new Hanoi(nbDisques);
                n.solve();
            }
            catch( NumberFormatException e ) {
                System.out.println("Exception : Valeur entrée n'est pas un nombre");
            }
        }else{
            HanoiDisplayer h = new HanoiDisplayer();
            JHanoi n = new JHanoi();
        }

        //testStack();

    }

    private static void testStack(){

        Stack<Integer> s1 = new Stack<>();

        //Test sur pile vide
        System.out.println("Pile vide: " + s1 + "\n");

        //Test d'ajout d'un élément sur la pile
        s1.push(4);
        System.out.println("Pile avec un élément ajouté: " + s1 + "\n");

        //Test d'une suppression d'un élément
        try{
            s1.pop();
            System.out.println("Pile avec un élément supprimer" + s1 + "\n");
        }catch(EmptyStackException e){
            System.out.println("Tentative de suppression sur pile vide\n");
        }

        //Test d'une suppression d'élément sur une pile vide
        try{
            s1.pop();
            System.out.println("Pile avec un élément supprimer" + s1 + "\n");
        }catch(EmptyStackException e){
            System.out.println("Tentative de suppression sur pile vide\n");
        }

        //Ajout de plusieurs éléments dans la stack
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);

        System.out.println("Ajout des élément 1, 2, 3, 4 dans la pile: " + s1 + "\n");

        //Récupération d'un tableau de la pile
        Object[] tmp = s1.toArray();

        for(Object i : tmp){
            System.out.println("Affichage du tableau: " + i + "\n");
        }



        //Test sur une pile contenant des String
        Stack<String> s2 = new Stack<>();

        //Test sur pile vide
        System.out.println("Pile vide: " + s2 + "\n");

        //Test d'ajout d'un élément sur la pile
        s2.push("a1");
        System.out.println("Pile avec un élément ajouté: " + s2 + "\n");

        //Test d'une suppression d'un élément
        try{
            s2.pop();
            System.out.println("Pile avec un élément supprimer" + s2 + "\n");
        }catch(EmptyStackException e){
            System.out.println("Tentative de suppression sur pile vide\n");
        }

        //Test d'une suppression d'élément sur une pile vide
        try{
            s2.pop();
            System.out.println("Pile avec un élément supprimer" + s2 + "\n");
        }catch(EmptyStackException e){
            System.out.println("Tentative de suppression sur pile vide\n");
        }

        //Ajout de plusieurs éléments dans la stack
        s2.push("a1");
        s2.push("a2");
        s2.push("a3");
        s2.push("a4");

        System.out.println("Ajout des élément a1, a2, a3, a4 dans la pile: " + s2 + "\n");

        //Récupération d'un tableau de la pile
        Object[] tmp2 = s2.toArray();

        for(Object i : tmp2){
            System.out.println("Affichage du tableau: " + i + "\n");
        }

    }
}

