import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUIConstants {
    private GUIConstants(){}

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 425;
    public static final int SET_WINDOW_LOCATION_X = 550;
    public static final int SET_WINDOW_LOCATION_Y = 250;
    public static final int LEFT_UPPER_X = 0;
    public static final int LEFT_UPPER_Y = 0;
    public static final int LABEL_WIDTH = 100;
    public static final int LABEL_HEIGHT = 100;
    public static final int START_WINDOW_HEIGHT = 1000;
    public static final int START_WINDOW_WIDTH = 1000;
    public static final Font STR_FONT = new Font(Font.SERIF, Font.BOLD, 22);
    public static final Dimension START_BUTTON_DIMENSION = new Dimension(150, 150);
    public static final Border LABEL_BOARDER = BorderFactory.createLineBorder(GUIConstants.LABEL_BOARDER_COLOR,5, false);
    public static final Color BG_COLOR = new Color(0xbbada0);
    public static final Color BORDER_COLOR = new Color(000);
    public static final Color LABEL_BOARDER_COLOR = new Color(0xbbada0);
}
