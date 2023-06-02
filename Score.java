/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score implements Comparable<Score>
{
    // instance variables - replace the example below with your own
    private int score;
    private String playerName;

    /**
     * Constructor for objects of class Score
     */
    public Score(String playerName, int score)
    {
        this.playerName=playerName;
        this.score=score;
    }
    
    public String getPlayerName(){
        return playerName;
    }
    
    public void setPlayerName(String playerName){
        this.playerName=playerName;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(){
        this.score=score;
    }
    
    @Override
    public int compareTo(Score otherScore) {
        // Lógica de comparación basada en el puntaje (score)
        if (this.score < otherScore.score) {
            return -1;
        } else if (this.score > otherScore.score) {
            return 1;
        } else {
            return 0;
        }
    }
}
