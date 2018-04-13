package Objects;

import Model.Activable;
import Model.Deletable;
import Model.DeletableObserver;

import java.util.ArrayList;

public abstract class GameObject implements Activable, Deletable {

    protected int posX;
    protected int posY;
    protected int color;
    protected int id;
    private ArrayList<DeletableObserver> observers = new ArrayList<DeletableObserver>();

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public GameObject(int X, int Y, int color, int id) {
        this.posX = X;
        this.posY = Y;
        this.color = color;
        this.id = id;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    public boolean isAtPosition(int x, int y) {
        return this.posX == x && this.posY == y;
    }

    public abstract boolean isObstacle();

    public abstract void activate();

    @Override
    public void attachDeletable(DeletableObserver po) {
        observers.add(po);
    }

    @Override
    public void notifyDeletableObserver() {
        int i = 0;
        for (DeletableObserver o : observers) {
            i++;
            o.delete(this, null);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public int getColor() {
        return this.color;
    }

    public int getId(){
        return this.id;
    }
}
