package Objects;

import Moving.Mage;
import Moving.Player;
import Moving.Warrior;

public class Weapon extends InventoryObject{

    protected int bonus;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Weapon(int x, int y, int color, int id, String description, int bonus){
        super(x, y, color, id, description, description + ".png");
        this.bonus = bonus;
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    //renvoie si oui ou non le joueur peut s'équiper de cette arme
    public boolean equip(Player p){
        boolean result = true;
    	if(super.getDescription() == "staff" && p instanceof Mage){
            ((Mage) p).setBlastRange(((Mage) p).getBlastRange() + bonus);
        }else if(super.getDescription() == "sword"){
            p.setForce(p.getForce() + bonus);
        }else if(super.getDescription() == "axe" && p instanceof Warrior){
            p.setForce(p.getForce() + bonus);
        }else{
        	result = false;
            System.out.println("Vous ne pouvez pas equiper cette arme !");
        }
        return result;
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
