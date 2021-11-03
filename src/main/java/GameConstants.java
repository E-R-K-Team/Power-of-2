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
    public final static int WINDOW_WIDTH = 600;
    public final static int WINDOW_HEIGHT = 600;
    public final static int SET_WINDOW_LOCATION_X = 500;
    public final static int SET_WINDOW_LOCATION_Y = 500;
}
