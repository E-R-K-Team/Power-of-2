package power;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private ButtonGroup groupOfMaxTile = new ButtonGroup();
    private JRadioButton bigTile = new JRadioButton("8192");
    private JRadioButton smallTile = new JRadioButton("2048");
    private JRadioButton middleTile = new JRadioButton("4096");
    private ButtonGroup groupOfSpawnChance = new ButtonGroup();
    private JRadioButton smallChance = new JRadioButton("1 %");
    private JRadioButton normChance = new JRadioButton("10 %");
    private JRadioButton bigChance = new JRadioButton("50 %");
    private JPanel panel = new JPanel();
    private JLabel tile = new JLabel("                Choose max tile:                ");
    private JLabel choose = new JLabel("           Choose chance of spawn 4:            ");

    public SettingsWindow(){
        Container container = getContentPane();

        groupOfMaxTile.add(smallTile);
        groupOfMaxTile.add(middleTile);
        groupOfMaxTile.add(bigTile);
        smallTile.setSelected(true);

        groupOfSpawnChance.add(smallChance);
        groupOfSpawnChance.add(normChance);
        groupOfSpawnChance.add(bigChance);
        normChance.setSelected(true);

        panel.add(tile, BorderLayout.NORTH);
        panel.add(bigTile, BorderLayout.CENTER);
        panel.add(smallTile, BorderLayout.CENTER);
        panel.add(middleTile, BorderLayout.CENTER);
        panel.add(choose, BorderLayout.CENTER);
        panel.add(smallChance, BorderLayout.SOUTH);
        panel.add(normChance, BorderLayout.SOUTH);
        panel.add(bigChance, BorderLayout.SOUTH);

        panel.setBackground(GUIConstants.BG_COLOR);

        container.add(panel);
    }

}
