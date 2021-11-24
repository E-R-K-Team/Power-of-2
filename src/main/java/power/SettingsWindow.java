package power;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class SettingsWindow extends JFrame {
    private JComboBox<String> box;
    JSlider chanceSlider = new JSlider();
    private JPanel panel = new JPanel();
    private JLabel tile = new JLabel("                Choose max tile:                ");
    private JLabel choose = new JLabel("           Choose chance of spawn 4:            ");
    private JLabel chance = new JLabel("");
    private PlayerPreferences preferences;
    private JButton setSettings = new JButton("Save Settings");

    public SettingsWindow(){
        Container container = getContentPane();
        preferences = SaveLoad.loadPreferences();
        if(preferences==null){
            preferences = new PlayerPreferences();
        }

        chanceSlider.setMaximum(100);
        chanceSlider.setMinimum(0);
        chanceSlider.setValue((int)(preferences.chanceToSpawnFour*100));
        chanceSlider.addChangeListener( e -> chance.setText(String.valueOf(chanceSlider.getValue())));
        chance.setText(String.valueOf(chanceSlider.getValue()));

        setSettings.addActionListener(new SetSettingsListener());


        panel.add(tile, BorderLayout.NORTH);
        int selectedIndex = 0;
        int currentIndex =0 ;
        ArrayList<String> strings = new ArrayList<>();
        for(int i = 8 ; i<=8192;i+=i){
            strings.add(String.valueOf(i));
            if(i==preferences.maxTileValue){
                selectedIndex=currentIndex;
            }
            else{
                currentIndex++;
            }
        }
        box=new JComboBox<>(strings.stream().toArray(String[]::new));
        box.setSelectedIndex(selectedIndex);
        panel.add(box);
        panel.add(choose, BorderLayout.CENTER);
        panel.add(chanceSlider);
        panel.add(chance);
        panel.add(setSettings, BorderLayout.SOUTH);

        panel.setBackground(GUIConstants.BG_COLOR);

        container.add(panel);
        addWindowListener(new CustomWindowAdapter());
    }

    public JLabel getChanceTile(){
        return chance;
    }

    class CustomWindowAdapter extends WindowAdapter {
        // implement windowClosing method
        @Override
        public void windowClosing(WindowEvent e) {
           preferences.chanceToSpawnFour =((float) chanceSlider.getValue())/100;
           String str =(String) box.getSelectedItem();
           preferences.maxTileValue = Integer.parseInt(str);
           SaveLoad.savePreferences(preferences);
        }
    }

    class SetSettingsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            preferences.chanceToSpawnFour =((float) chanceSlider.getValue())/100;
            String str =(String) box.getSelectedItem();
            preferences.maxTileValue = Integer.parseInt(str);
            SaveLoad.savePreferences(preferences);
        }
    }

}
