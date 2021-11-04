import javax.swing.*;
import java.awt.*;

public class TileUI {
    private JLabel label;
    private Tile tile;

    public TileUI(JLabel label, Tile tile){
        this.tile=tile;
        this.label= label;
    }

    public void update(){
        if(tile.value != 0)
            label.setText(tile.value+"");
        else
            label.setText(" ");
        label.setOpaque(true);
        label.setBackground(Design.of(tile.value).color());
        label.setForeground(Design.of(tile.value).fontColor());
    }
}
