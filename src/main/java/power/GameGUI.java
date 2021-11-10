package power;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Displays, updates tiles and read input
 * @author Kirill + Egor + Roman
 */
public class GameGUI extends JFrame implements KeyListener, ActionListener {
    private transient List<TileUI> uiTiles;
    private transient Board board;
    private  LoseWindow lose = new LoseWindow();
    private WinWindow win = new WinWindow();


    public GameGUI(Board board, int boardSize) {
        setFocusable(true);
        addKeyListener(this);
        this.board = board;

        initializeUITiles(board.getTiles(), boardSize);
    }

    /**
     * calls update method for every ui tile
     * @see TileUI#update()
     */
    public void updateLabels() {
        uiTiles.forEach(TileUI::update);
    }

    private void initializeUITiles(List<Tile> tiles, int boardSize) {
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
        // this method is empty, because it is unused
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // this method is empty, because it is unused
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
            win.setBounds(GUIConstants.SET_RESULT_WINDOW_LOCATION_X, GUIConstants.SET_RESULT_WINDOW_LOCATION_Y, GUIConstants.RESULT_WINDOW_WIDTH, GUIConstants.RESULT_WINDOW_HEIGHT);
            win.setResizable(false);
            win.setVisible(true);
        } else if (board.wasMoved()) {
            board.spawnTile();
            updateLabels();
            if (GameState.LOSE.equals(board.getGameState())) {
                lose.setBounds(GUIConstants.SET_RESULT_WINDOW_LOCATION_X, GUIConstants.SET_RESULT_WINDOW_LOCATION_Y, GUIConstants.RESULT_WINDOW_WIDTH, GUIConstants.RESULT_WINDOW_HEIGHT);
                lose.setResizable(false);
                lose.setVisible(true);
            }
        }
    }
}
