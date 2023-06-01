import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario1 extends World
{

    /**
     * Constructor for objects of class Scenario1.
     * 
     */
    private GreenfootSound battleMusic;
    
    public Scenario1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1); 
        battleMusic= new GreenfootSound("sounds/world.mp3");
        battleMusic.play();
        battleMusic.setVolume(30);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        shotGun shotGun = new shotGun();
        addObject(shotGun,291,382);
        Enemy enemy = new Enemy();
        addObject(enemy,421,150);
        Player player = new Player();
        addObject(player,108,336);
        DoorWarp doorWarp = new DoorWarp();
        addObject(doorWarp,1065,484);
        doorWarp.setLocation(1070,493);
    }
}
