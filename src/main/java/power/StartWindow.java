package power;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates start UI ( start button, rules button, choice of difficulty level and etc.)
 * @author Egor
 */
public class StartWindow extends JFrame{
    private JButton startButton = new JButton("Start Game");
    private JButton creators = new JButton("Developers");
    private JButton gameRulesButton = new JButton("The Game Rules");
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel logoPanel = new JPanel();
    private JMenu difficultyLevel = new JMenu("Difficulty Level");
    private JMenuBar stuff = new JMenuBar();
    private ButtonGroup difficultyLevelGroup = new ButtonGroup();
    private JRadioButtonMenuItem easy = new JRadioButtonMenuItem("Easy");
    private JRadioButtonMenuItem norm = new JRadioButtonMenuItem("Norm");
    private JRadioButtonMenuItem hard = new JRadioButtonMenuItem("Hard");
    private JLabel logoFirst = new JLabel();
    private JLabel logoLast = new JLabel();
    private  transient Board board;
    private  GameGUI gameGUI;
    private int size = GUIConstants.NORM_LEVEL_SIZE;
    private int windowWidth = GUIConstants.NORM_LEVEL_WINDOW_WIDTH;
    private int windowHeight = GUIConstants.NORM_LEVEL_WINDOW_HEIGHT;
    public StartWindow() {
        this.setBounds(GUIConstants.SET_WINDOW_LOCATION_X, GUIConstants.SET_WINDOW_LOCATION_Y, GUIConstants.START_WINDOW_WIDTH, GUIConstants.START_WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        Container container = getContentPane();

        startButton.setPreferredSize(GUIConstants.START_BUTTON_DIMENSION);
        startButton.addActionListener(new StartButtonListener());
        startButton.setBorder(GUIConstants.START_BUTTON_BOARDER);

        gameRulesButton.addActionListener(new InfoButtonListener());
        gameRulesButton.setBorder(GUIConstants.START_BUTTON_BOARDER);
        gameRulesButton.setPreferredSize(GUIConstants.GAME_RULES_DIMENSION);

        creators.setPreferredSize(GUIConstants.GAME_RULES_DIMENSION);
        creators.setBorder(GUIConstants.START_BUTTON_BOARDER);
        creators.addActionListener(new CreatorsButtonListener());


        panel.add(gameRulesButton);
        panel.add(startButton);
        panel.add(creators);

        difficultyLevelGroup.add(easy);
        difficultyLevelGroup.add(norm);
        difficultyLevelGroup.add(hard);

        norm.setSelected(true);

        easy.addActionListener(new EasyLevelActionListener());
        norm.addActionListener(new NormLevelActionListener());
        hard.addActionListener(new HardLevelActionListener());

        difficultyLevel.add(easy);
        difficultyLevel.add(norm);
        difficultyLevel.add(hard);
        difficultyLevel.setPreferredSize(GUIConstants.DIFFICULTY_LEVEL_DIMENSION);

        //paint PowerOfTwo.StartWindow
        logoPanel.setBackground(GUIConstants.BG_COLOR);
        panel.setBackground(GUIConstants.PANEL_COLOR);
        logoFirst.setFont(GUIConstants.LOGO_FONT);
        logoFirst.setForeground(GUIConstants.LOGO_COLOR);
        logoFirst.setText("POWER OF");

        logoLast.setFont(GUIConstants.LOGO_FONT);
        logoLast.setForeground(GUIConstants.LOGO_COLOR);
        logoLast.setText("TWO");

        stuff.add(difficultyLevel);
        stuff.setBackground(GUIConstants.PANEL_COLOR);

        panel.add(stuff);
        logoPanel.add(logoFirst);
        logoPanel.add(logoLast);
        container.add(logoPanel, BorderLayout.CENTER);
        container.add(panel, BorderLayout.SOUTH);

    }

    class StartButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            board = SaveLoad.LoadBoard();
            if(board == null){
                PlayerPreferences preferences = SaveLoad.LoadPreferences();
                if(preferences==null) {
                    board = new Board(size);
                }
                else{
                    board = new Board(size,preferences);
                }
            }
            gameGUI = new GameGUI(board, board.sideLength);
            gameGUI.setVisible(true);
            gameGUI.setResizable(false);
            gameGUI.setSize(windowWidth, windowHeight);
            gameGUI.setFocusable(true);
            gameGUI.setLocation(GUIConstants.SET_WINDOW_LOCATION_X, GUIConstants.SET_WINDOW_LOCATION_Y);
            gameGUI.updateLabels();
        }
    }
    class InfoButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String rules = "Power Of Two rules\n";
            rules += "Power Of Two is played on a plain 4×4 (3×3, 7×7) grid, with numbered tiles that slide when a player moves them using the four arrow keys.";
            rules += "W -> UP, A -> LEFT, S -> DOWN, D -> RIGHT.\n";
            rules += "Every turn, a new tile randomly appears in an empty spot on the board with a value of either 2 or 4.\n";
            rules += "Tiles slide as far as possible in the chosen direction until they are stopped by either another tile or the edge of the grid.\n";
            rules += "If two tiles of the same number collide while moving, they will merge into a tile with the total value of the two tiles that collided.\n";
            rules += "The game is won when a tile with a value of 2048 appears on the board.\n";
            rules += "When the player has no legal moves (there are no empty spaces and no adjacent tiles with the same value), the game ends.";
            JOptionPane.showMessageDialog(null, rules, "GameRules", JOptionPane.PLAIN_MESSAGE);

        }
    }
    class EasyLevelActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            size = GUIConstants.EASY_LEVEL_SIZE;
            windowWidth = GUIConstants.EASY_LEVEL_WINDOW_WIDTH;
            windowHeight = GUIConstants.EASY_LEVEL_WINDOW_HEIGHT;
        }
    }
    class NormLevelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            size = GUIConstants.NORM_LEVEL_SIZE;
            windowWidth = GUIConstants.NORM_LEVEL_WINDOW_WIDTH;
            windowHeight = GUIConstants.NORM_LEVEL_WINDOW_HEIGHT;
            gameGUI.setLocationRelativeTo(logoLast);
        }
    }
    class HardLevelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            size = GUIConstants.HARD_LEVEL_SIZE;
            windowWidth = GUIConstants.HARD_LEVEL_WINDOW_WIDTH;
            windowHeight = GUIConstants.HARD_LEVEL_WINDOW_HEIGHT;
            gameGUI.setLocationRelativeTo(logoFirst);
        }
    }
    class CreatorsButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = "The best ERK developers killed more than 120 hours to give you this game.\n";
            text += "Respect their work and appreciate the quality of product.\n";
            text += "Names of this genius:\n";
            text += "Yegor Rusakovich\t\tKirill Eremeichik\t\tRoman Redkovski";
            JOptionPane.showMessageDialog(null, text, "Developers", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
