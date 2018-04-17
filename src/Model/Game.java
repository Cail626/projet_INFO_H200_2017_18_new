package Model;

import Moving.*;
import Moving.Character;
import Objects.*;
import View.Window;

import java.io.*;
import java.util.ArrayList;

public class Game implements DeletableObserver {

    private ArrayList<GameObject> objects = new ArrayList<>();
    private Player player;
    private Window window;
    private int size = 20;
    //private int numberOfBreakableBlocks = 10;
    private int playerNumber = 1;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Game(Window window) {
        this.window = window;

        // Creating one Player at position (10,10)
        player = new Warrior(10, 10, 3, 5, 5, new ArrayList<>(), 3, playerNumber, 1, 0);
        objects.add(player);

        // Map building
        buildMap("map0.txt", player);
    }

    ////////////////////////////////////////////////////////////////////////////////////////<mapMethods>

    private void buildMap(String file, Player player){

        String text = "";

        try{
            BufferedReader in = new BufferedReader(new FileReader(file));

            text = in.readLine();

            while(text != null){
                text = text.trim();

                if ("size".compareTo(text) == 0){
                    size = Integer.valueOf(in.readLine());
                }
                else if("option".compareTo(text) == 0){
                    mapOption(in);
                }
                else if("gameObject(id,x,y)".compareTo(text) == 0){
                    mapObject(in);
                }
                text = in.readLine();
            }

            // Creating consumables
            for(int i = 0; i < 4; i++){
                Consumable potion = new HealingConsumable(5+i,2,2, 5, "potion1", 1);
                potion.attachDeletable(this);
                objects.add(potion);
            }
            Consumable potion2 = new BoostConsumable(6,3,3, 5, "potion2", "force", 2);
            potion2.attachDeletable(this);
            objects.add(potion2);
            Consumable potion3 = new BoostConsumable(7,3,4, 5, "potion2", "life", 2);

            Weapon weapon1 = new Weapon(16, 16, 6, 9, "staff", 3);
            weapon1.attachDeletable(this);
            objects.add(weapon1);

            ArrayList<InventoryObject> loot = new ArrayList<>();
            loot.add(potion3);

            // Creating monsters
            Character monster1 = new Monster(15,15, 5, 5, 5, 5, 6, loot, 3, 6, 2);
            objects.add(monster1);

            window.setGameObjects(this.getGameObjects());
            in.close();

        } catch(FileNotFoundException e){
            System.out.println(e);
        } catch( IOException e){
            System.out.println(e);
        }
        notifyView();
    }

    private void mapObject(BufferedReader in) throws IOException{
        String[] text;
        int id;
        int x;
        int y;
        int numObject = Integer.valueOf(in.readLine());
        for(int i=0; i<numObject; i++){
            text = in.readLine().split(" ");
            id = Integer.valueOf(text[0]);
            x = Integer.valueOf(text[1]);
            y = Integer.valueOf(text[2]);
            switch(id){
                case 1:
                    BlockBreakable block = new BlockBreakable(x, y, 4);
                    block.attachDeletable(this);
                    objects.add(block);
                    break;
            }
        }
    }

    private void mapOption(BufferedReader in) throws IOException{
        String text;
        text = in.readLine().trim();
        if ("exitEast".compareTo(text) == 0) {
            for (int i = 0; i < size; i++) {
                objects.add(new BlockInactive(i, 0));
                objects.add(new BlockInactive(0, i));
                objects.add(new BlockInactive(i, size - 1));
                if(i!= size/2){
                    objects.add(new BlockInactive(size - 1, i));
                }
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////<characterMethods>

    synchronized public void moveCharacter(int x, int y, int characterNumber) {
        Player player = ((Player) objects.get(characterNumber));
        int nextX = player.getPosX() + x;
        int nextY = player.getPosY() + y;

        boolean obstacle = false;
        for (GameObject object : objects) {
            if (object.isAtPosition(nextX, nextY)) {
                obstacle = object.isObstacle();
            }
            if (obstacle == true) {
                break;
            }
        }
        player.rotate(x, y);
        if (obstacle == false) {
            player.move(x, y);
        }
        //teste si on quitte la map
        if (nextX == (size - 1) || nextY == (size - 1) ){
            System.out.println("map quitte");
        }
        notifyView();
    }

    public void action(int playerNumber) {
        Activable aimedObject = null;
		for(GameObject object : objects){
			if(object.isAtPosition(player.getFrontX(),player.getFrontY())){
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
                notifyView();
            }
		}

    }

    private void pickUp(Activable aimedObject){
        int sizeMax = player.getSizeMaxInventory();
        int number = player.getSizeInventory();
        if(number < sizeMax){
            player.setInventory((InventoryObject) aimedObject);
            aimedObject.activate();
            notifyView();
        }else{
            System.out.println("Inventaire plein !");
        }
    }

    public void playerPos(int playerNumber) {
        Player player = ((Player) objects.get(playerNumber));
        System.out.println(player.getPosX() + ":" + player.getPosY());

    }

    ////////////////////////////////////////////////////////////////////////////////////////<windowMethods>

    public boolean switchInventory(){
        boolean inventoryState = window.switchInventory();
        return inventoryState;
    }

    private void notifyView() {
        window.update();
    }

    public void moveIc(int direction){
        window.moveIc(direction);
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods>

    @Override
    synchronized public void delete(Deletable ps, ArrayList<GameObject> loot) {
        objects.remove(ps);
        if (loot != null) {
            objects.addAll(loot);
        }
        notifyView();
    }

    ////////////////////////////////////////////////////////////////////////////////////////<getMethods>

    public ArrayList<GameObject> getGameObjects() {
        return this.objects;
    }

}