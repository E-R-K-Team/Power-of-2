package power;

import java.io.*;

public class SaveLoad {
    private static String saveFilePath = "C:\\Users\\User\\Desktop\\OpiProject\\Power-of-2\\src\\main\\SaveFile.txt";

    public static void SaveBoardToFile(Board board){
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(saveFilePath));
            objectOutputStream.writeObject(board);
            objectOutputStream.close();
        }catch (Exception exception){}
    }

    public static Board TryLoadBoard() {
        Board board = null;
        try{
            ObjectInputStream objectStream = new  ObjectInputStream(
                    new FileInputStream(saveFilePath));
            board = (Board) objectStream.readObject();
            objectStream.close();
        } catch(Exception exception){
        }
        return board;
    }

    public static void ClearSaveFile(){
        try {
            PrintWriter writer = new PrintWriter(saveFilePath);
            writer.print("");
            writer.close();
        }catch (Exception exception){}
    }
}
