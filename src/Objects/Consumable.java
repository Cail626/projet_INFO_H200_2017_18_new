package Objects;

import Moving.Player;

public abstract class Consumable extends InventoryObject{


    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Consumable(int X, int Y, int color, int id, String description) {
        super(X, Y, color, id, description);
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    public void consume(Player p){}

    @Override
    public boolean isObstacle() {
        return false;
    }
}
