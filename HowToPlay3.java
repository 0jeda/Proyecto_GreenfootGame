import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowToPlay3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HowToPlay3 extends World
{

    /**
     * Constructor for objects of class HowToPlay3.
     * 
     */
    public HowToPlay3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1); 
        addObject(new BackButton(), 980, 100);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ForwardButton3 forwardButton3 = new ForwardButton3();
        addObject(forwardButton3,898,448);
    }
}
