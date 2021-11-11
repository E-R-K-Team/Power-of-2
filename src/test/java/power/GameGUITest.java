package power;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class GameGUITest {

    @Test
    void initializeUITiles() {
        Board board = new Board(2);
        GameGUI gui = new GameGUI(board,2);
        gui.initializeUITiles(board.getTiles(),2);

        assertEquals(gui.getUITiles().size(),4);
    }

    @Test
    void keyReleased(){
        Board board = new Board(2);
        GameGUI gui = new GameGUI(board,2);

        gui.keyReleased(new KeyEvent(new Button(),0,0,0,KeyEvent.VK_A));

        board.updateGameState();
        assertEquals(GameState.IN_PROGRESS,board.getGameState());
    }


}