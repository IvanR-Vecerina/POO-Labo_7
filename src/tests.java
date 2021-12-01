import util.*;
import hanoi.*;
import hanoi.gui.*;

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
    }
}

