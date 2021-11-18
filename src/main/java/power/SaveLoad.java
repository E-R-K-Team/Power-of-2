package power;

import java.io.*;

public class SaveLoad {

    private SaveLoad(){}


    public static void saveBoardToFile(Board board){
        saveObjectToFile(FilePaths.SAVE_FILE_PATH,board);
    }

    public static void savePreferences(PlayerPreferences preferences){
        saveObjectToFile(FilePaths.PREFERENCES_FILE_PATH,preferences);
    }

    public static void saveStatistic(Statistic statistic){
        saveObjectToFile(FilePaths.STATISTIC_FILE_PATH,statistic);
    }

    public static Board loadBoard() {
        return loadObjectFromFile(FilePaths.SAVE_FILE_PATH);
    }

    public static PlayerPreferences loadPreferences(){
        return loadObjectFromFile(FilePaths.PREFERENCES_FILE_PATH);
    }

    public static Statistic loadStatistic(){
        return loadObjectFromFile(FilePaths.STATISTIC_FILE_PATH);
    }

    private static <T> void saveObjectToFile(String filePath, T obj){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath)) ) {
            objectOutputStream.writeObject(obj);
        }catch (Exception exception){
            //this is mis
        }
    }

    private static <T>  T loadObjectFromFile(String filePath){
        T result = null;
        try(ObjectInputStream objectStream = new  ObjectInputStream(
                new FileInputStream(filePath))){
            result = (T)objectStream.readObject();
        } catch(Exception exception){
            //this is mis
        }
        return result;
    }

    public static void clearSaveFile(){
        try(PrintWriter writer = new PrintWriter(FilePaths.SAVE_FILE_PATH)) {
            writer.print("");
        }catch (Exception exception){
            //this is mis
        }
    }
}
