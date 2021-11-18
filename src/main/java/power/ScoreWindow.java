package power;

import javax.swing.*;

public class ScoreWindow extends JFrame {
    private JLabel score = new JLabel();
    private JPanel scorePanel = new JPanel();
    public ScoreWindow(){
        this.setResizable(false);
        this.setBounds(GUIConstants.SET_WINDOW_LOCATION_X, GUIConstants.SET_WINDOW_LOCATION_Y - GUIConstants.SCORE_WINDOW_HEIGHT, GUIConstants.SCORE_WINDOW_WIDTH, GUIConstants.SCORE_WINDOW_HEIGHT);

        scorePanel.setBackground(GUIConstants.SCORE_WINDOW_COLOR);
        scorePanel.add(score);
        this.add(scorePanel);



    }

    public JLabel getScoreLabel(){
        return score;
    }
    public void scoreUpdate(Board board){
        score.setVisible(true);
        score.setOpaque(true);
        score.setLocation(147,-17);
        score.setSize(GUIConstants.SCORE_WINDOW_WIDTH, GUIConstants.SCORE_WINDOW_HEIGHT);
        score.setBackground(GUIConstants.SCORE_WINDOW_COLOR);
        score.setForeground(GUIConstants.SCORE_COLOR);
        score.setFont(GUIConstants.RESULT_FONT);
        score.setText("Score:" + board.getScore());
    }
}
