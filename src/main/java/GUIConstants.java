import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Class that contains constants for size, position etc. of UI elements
 * @author Roman
 */
public class GUIConstants {
    private GUIConstants(){}
    public static final int NORM_LEVEL_WINDOW_WIDTH = 400;
    public static final int NORM_LEVEL_WINDOW_HEIGHT = 425;
    public static final int EASY_LEVEL_WINDOW_WIDTH = 700;
    public static final int EASY_LEVEL_WINDOW_HEIGHT = 725;
    public static final int HARD_LEVEL_WINDOW_WIDTH = 300;
    public static final int HARD_LEVEL_WINDOW_HEIGHT = 325;
    public static final int SET_WINDOW_LOCATION_X = 550;
    public static final int SET_WINDOW_LOCATION_Y = 250;
    public static final int LEFT_UPPER_X = 0;
    public static final int LEFT_UPPER_Y = 0;
    public static final int LABEL_WIDTH = 100;
    public static final int LABEL_HEIGHT = 100;
    public static final Color BG_COLOR = new Color(0xbbada0);
    public static final Font STR_FONT = new Font(Font.SERIF, Font.BOLD, 22);
    public static final int START_WINDOW_HEIGHT = 500;
    public static final int START_WINDOW_WIDTH = 900;
    public static final Color BORDER_COLOR = Color.BLACK;
    public static final Color LABEL_BOARDER_COLOR = new Color(0xbbada0);
    public static final Dimension START_BUTTON_DIMENSION = new Dimension(100, 50);
    public static final Dimension GAME_RULES_DIMENSION= new Dimension(150, 50);
    public static final Dimension DIFFICULTY_LEVEL_DIMENSION= new Dimension(150, 50);
    public static final Border LABEL_BOARDER = BorderFactory.createLineBorder(LABEL_BOARDER_COLOR,5, false);
    public static final Font LOGO_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 150);
    public static final Color LOGO_COLOR = new Color(255, 218, 185);
    public static final Color PANEL_COLOR = new Color(255, 160, 122);

    public static final int EASY_LEVEL_SIZE = 7;
    public static final int NORM_LEVEL_SIZE = 4;
    public static final int HARD_LEVEL_SIZE = 3;
}
