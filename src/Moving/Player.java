package Moving;

import Objects.InventoryObject;

import java.util.ArrayList;

public class Player extends Character {

    private int exp;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Player(int X, int Y, int life, int maxLife, int force, ArrayList<InventoryObject> inventory, int sizeMaxInventory, int characterNumber, int color, int exp) {
        super(X, Y, life, maxLife, force, inventory, sizeMaxInventory, characterNumber, color);
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
