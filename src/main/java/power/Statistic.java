package power;

import java.io.Serializable;

public class Statistic implements Serializable {
    public int sessionsCount;
    public int wins;
    public int losses;
    public int highestScore;

    public float calculateWinScore(){
        if(sessionsCount==0){
            return 0;
        }
        else{
            return (float)wins/sessionsCount;
        }
    }
}
