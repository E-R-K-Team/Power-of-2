
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
    private JButton button = new JButton("Start Game");



    public GUI() {
        this.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(GameConstants.SET_WINDOW_LOCATION_X, GameConstants.SET_WINDOW_LOCATION_Y);
        Logic PowerLogic = new Logic();
        this.add(PowerLogic);
        this.setResizable(false);

        //Container container = this.getContentPane();
        //container.setLayout(new GridLayout(3, 2, 2, 2));
        //button.addActionListener(new ButtonEventListener());
        //container.add(button);
    }

        class ButtonEventListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }

}
