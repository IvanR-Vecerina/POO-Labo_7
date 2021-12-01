import util.*;
import hanoi.*;
import hanoi.gui.*;

public class tests {
    public static void main(String[] args) {
        if(args.length == 1){
            int nbDisques = Integer.parseInt(args[0]);
            Hanoi n = new Hanoi(nbDisques);
            n.solve();
        }else{
            HanoiDisplayer h = new HanoiDisplayer();
            JHanoi n = new JHanoi();
        }
    }
}

