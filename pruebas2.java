import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pruebas2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pruebas2 extends World
{

    /**
     * Constructor for objects of class pruebas2.
     * 
     */
    public pruebas2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1);
        setBackground("images/ground.png");
        prepare();
    }
    
    private void prepare()
    {
        
        
        Enemy enemy = new Enemy();
        addObject(enemy,420,288);
        enemy.setLocation(706,129);
        DoorWarp doorWarp = new DoorWarp();
        addObject(doorWarp,995,296);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,799,535);
        enemy.setLocation(773,89);
    }
}
