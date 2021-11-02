

import javax.swing.*;
import java.awt.*;

public class TileUI {
    private Tile tile;
    int xCoordinate,yCoordinate;

    public TileUI(Tile tile, int xOffset,int yOffset){
        this.tile = tile;
        xCoordinate=xOffset*tile.getX();
        yCoordinate=yOffset*tile.getY();
    }

    private void drawTile(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(xCoordinate,yCoordinate, GameConstants.TILE_WIDTH, GameConstants.TILE_HEIGHT);
        g.setColor(Color.CYAN);
        g.drawString( tile.value+"", xCoordinate+GameConstants.TEXT_X_OFFSET, yCoordinate + GameConstants.TEXT_Y_OFFSET);
    }

}
