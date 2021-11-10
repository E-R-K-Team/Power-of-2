package power;

import javax.swing.*;

/**
 * PowerOfTwo.Tile representation in UI
 * @see Tile
 * @author Kirill
 */
public class TileUI {
    private JLabel label;
    private Tile tile;

    public TileUI(JLabel label, Tile tile){
        this.tile=tile;
        this.label= label;
    }

    /**
     * Updates tiles text and color according to value
     */
    public void update(){
        if(tile.getValue() != 0) {
            label.setText(String.valueOf(tile.getValue()));
        } else {
            label.setText(" ");
        }
        label.setOpaque(true);
        label.setBackground(Design.of(tile.getValue()).color());
        label.setForeground(Design.of(tile.getValue()).fontColor());
    }
}
