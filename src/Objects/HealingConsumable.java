package Objects;

import Moving.Player;

public class HealingConsumable extends Consumable{

    private int healingPower;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public HealingConsumable(int X, int Y, int color, int id, String description, int healingPower) {
        super(X, Y, color, id, description);
        this.healingPower = healingPower;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    public void consume(Player p){
        p.modifyLife(healingPower);
    }

    ////////////////////////////////////////////////////////////////////////////////////////<setMethods>

    public void setHealingPower(int healingPower){
        this.healingPower = healingPower;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    public int getHealingPower(){
        return healingPower;
    }
}
