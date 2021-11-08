import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GameConstants {
    public static final int MIN_BOARD_SIZE = 4;
    public static final int MAX_BOARD_SIZE = 6;
    public static final float CHANCE_TO_SPAWN_FOUR = 0.1f;
    public static final char SLIDE_UP_CHAR = 'w';
    public static final char SLIDE_DOWN_CHAR = 's';
    public static final char SLIDE_RIGHT_CHAR = 'd';
    public static final char SLIDE_LEFT_CHAR = 'a';
    public static final int WIN_TILE_VALUE = 2048;
    public static final List<Character> CONTROL_BUTTONS = Arrays.asList(SLIDE_UP_CHAR, SLIDE_DOWN_CHAR, SLIDE_LEFT_CHAR, SLIDE_RIGHT_CHAR);
    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 425;
    public static final int SET_WINDOW_LOCATION_X = 550;
    public static final int SET_WINDOW_LOCATION_Y = 250;
    public static final int LEFT_UPPER_X = 0;
    public static final int LEFT_UPPER_Y = 0;
    public static final int LABEL_WIDTH = 100;
    public static final int LABEL_HEIGHT = 100;
    public static final Color BG_COLOR = new Color(0xbbada0);
    public static final Font STR_FONT = new Font(Font.SERIF, Font.BOLD, 22);
    public static final int START_WINDOW_HEIGHT = 1000;
    public static final int START_WINDOW_WIDTH = 1000;
    public static final Color BORDER_COLOR = new Color(000);
    public static final Color LABEL_BOARDER_COLOR = new Color(0xbbada0);
    public static final Dimension START_BUTTON_DIMENSION = new Dimension(50, 50);
    public static final Border LABEL_BOARDER = BorderFactory.createLineBorder(GameConstants.LABEL_BOARDER_COLOR,5, false);

}
