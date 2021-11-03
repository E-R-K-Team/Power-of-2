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
