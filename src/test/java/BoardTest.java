import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    @Test
    public void testSlideLeft() {
        int[] inputTileValues = new int[]{0, 0, 0, 2, 2, 2, 0, 0, 0, 2, 0, 0, 0, 0, 4, 0};
        int[] expectedTileValues = new int[]{2, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0};
        Board board = new Board(4);
        setValuesToTiles(inputTileValues, board);
        board.slideLeft();

        assertTrue(checkValues(expectedTileValues, board));
    }


    private void setValuesToTiles(int[] inputValues, Board board) {
        for (int i = 0; i < inputValues.length; i++) {
            board.getBoard().get(i).value = inputValues[i];
        }
    }

    private boolean checkValues(int[] expectedValues, Board board) {
        for (int i = 0; i < expectedValues.length; i++) {
            if (expectedValues[i] != board.getBoard().get(i).value) {
                return false;
            }
        }
        return true;
    }


}
