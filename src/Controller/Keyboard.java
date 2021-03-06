package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Game;
import Model.Directable;
import Moving.Player;

public class Keyboard implements KeyListener {

    private Game game;
    private boolean inventoryState;
    private Player p;

    private static final int player = 0;

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Keyboard(Game game) {
        this.game = game;
        this.p = game.getPlayer();
    }

    ////////////////////////////////////////////////////////////////////////////////////////<KeyMethods>

    @Override
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();

        if(! inventoryState){
            switch (key) {
                case KeyEvent.VK_RIGHT:
                    p.moveCharacter(1, 0);
                    break;
                case KeyEvent.VK_LEFT:
                    p.moveCharacter(-1, 0);
                    break;
                case KeyEvent.VK_DOWN:
                    p.moveCharacter(0, 1);
                    break;
                case KeyEvent.VK_UP:
                    p.moveCharacter(0, -1);
                    break;
                case KeyEvent.VK_SPACE:
                    p.action();
                    break;
                case KeyEvent.VK_P:
                    game.playerPos(player);
                    break;
            }
        }
        else{
            switch (key) {
                case KeyEvent.VK_RIGHT:
                    game.moveIc(Directable.EAST);
                    break;
                case KeyEvent.VK_LEFT:
                    game.moveIc(Directable.WEST);
                    break;
                case KeyEvent.VK_DOWN:
                    game.moveIc(Directable.SOUTH);
                    break;
                case KeyEvent.VK_UP:
                    game.moveIc(Directable.NORTH);
                    break;
                case KeyEvent.VK_SPACE:
                    p.action();
                    break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();
        switch (key) {
            case KeyEvent.VK_I:
                inventoryState = game.switchInventory();
                break;
        }
    }
}
