/**
 * Game field cell with its coordinates and value
 * @author Roman
 */
public class Tile {
    private final int y;
    private final int x;
    private int value = 0;

    public Tile(int y , int x){
        this.y = y;
        this.x = x;

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
