package power;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of operations with game field ( gameplay)
 * @author Roman
 */
class BoardTest {

    @Test
    void testBoardCreation(){
        int N = 4;
        Board board = new Board(N);
        assertEquals(N*N, board.getTiles().size());
        assertEquals(1, board.getTiles().stream().filter(t -> t.getValue() != 0).count());
    }

    @Test
    void testSlideLeft() {
        int[] inputTileValues = new int[]{2, 2, 4, 4, 0, 0, 2, 2, 2, 2, 0, 0, 4, 2, 2, 0, 0, 0, 2, 2, 4, 4, 8, 8, 4, 0, 4, 8, 8, 0, 2, 2, 4, 8, 8, 0};
        int[] expectedTileValues = new int[]{4, 8, 0, 0, 0, 0, 4, 4, 0, 0, 0, 0, 4, 4, 0, 0, 0, 0, 4, 8, 16, 0, 0, 0, 8, 16, 0, 0, 0, 0, 4, 4, 16, 0, 0, 0};
        Board board = new Board(6);
        setValuesToTiles(inputTileValues, board);
        board.slideLeft();

        assertTrue(checkValues(expectedTileValues, board));
    }

    @Test
    void testSlideRight() {
        int[] inputTileValues = new int[]{0, 0, 4, 4, 0, 0, 2, 2, 2, 2, 0, 0, 4, 4, 0, 2, 2, 0, 8, 8, 4, 4, 2, 2, 8, 0, 8, 4, 4, 0, 8, 8, 4, 2, 2, 0};
        int[] expectedTileValues = new int[]{0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 4, 4 , 0, 0, 0, 0, 8, 4, 0, 0, 0, 16, 8, 4, 0, 0, 0, 0, 16, 8, 0, 0, 0, 16, 4, 4};
        Board board = new Board(6);
        setValuesToTiles(inputTileValues, board);
        board.slideRight();

        assertTrue(checkValues(expectedTileValues, board));
    }

    @Test
    void testSlideUp() {
        int[] inputTileValues = new int[]{8, 2, 4, 4, 0, 0, 8, 2, 2, 2, 0, 2, 8, 4, 0, 2, 2, 0, 4, 8, 4, 4, 2, 2, 4, 0, 8, 4, 4, 8, 2, 8, 4, 2, 4, 8};
        int[] expectedTileValues = new int[]{16, 4, 4, 4, 4, 4, 8, 4, 2, 4, 8, 16, 8, 16, 4, 8, 0, 0, 2, 0, 8, 2, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Board board = new Board(6);
        setValuesToTiles(inputTileValues, board);
        board.slideUp();

        assertTrue(checkValues(expectedTileValues, board));
    }

    @Test
    void testSlideDown() {
        int[] inputTileValues = new int[]{512, 8, 4, 4, 0, 128, 0, 8, 128, 4, 0, 128, 0, 4, 128, 4, 4, 0, 0, 2, 0, 2, 4, 4, 0, 0, 512, 2, 2, 0, 512, 2, 1024, 4, 2, 4};
        int[] expectedTileValues = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 16, 256, 8, 0, 0, 0, 4, 512, 4, 8, 256, 1024, 4, 1024, 4, 4, 8};
        Board board = new Board(6);
        setValuesToTiles(inputTileValues, board);
        board.slideDown();

        assertTrue(checkValues(expectedTileValues, board));
    }

    private void setValuesToTiles(int[] inputValues, Board board) {
        for (int i = 0; i < inputValues.length; i++) {
            board.getTiles().get(i).setValue(inputValues[i]);
        }
    }

    private boolean checkValues(int[] expectedValues, Board board) {
        for (int i = 0; i < expectedValues.length; i++) {
            if (expectedValues[i] != board.getTiles().get(i).getValue()) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testWinGameState(){
        Board board = new Board(4);
        board.getTiles().get(0).setValue(2048);
        board.spawnTile();
        assertEquals(GameState.WIN, board.getGameState());
    }

    @Test
    void testLoseGameState(){
        Board board = new Board(2);
        board.getTiles().get(0).setValue(512);
        board.getTiles().get(1).setValue(1024);
        board.getTiles().get(2).setValue(32);
        board.spawnTile();
        board.updateGameState();
        assertEquals(GameState.LOSE, board.getGameState());
    }
}