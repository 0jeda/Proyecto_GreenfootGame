import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scores extends World
{

    /**
     * Constructor for objects of class Scores.
     * 
     */
    public Scores()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1); 
        addObject(new BackButton(), 980, 100);
    }
}
