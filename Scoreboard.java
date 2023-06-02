import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    /**
     * Act - do whatever the Scoreboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private Highscores highscores;
    private List<Score> topScores;
    
    public Scoreboard(Highscores highscores, List<Score> topScores){
        this.highscores=highscores;
        this.topScores=topScores;
    }
    
    public void act()
    {
        showTopScores(topScores);
    }
    
    private void showTopScores(List<Score> topScores) {
        
        GreenfootImage image = new GreenfootImage(200, 200);

        for (int i = 0; i < topScores.size(); i++) {
            Score score = topScores.get(i);
            String text = (i + 1) + ". " + score.getPlayerName() + ": " + score.getScore();
            image.drawString(text, 80, 20 * (i + 1));
        }
        
        setImage(image);
    }
}
