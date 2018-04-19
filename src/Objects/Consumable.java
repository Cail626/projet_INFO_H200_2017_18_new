package Objects;

import Moving.Player;

public abstract class Consumable extends InventoryObject{


    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Consumable(int X, int Y, int color, int id, String description, String AddImage) {
        super(X, Y, color, id, description, AddImage);
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    public void consume(Player p){}

    @Override
    public boolean isObstacle() {
        return false;
    }
}
