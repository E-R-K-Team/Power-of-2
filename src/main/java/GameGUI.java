import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Displays, updates tiles and read input
 * @author Kirill + Egor + Roman
 */
public class GameGUI extends JFrame implements KeyListener, ActionListener {
    private ArrayList<TileUI> uiTiles;
    private Board board;


    public GameGUI(Board board, int boardSize) {
        setFocusable(true);
        addKeyListener(this);
        this.board = board;
        initializeUITiles(board.tiles, boardSize);
    }


    public void updateLabels() {
        uiTiles.forEach(tile -> tile.update());
    }

    private void initializeUITiles(ArrayList<Tile> tiles, int boardSize) {
        uiTiles = new ArrayList<>();
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                JLabel label = new JLabel(" ", SwingConstants.CENTER);
                int xCoord = GUIConstants.LEFT_UPPER_X + x * GUIConstants.LABEL_WIDTH;
                int yCoord = GUIConstants.LEFT_UPPER_Y + y * GUIConstants.LABEL_HEIGHT;
                label.setLocation(xCoord, yCoord);
                label.setSize(GUIConstants.LABEL_WIDTH, GUIConstants.LABEL_HEIGHT);
                label.setVisible(true);
                label.setOpaque(true);
                label.setBackground(Color.pink);
                label.setFont(GUIConstants.STR_FONT);
                label.setForeground(Color.gray);
                label.setBorder(GUIConstants.LABEL_BOARDER);
                this.add(label);
                uiTiles.add(new TileUI(label, tiles.get(x + y * boardSize)));
            }
        }
        this.add(new JLabel());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            board.slideLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            board.slideUp();
        } else if ((e.getKeyCode() == KeyEvent.VK_D)) {
            board.slideRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            board.slideDown();
        }

        if (GameState.WIN.equals(board.getGameState())) {
            //TODO: add logic for win case
        } else if (board.wasMoved()) {
            board.spawnTile();
            updateLabels();
            if (GameState.LOSE.equals(board.getGameState())) {
                //TODO: add logic for lose case
            }
        }
    }
}
