package Moving;

import Model.Activable;
import Model.Deletable;
import Model.Game;
import Objects.InventoryObject;

import java.util.ArrayList;

public class Monster extends Character implements Runnable, Deletable, Activable{

    private int speed;
    private int viewRange;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Monster(int X, int Y, int life, int maxLife, int force, int speed, int viewRange, ArrayList<InventoryObject> inventory, int sizeMaxInventory, int characterNumber, int color, Game game) {
        super(X, Y, life, maxLife, force, inventory, sizeMaxInventory, characterNumber, color, game);
        this.speed = speed;
        this.viewRange = viewRange;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    public void wait(int speed){

    }

    @Override
    public void activate() {

    }

    @Override
    public void run() {

    }

    ////////////////////////////////////////////////////////////////////////////////////////<setMethods>

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void setViewRange(int viewRange){
        this.viewRange = viewRange;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    public int getSpeed(){
        return speed;
    }

    public int getViewRange(){
        return viewRange;
    }
}
