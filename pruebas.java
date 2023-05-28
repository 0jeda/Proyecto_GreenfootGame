import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pruebas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pruebas extends World
{

    /**
     * Constructor for objects of class pruebas.
     * 
     */
    public pruebas()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,115,93);
        Gun gun = new Gun();
        addObject(gun,259,78);
        Enemy enemy = new Enemy();
        addObject(enemy,420,288);
    }
}
