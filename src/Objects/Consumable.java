package Objects;

import Moving.Player;

public abstract class Consumable extends InventoryObject{

    protected Player p;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Consumable(int X, int Y, int color, int id, String description, Player p) {
        super(X, Y, color, id, description, p);
        this.p = p;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    public void consume(){}

    @Override
    public boolean isObstacle() {
        return false;
    }
}
