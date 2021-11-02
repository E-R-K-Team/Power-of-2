import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton button = new JButton("Start Game");



    public GUI() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300,600);
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
