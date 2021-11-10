package power;

/**
 * Game field cell with its coordinates and value
 * @author Roman
 */
public class Tile {
    private final int y;
    private final int x;
    private int value;

    public Tile(int y , int x){
        this.y = y;
        this.x = x;
        this.value = 0;
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
