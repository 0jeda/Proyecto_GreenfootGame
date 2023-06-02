import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a description of class Scores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scores extends World
{
    private List<Score> highScoreList;
    private Highscores AllScores = new Highscores();
    private Scoreboard scoreboard;
    
    public Scores()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1); 
        addObject(new BackButton(), 980, 100);
        highScoreList = AllScores.getTopScores();
        scoreboard = new Scoreboard(AllScores, highScoreList);
        addObject(scoreboard, getWidth()/2, getHeight()/2);
    }

}
