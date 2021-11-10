import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinWindow extends JFrame {
    private JLabel winText = new JLabel();
    private JButton quit = new JButton("Quit");
    private JPanel resultPanel = new JPanel();
    public WinWindow(){

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        winText.setForeground(GUIConstants.WIN_COLOR);
        winText.setFont(GUIConstants.RESULT_FONT);
        winText.setText("          \u265A You WIN \u265A");

        quit.setPreferredSize(GUIConstants.QUIT_BUTTON_DIMENSION);
        quit.setBorder(GUIConstants.START_BUTTON_BOARDER);
        quit.addActionListener(new QuitButtonListener());

        resultPanel.setBackground(GUIConstants.PANEL_COLOR);
        resultPanel.add(quit);

        this.add(resultPanel);
        this.add(winText, BorderLayout.NORTH);
    }
    class QuitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
