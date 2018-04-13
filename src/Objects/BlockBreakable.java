package Objects;

import Model.Activable;
import Model.Deletable;

public class BlockBreakable extends Block implements Deletable, Activable {

    private int lifepoints;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public BlockBreakable(int X, int Y, int lifepoints) {
        super(X, Y, 1, 9);
        this.lifepoints = lifepoints; 
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>
    
    public void activate(){
        if (lifepoints == 1){
            crush();
        }
        else {
            lifepoints--;
            this.color = lifepoints + 2; // pour éviter de retourner au gris
        }
    }

    public void crush(){
        notifyDeletableObserver();
    }
}
