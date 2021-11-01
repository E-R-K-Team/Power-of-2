import java.util.Scanner;

public class Game {
    private static int boardSize;
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
                if(ch==GameConstants.SLIDE_UP_CHAR){
                    board.slideUp();
                }
                else if(ch==GameConstants.SLIDE_DOWN_CHAR){
                    board.slideDown();
                }
                else if(ch==GameConstants.SLIDE_LEFT_CHAR){
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
        System.out.println("Insert board size (from "+ GameConstants.MIN_BOARD_SIZE+" to "+GameConstants.MAX_BOARD_SIZE+" ) :");
        boolean isIncorrect;
        do {
            if (scanner.hasNextInt()) {
                boardSize = scanner.nextInt();
                if (isNumberInBounds(boardSize,GameConstants.MIN_BOARD_SIZE, GameConstants.MAX_BOARD_SIZE)) {
                    isIncorrect = false;
                } else {
                    System.out.print("Value must be from " + GameConstants.MIN_BOARD_SIZE +
                            " to " + GameConstants.MAX_BOARD_SIZE + " :");
                    isIncorrect = true;
                }
            } else {
                System.out.print("Insert number from " + GameConstants.MIN_BOARD_SIZE +
                        " to " + GameConstants.MAX_BOARD_SIZE + " :");
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
            if(ch!= GameConstants.SLIDE_DOWN_CHAR && ch!=GameConstants.SLIDE_LEFT_CHAR && ch!=GameConstants.SLIDE_RIGHT_CHAR && ch!=GameConstants.SLIDE_UP_CHAR){
                isIncorrect=true;
            }
        }while(isIncorrect);
        return ch;
    }
}
