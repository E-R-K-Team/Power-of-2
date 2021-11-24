package power;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class TileUITest {

    @Test
    void update() {
        Tile tile = new Tile(0,0);
        TileUI ui = new TileUI(new JLabel(),tile);
        tile.setValue(1024);
        ui.update();
        assertEquals("1024", ui.label.getText());
    }
}