import javax.swing.*;

public class TileUI {
    private JLabel label;
    private Tile tile;

    public TileUI(JLabel label , Tile tile){
        this.label=label;
        this.tile=tile;
    }

    public void update(){
        label.setText(tile.value+"");
    }
}
