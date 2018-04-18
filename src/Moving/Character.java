package Moving;

import Model.Activable;
import Model.Directable;
import Model.Game;
import Objects.GameObject;
import Objects.InventoryObject;

import java.util.ArrayList;

public abstract class Character extends GameObject implements Directable {

    protected int life;
    protected int direction;
    protected int force;
    protected ArrayList<InventoryObject> inventory;
    protected int sizeMaxInventory;
    protected int maxLife;
    protected Game game;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Character(int X, int Y, int life, int maxLife, int force, ArrayList<InventoryObject> inventory, int sizeMaxInventory, int characterNumber, int color, Game game) {
        super(X, Y, color, characterNumber);
        this.life = life;
        this.maxLife = maxLife;
        this.force = force;
        this.inventory = inventory;
        this.sizeMaxInventory = sizeMaxInventory;
        this.game = game;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<movingMethods>

    synchronized public void moveCharacter(int x, int y) {
        int nextX = this.getPosX() + x;
        int nextY = this.getPosY() + y;

        boolean obstacle = false;
        for (GameObject object : game.getGameObjects()) {
            if (object.isAtPosition(nextX, nextY)) {
                obstacle = object.isObstacle();
            }
            if (obstacle) {
                break;
            }
        }
        this.rotate(x, y);
        if (! obstacle) {
            move(x, y);
        }
        //teste si on quitte la map
        if (nextX == (game.getSize() - 1) || nextY == (game.getSize() - 1) ){
            System.out.println("map quitte");
        }
        game.notifyView();
    }

    public void move(int X, int Y) {
        this.posX = this.posX + X;
        this.posY = this.posY + Y;
    }

    public void rotate(int x, int y) {
        if(x == 0 && y == -1)
            direction = NORTH;
        else if(x == 0 && y == 1)
            direction = SOUTH;
        else if(x == 1 && y == 0)
            direction = EAST;
        else if(x == -1 && y == 0)
            direction = WEST;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    @Override
    public boolean isObstacle() {
        return true;
    }

    public void modifyLife(int change){
        if (getLife() + change <= getMaxLife()) {
            setLife(getLife() + change);
        }else{
            System.out.println("Points de vie au maximum !");
        }
    }

    public void action() {
        Activable aimedObject = null;
        for(GameObject object : game.getGameObjects()){
            if(object.isAtPosition(getFrontX(),getFrontY())){
                if(object instanceof Activable){
                    aimedObject =  object;
                }
            }
        }
        if(aimedObject != null){
            if(aimedObject instanceof InventoryObject){
                pickUp(aimedObject);
            }else {
                aimedObject.activate();
                game.notifyView();
            }
        }

    }

    private void pickUp(Activable aimedObject){
        if(inventory.size() < sizeMaxInventory){
            setInventory((InventoryObject) aimedObject);
            ((InventoryObject) aimedObject).setInInventory();
            aimedObject.activate();
            game.notifyView();
        }else{
            System.out.println("Inventaire plein !");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////<setMethods>

    public void setLife(int life){
        this.life = life;
    }

    public void setInventory(InventoryObject object){
        inventory.add(object);
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    @Override
    public int getDirection() {
        return direction;
    }

    public int getFrontX() {
        int delta = 0;
        if (direction % 2 == 0){
            delta += 1 - direction;
        }
        return this.posX + delta;
    }

    public int getFrontY() {
        int delta = 0;
        if (direction % 2 != 0){
            delta += direction - 2;
        }
        return this.posY + delta;
    }

    public int getLife(){
        return life;
    }

    public int getForce(){
        return force;
    }

    public int getSizeInventory(){
        return inventory.size();
    }

    public int getSizeMaxInventory(){
        return sizeMaxInventory;
    }

    public int getMaxLife(){
        return maxLife;
    }

    public ArrayList<InventoryObject> getInventory(){
        return inventory;
    }
}
