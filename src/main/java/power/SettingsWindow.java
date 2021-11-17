package power;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class SettingsWindow extends JFrame {
    private JComboBox box = new JComboBox();
    JSlider chanceSlider = new JSlider();
    private JPanel panel = new JPanel();
    private JLabel tile = new JLabel("                Choose max tile:                ");
    private JLabel choose = new JLabel("           Choose chance of spawn 4:            ");
    private JLabel chance = new JLabel("");
    private PlayerPreferences preferences;

    public SettingsWindow(){
        Container container = getContentPane();
        preferences = SaveLoad.LoadPreferences();
        if(preferences==null){
            preferences = new PlayerPreferences();
        }

        chanceSlider.setMaximum(100);
        chanceSlider.setMinimum(0);
        chanceSlider.setValue((int)(preferences.chanceToSpawnFour*100));
        chanceSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                chance.setText(String.valueOf(chanceSlider.getValue()));
            }
        });
        chance.setText(String.valueOf(chanceSlider.getValue()));

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
        box=new JComboBox(strings.stream().toArray());
        box.setSelectedIndex(selectedIndex);
        panel.add(box);
        panel.add(choose, BorderLayout.CENTER);
        panel.add(chanceSlider);
        panel.add(chance);


        panel.setBackground(GUIConstants.BG_COLOR);

        container.add(panel);
        addWindowListener(new CustomWindowAdapter());
    }

    class CustomWindowAdapter extends WindowAdapter {


        // implement windowClosing method
        public void windowClosing(WindowEvent e) {
           preferences.chanceToSpawnFour =((float) chanceSlider.getValue())/100;
           String str =(String) box.getSelectedItem();
           preferences.maxTileValue = Integer.parseInt(str);
           SaveLoad.SavePreferences(preferences);
        }
    }

}
