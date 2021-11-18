package power;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {
    @Test
    public void ScoreUpdateTest(){
        ScoreWindow window = new ScoreWindow();
        Board board = new Board(2);
        int score = board.getScore();
        window.scoreUpdate(board);
        assertEquals("Score:"+score,window.getScoreLabel().getText());
    }

}
