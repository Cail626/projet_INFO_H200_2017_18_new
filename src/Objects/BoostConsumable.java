package Objects;

import java.util.function.Supplier;

import Moving.Player;

public class BoostConsumable extends Consumable{

    private String boostType;
    private int boostLength;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public BoostConsumable(int X, int Y, int color, int id, String description, String boostType, int boostLength) {
    	super(X, Y, color, id, description, "boostPotion.png");
        this.boostType = boostType;
        this.boostLength = boostLength;
        
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods

    public void consume(Player p){
        if(boostType == "force"){
            p.setForce(p.getForce() + 1);
        }else if(boostType == "life"){
            p.modifyLife(1);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////<setMethods>

    public void setBoostType(String boostType){
        this.boostType = boostType;
    }

    public void setBoostLength(int boostLength){
        this.boostLength = boostLength;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    public String getBoostType(){
        return boostType;
    }

    public int getBoostLength() {
        return boostLength;
    }
}
