

import javax.swing.*;
import java.awt.*;

public class Tile {
    private final int y;
    private final int x;
    public int value = 0;

    public Tile(int y , int x, Graphics g){
        this.y = y;
        this.x = x;

    }




    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

}