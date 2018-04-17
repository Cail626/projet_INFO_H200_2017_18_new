package Moving;

import Objects.InventoryObject;

import java.util.ArrayList;

public class Warrior extends Player{

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Warrior(int X, int Y, int life, int maxLife, int force, ArrayList<InventoryObject> inventory, int sizeMaxInventory, int characterNumber, int color, int exp) {
        super(X, Y, life, maxLife, force, inventory, sizeMaxInventory, characterNumber, color, exp);
    }


}
