import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame{
    private JButton startButton = new JButton("Start Game");
    private JButton gameRulesButton = new JButton("The Game Rules");
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JMenu difficultyLevel = new JMenu("Difficulty Level");
    private JMenuBar menuBar = new JMenuBar();
    private ButtonGroup difficultyLevelGroup = new ButtonGroup();
    private JRadioButtonMenuItem easy = new JRadioButtonMenuItem("Easy");
    private JRadioButtonMenuItem norm = new JRadioButtonMenuItem("Norm");
    private JRadioButtonMenuItem hard = new JRadioButtonMenuItem("Hard");
    private static Board board;
    private static GameGUI gameGUI;
    private int size = GUIConstants.NORM_LEVEL_SIZE;
    private int windowWidth = GUIConstants.NORM_LEVEL_WINDOW_WIDTH;
    private int windowHeight = GUIConstants.NORM_LEVEL_WINDOW_HEIGHT;

    public static final Border START_BUTTON_BOARDER = BorderFactory.createLineBorder(GUIConstants.BORDER_COLOR,4, true);
    public StartWindow() {
        this.setBounds(GUIConstants.SET_WINDOW_LOCATION_X, GUIConstants.SET_WINDOW_LOCATION_Y, GUIConstants.START_WINDOW_WIDTH, GUIConstants.START_WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = getContentPane();

        startButton.setPreferredSize(GUIConstants.START_BUTTON_DIMENSION);
        startButton.addActionListener(new StartButtonListener());
        startButton.setBorder(START_BUTTON_BOARDER);

        gameRulesButton.addActionListener(new InfoButtonListener());
        gameRulesButton.setBorder(START_BUTTON_BOARDER);
        gameRulesButton.setPreferredSize(GUIConstants.GAME_RULES_DIMENSION);

        panel.add(gameRulesButton);
        panel.add(startButton);

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
        difficultyLevel.setBorder(START_BUTTON_BOARDER);
        difficultyLevel.setPreferredSize(GUIConstants.DIFFICULTY_LEVEL_DIMENSION);

        //paint StartWindow
        container.setBackground(GUIConstants.BG_COLOR);
        panel.setBackground(new Color(244, 164, 96));

        menuBar.add(difficultyLevel);
        panel.add(menuBar);
        container.add(panel, BorderLayout.NORTH);
    }

    class StartButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            board = new Board(size);
            gameGUI = new GameGUI(board, size);
            gameGUI.setVisible(true);
            gameGUI.setSize(windowWidth, windowHeight);
            gameGUI.setFocusable(true);
            gameGUI.setLocation(GUIConstants.SET_WINDOW_LOCATION_X, GUIConstants.SET_WINDOW_LOCATION_Y);
            gameGUI.updateLabels();
        }
    }
    class InfoButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String rules = "Through some days it will be here!";
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
        }
    }
    class HardLevelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            size = GUIConstants.HARD_LEVEL_SIZE;
            windowWidth = GUIConstants.HARD_LEVEL_WINDOW_WIDTH;
            windowHeight = GUIConstants.HARD_LEVEL_WINDOW_HEIGHT;
        }
    }

}
