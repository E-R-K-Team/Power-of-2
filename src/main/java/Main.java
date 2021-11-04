import javax.swing.*;

public class Main  {
    private static Board board;
    private static GameGUI gameGUI;

    public static void main(String[] args) {
        board = new Board(4);
	    gameGUI = new GameGUI(board,4);
        gameGUI.setVisible(true);
        gameGUI.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
        gameGUI.setFocusable(true);
        gameGUI.setLocation(GameConstants.SET_WINDOW_LOCATION_X, GameConstants.SET_WINDOW_LOCATION_Y);
        gameGUI.updateLabels();

    }


}
