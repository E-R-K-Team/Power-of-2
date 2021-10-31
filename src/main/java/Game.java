import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Board board = new Board(4);
        Scanner consoleScanner = new Scanner(System.in);
        board.spawnTile();
        board.printBoard();
        while (!board.isGameOver()) {
            boolean isIncorrect = true;
            while (isIncorrect) {
                isIncorrect = false;
                char ch = consoleScanner.next().charAt(0);
                if (ch == 'w') {
                    board.slideUp();
                } else if (ch == 's') {
                    board.slideDown();
                } else if (ch == 'a') {
                    board.slideLeft();
                } else if (ch == 'd') {
                    board.slideRight();
                } else {
                    isIncorrect = false;
                }
            }
            board.spawnTile();
            board.printBoard();
        }
    }


}
