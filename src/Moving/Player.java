package Moving;

import Model.Game;
import Objects.InventoryObject;

import java.util.ArrayList;

public abstract class Player extends Character {

    protected int exp;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Player(int X, int Y, int life, int maxLife, int force, ArrayList<InventoryObject> inventory, int sizeMaxInventory, int characterNumber, int color, int exp, Game game) {
        super(X, Y, life, maxLife, force, inventory, sizeMaxInventory, characterNumber, color, game);
        this.exp = exp;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    @Override
    public void activate() {

    }

    ////////////////////////////////////////////////////////////////////////////////////////<setMethods>

    public void setForce(int force){
        this.force = force;
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    public int getExp(){
        return exp;
    }
}
