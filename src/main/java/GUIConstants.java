import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GUIConstants {
    private GUIConstants(){}

    public static final int MIN_BOARD_SIZE = 4;
    public static final int MAX_BOARD_SIZE = 6;
    public static final float CHANCE_TO_SPAWN_FOUR = 0.1f;

    public static final int WIN_TILE_VALUE = 2048;

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
    public static final int START_WINDOW_HEIGHT = 1000;
    public static final int START_WINDOW_WIDTH = 1000;
    public static final Color BORDER_COLOR = new Color(000);
    public static final Color LABEL_BOARDER_COLOR = new Color(0xbbada0);
    public static final Dimension START_BUTTON_DIMENSION = new Dimension(100, 50);
    public static final Dimension GAME_RULES_DIMENSION= new Dimension(150, 50);
    public static final Dimension DIFFICULTY_LEVEL_DIMENSION= new Dimension(150, 50);
    public static final Border LABEL_BOARDER = BorderFactory.createLineBorder(LABEL_BOARDER_COLOR,5, false);
    public static final int EASY_LEVEL_SIZE = 7;
    public static final int NORM_LEVEL_SIZE = 4;
    public static final int HARD_LEVEL_SIZE = 3;
}
