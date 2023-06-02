import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */

    private Player player;

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1);
        setBackground("images/bg_prueba.png");
        player = new Player();
        addObject(player, 300, 200);
        prepare();
    }

    public void act()
    {
            
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Gun gun = new Gun();
        addObject(gun,573,205);
        Enemy enemy = new Enemy();
        addObject(enemy,581,518);
    }
}
