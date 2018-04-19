package Moving;

import Objects.InventoryObject;
import Objects.Consumable;
import Objects.Weapon;

import java.util.ArrayList;

public class Player extends Character {

    private int exp;
    //Position de l'item que le joueur posssède dans son inventaire
    private int itemInHand[];

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Player(int X, int Y, int life, int maxLife, int force, ArrayList<InventoryObject> inventory, int sizeMaxInventory, int characterNumber, int color, int exp) {
        super(X, Y, life, maxLife, force, inventory, sizeMaxInventory, characterNumber, color);
        this.exp = exp;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    @Override
    public void activate() {

    }
    
    public void useItem() {
    	int empItem = itemInHand[0] - 1 + (itemInHand[1]-1)*5;
    	if(inventory.size() > empItem){
    		InventoryObject objInHand = inventory.get(empItem);
        	if (objInHand instanceof Consumable) {
        		((Consumable)objInHand).consume(this);
        		inventory.remove(empItem);
        	}
        	else if (objInHand instanceof Weapon) {
        		if( ((Weapon)objInHand).equip(this) == true){
        			inventory.remove(empItem);
        		}
        	}
    	}
    }

    ////////////////////////////////////////////////////////////////////////////////////////<setMethods>

    public void setForce(int force){
        this.force = force;
    }

    public void setExp(int exp){
        this.exp = exp;
    }
    
    public void setItemInHand(int itemInHand[]){
    	this.itemInHand = itemInHand;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    public int getExp(){
        return exp;
    }
   
    public int[] getItemInHand(){
    	return this.itemInHand;
    }
}
