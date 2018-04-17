package Objects;

import Moving.Mage;
import Moving.Player;
import Moving.Warrior;

public class Weapon extends InventoryObject{

    protected int bonus;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Weapon(int x, int y, int color, int id, String description, int bonus){
        super(x, y, color, id, description);
        this.bonus = bonus;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    public void equip(Player p){
        if(super.getDescription() == "staff" && p instanceof Mage){
            ((Mage) p).setBlastRange(((Mage) p).getBlastRange() + bonus);
        }else if(super.getDescription() == "sword"){
            p.setForce(p.getForce() + bonus);
        }else if(super.getDescription() == "axe" && p instanceof Warrior){
            p.setForce(p.getForce() + bonus);
        }else{
            System.out.println("Vous ne pouvez pas équiper cette arme !");
        }
    }

    @Override
    public boolean isObstacle() {
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<setMethods>

    public void setBonus(int bonus){
        this.bonus = bonus;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    public int getBonus(){
        return bonus;
    }
}
