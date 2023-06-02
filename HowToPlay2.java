import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HowToPlay2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HowToPlay2 extends World
{

    /**
     * Constructor for objects of class HowToPlay2.
     * 
     */
    public HowToPlay2()
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
        ForwardButton2 forwardButton2 = new ForwardButton2();
        addObject(forwardButton2,953,467);
        forwardButton2.setLocation(947,468);
    }
}
