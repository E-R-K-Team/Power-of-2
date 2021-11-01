import java.util.Scanner;

public class Game {
    private static int boardSize;
    private final static int MIN_BOARD_SIZE = 3;
    private final static int MAX_BOARD_SIZE = 11;
    private final static char SLIDE_UP_CHAR = 'w';
    private final static char SLIDE_DOWN_CHAR = 's';
    private final static char SLIDE_RIGHT_CHAR = 'd';
    private final static char SLIDE_LEFT_CHAR = 'a';
    private static Scanner scanner;

    public static void main(String[] args){
        scanner= new Scanner(System.in);
        readBoardSize();
        Board board = new Board(boardSize);
        board.spawnTile();
        System.out.println(board);
        do{
            do{
                char ch = readSlideDirection();
                if(ch==SLIDE_UP_CHAR){
                    board.slideUp();
                }
                else if(ch==SLIDE_DOWN_CHAR){
                    board.slideDown();
                }
                else if(ch==SLIDE_LEFT_CHAR){
                    board.slideLeft();
                }
                else{
                    board.slideRight();
                }
                board.spawnTile();
                System.out.println(board);
            }while(!board.wasMoved());
        }while(!board.isGameOver());
        scanner.close();
    }

    private static void readBoardSize(){
        System.out.println("Insert board size (from"+ MIN_BOARD_SIZE+" to "+MAX_BOARD_SIZE+" ) :");
        boolean isIncorrect;
        do {
            if (scanner.hasNextInt()) {
                boardSize = scanner.nextInt();
                if (isNumberInBounds(boardSize,MIN_BOARD_SIZE, MAX_BOARD_SIZE)) {
                    isIncorrect = false;
                } else {
                    System.out.print("Value must be from " + MIN_BOARD_SIZE +
                            " to " + MAX_BOARD_SIZE + " :");
                    isIncorrect = true;
                }
            } else {
                System.out.print("Insert number from " + MIN_BOARD_SIZE +
                        " to " + MAX_BOARD_SIZE + " :");
                scanner.next();
                isIncorrect = true;
            }
        } while (isIncorrect);
    }

    private static boolean isNumberInBounds(int number, int lowerBound, int upperBound) {
        return number >= lowerBound && number <= upperBound;
    }

    private static char readSlideDirection(){
        boolean isIncorrect;
        char ch ;
        do{
            isIncorrect=false;
            ch=scanner.next().charAt(0);
            if(ch!= SLIDE_DOWN_CHAR && ch!=SLIDE_LEFT_CHAR && ch!=SLIDE_RIGHT_CHAR && ch!=SLIDE_UP_CHAR){
                isIncorrect=true;
            }
        }while(isIncorrect);
        return ch;
    }
}
