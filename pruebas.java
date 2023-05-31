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
        super(1080, 600, 1);
        setBackground("images/ground.png");
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
        enemy.setLocation(706,129);
        removeObject(gun);
        assaultRifle assaultRifle = new assaultRifle();
        addObject(assaultRifle,131,250);
        shotGun shotGun = new shotGun();
        addObject(shotGun,142,376);
        simpleGun simpleGun = new simpleGun();
        addObject(simpleGun,132,490);
    }
}
