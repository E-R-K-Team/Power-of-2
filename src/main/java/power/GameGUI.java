package power;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private Statistic statistic ;
    private ScoreWindow score;

    public GameGUI(Board board, int boardSize) {
        setFocusable(true);
        addKeyListener(this);
        this.board = board;
        initializeUITiles(board.getTiles(), boardSize);
        statistic = SaveLoad.LoadStatistic();
        if(statistic==null){
            statistic = new Statistic();
        }
        addWindowListener(new CustomWindowAdapter(this));
        score = new ScoreWindow();
        score.setVisible(true);
        score.scoreUpdate(board);
    }

    /**
     * calls update method for every ui tile
     * @see TileUI#update()
     */
    public void updateLabels() {
        uiTiles.forEach(TileUI::update);
    }

    public void initializeUITiles(List<Tile> tiles, int boardSize) {
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
    public List<TileUI> getUiTiles(){
        return uiTiles;
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
        if (board.wasMoved()) {
            board.spawnTile();
            updateLabels();
            score.scoreUpdate(board);
            //if(board. == 0)
            //    score.setSize(0,0);
            if (GameState.WIN.equals(board.getGameState())) {
                win.setBounds(GUIConstants.SET_RESULT_WINDOW_LOCATION_X, GUIConstants.SET_RESULT_WINDOW_LOCATION_Y, GUIConstants.RESULT_WINDOW_WIDTH, GUIConstants.RESULT_WINDOW_HEIGHT);
                win.setResizable(false);
                win.setVisible(true);
            }
            else if (GameState.LOSE.equals(board.getGameState())) {
                lose.setBounds(GUIConstants.SET_RESULT_WINDOW_LOCATION_X, GUIConstants.SET_RESULT_WINDOW_LOCATION_Y, GUIConstants.RESULT_WINDOW_WIDTH, GUIConstants.RESULT_WINDOW_HEIGHT);
                lose.setResizable(false);
                lose.setVisible(true);
            }
        }
    }

    public List<TileUI> getUITiles(){
        return uiTiles;
    }


    class CustomWindowAdapter extends WindowAdapter {

        GameGUI window = null;

        CustomWindowAdapter(GameGUI window) {
            this.window = window;
        }

        // implement windowClosing method
        public void windowClosing(WindowEvent e) {
            statistic.sessionsCount++;
            if(board.getGameState()==GameState.IN_PROGRESS) {
                SaveLoad.SaveBoardToFile(board);
            } else{
                if(board.getGameState()==GameState.WIN){
                    statistic.wins++;
                }
                else{
                    statistic.losses++;
                }
                SaveLoad.ClearSaveFile();
            }
            if(statistic.highestTile < board.getHighestTileValue()){
                statistic.highestTile = board.getHighestTileValue();
            }
            if(statistic.highestScore < board.getScore()){
                statistic.highestScore = board.getScore();
            }
            SaveLoad.SaveStatistic(statistic);
        }
    }
}
