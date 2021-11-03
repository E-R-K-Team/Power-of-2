import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main  {
    private static Board board;
    private static GameGUI gameGUI;

    public static void main(String[] args) {
        board = new Board(4);
	    gameGUI = new GameGUI(board,4);
        gameGUI.setVisible(true);
        gameGUI.setSize(1000,800);
        gameGUI.setFocusable(true);
        gameGUI.updateLabels();
    }


}
