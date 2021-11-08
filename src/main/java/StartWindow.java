import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame{
    private JButton startButton = new JButton("Start Game");
    private JButton infoButton = new JButton("The Game Rules");
    private static Board board;
    private static GameGUI gameGUI;
    public static final Border START_BUTTON_BOARDER = BorderFactory.createLineBorder(GameConstants.BORDER_COLOR,4, true);
    public StartWindow() {
        this.setBounds(GameConstants.SET_WINDOW_LOCATION_X, GameConstants.SET_WINDOW_LOCATION_Y, GameConstants.START_WINDOW_WIDTH, GameConstants.START_WINDOW_HEIGHT);
        this.setBackground(GameConstants.BG_COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        startButton.setPreferredSize(GameConstants.START_BUTTON_DIMENSION);
        startButton.addActionListener(new StartButtonListener());
        startButton.setBorder(START_BUTTON_BOARDER);


        infoButton.addActionListener(new InfoButtonListener());
        infoButton.setBorder(START_BUTTON_BOARDER);
        infoButton.setPreferredSize(GameConstants.START_BUTTON_DIMENSION);


        JPanel buttonPanel = new JPanel(new GridLayout(2,1));
        buttonPanel.setSize(GameConstants.START_BUTTON_DIMENSION);
        buttonPanel.add(startButton);
        buttonPanel.add(infoButton);


        this.add(buttonPanel);




    }

    class StartButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            board = new Board(4);
            gameGUI = new GameGUI(board,4);
            gameGUI.setVisible(true);
            gameGUI.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
            gameGUI.setFocusable(true);
            gameGUI.setLocation(GameConstants.SET_WINDOW_LOCATION_X, GameConstants.SET_WINDOW_LOCATION_Y);
            gameGUI.updateLabels();
        }
    }
    class InfoButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String rules = "Through some days it will be here!";
            JOptionPane.showMessageDialog(null, rules, "GameRules", JOptionPane.PLAIN_MESSAGE);

        }
    }

}
