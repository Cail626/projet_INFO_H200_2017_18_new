package Objects;

import Moving.Player;
import Model.Deletable;

public abstract class InventoryObject extends GameObject{

    private String description;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public InventoryObject(int X, int Y, int color, int id, String description) {
        super(X, Y, color, id);
        this.description = description;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    public void throwAway(){

    }

    @Override
    public void activate(){ // action de ramasser l'objet
        notifyDeletableObserver();
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    public String getDescription(){
        return description;
    }
}
