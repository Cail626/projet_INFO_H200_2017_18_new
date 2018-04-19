package Objects;

import Moving.Player;
import Model.Deletable;
import java.awt.Image;

public abstract class InventoryObject extends GameObject{

    private String description;
    private String addImage;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public InventoryObject(int X, int Y, int color, int id, String description, String addImage) {
        super(X, Y, color, id);
        this.addImage = addImage;
        this.description = description;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    public void throwAway(){

    }

    @Override
    public void activate(){ // action de ramasser l'objet
        notifyDeletableObserver();
    }
    
    public String getAddImage(){
    	return this.addImage;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    public String getDescription(){
        return description;
    }
}
