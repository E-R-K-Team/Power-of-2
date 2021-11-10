import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoseWindow extends JFrame {
    private JLabel loseText = new JLabel();
    private JButton quit = new JButton("Quit");
    private JPanel resultPanel = new JPanel();
    public LoseWindow(){

        loseText.setForeground(Color.RED);
        loseText.setFont(GUIConstants.RESULT_FONT);
        loseText.setText("         \u2620 You LOSE \u2620");

        quit.setPreferredSize(GUIConstants.QUIT_BUTTON_DIMENSION);
        quit.setBorder(GUIConstants.START_BUTTON_BOARDER);
        quit.addActionListener(new QuitButtonListener());

        resultPanel.setBackground(GUIConstants.PANEL_COLOR);
        resultPanel.add(quit);

        this.add(resultPanel);
        this.add(loseText, BorderLayout.NORTH);
    }
    class QuitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
