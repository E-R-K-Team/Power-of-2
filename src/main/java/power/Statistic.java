package power;

import java.io.Serializable;

public class Statistic implements Serializable {
    public int sessionsCount;
    public int wins;
    public int losses;
    public int highestScore;
    public int highestTile;

    public float calculateWinRate(){
        if(sessionsCount==0){
            return 0;
        }
        else{
            return (float)wins/sessionsCount;
        }
    }

    @Override
    public String toString(){
        return "sessions : "+sessionsCount+"    wins : "+wins+"   losses : "+losses+"\n"+" highest score : "+highestScore+
                "  highest tile : "+highestTile +"  win rate : "+calculateWinRate()*100 + "%";
    }
}
