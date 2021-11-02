package com.company;

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

    private void drawTile(Graphics g, Tile tile, int x, int y){
        g.setColor(Color.gray);
        g.fillRect(x, y, 100,100);
        g.setColor(Color.CYAN);
        g.drawString( "2", x + 50, y + 50);
    }

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

}
