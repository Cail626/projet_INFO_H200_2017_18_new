package Objects;

public abstract class Block extends GameObject {

    ////////////////////////////////////////////////////////////////////////////////////////<Constructor>

    public Block(int x, int y, int color, int id) {
        super(x, y, color, id);
    }

    ////////////////////////////////////////////////////////////////////////////////////////<diverseMethods

    @Override
    public boolean isObstacle() {
        return true;
    }

}
