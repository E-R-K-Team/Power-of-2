package power;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveLoad {


    public static void SaveBoardToFile(Board board){
        SaveObjectToFile(FilePaths.saveFilePath,board);
    }

    public static void SavePreferences(PlayerPreferences preferences){
        SaveObjectToFile(FilePaths.preferencesFilePath,preferences);
    }

    public static void SaveStatistic(Statistic statistic){
        SaveObjectToFile(FilePaths.statisticFilePath,statistic);
    }

    public static Board LoadBoard() {
        return LoadObjectFromFile(FilePaths.saveFilePath);
    }

    public static PlayerPreferences LoadPreferences(){
        return LoadObjectFromFile(FilePaths.preferencesFilePath);
    }

    public static Statistic LoadStatistic(){
        return LoadObjectFromFile(FilePaths.statisticFilePath);
    }

    private static <T> void SaveObjectToFile(String filePath, T obj){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath)) ) {
            objectOutputStream.writeObject(obj);
        }catch (Exception exception){}
    }

    private static <T>  T LoadObjectFromFile(String filePath){
        T result = null;
        try(ObjectInputStream objectStream = new  ObjectInputStream(
                new FileInputStream(filePath))){
            result = (T)objectStream.readObject();
        } catch(Exception exception){
        }
        return result;
    }

    public static void ClearSaveFile(){
        try(PrintWriter writer = new PrintWriter(FilePaths.saveFilePath)) {
            writer.print("");
        }catch (Exception exception){}
    }
}
