package power;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaveLoadTest {

    @Test
    void saveLoadBoardToFile() {
        Board board = new Board(5);
        SaveLoad.saveBoardToFile(board);
        assertEquals(board.getSideLength(),SaveLoad.loadBoard().getSideLength());
    }

}