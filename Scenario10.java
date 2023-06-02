import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario10 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario10 extends World
{

    /**
     * Constructor for objects of class Scenario10.
     * 
     */
    public Scenario10()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        LargeWall largeWall = new LargeWall();
        addObject(largeWall,879,306);
        LargeWall largeWall2 = new LargeWall();
        addObject(largeWall2,563,165);
        SmallWall smallWall = new SmallWall();
        addObject(smallWall,563,310);
        LargeWallHorizontal largeWallHorizontal = new LargeWallHorizontal();
        addObject(largeWallHorizontal,432,476);
        SmallWallHorizontal smallWallHorizontal = new SmallWallHorizontal();
        addObject(smallWallHorizontal,600,475);
        LargeWallHorizontal largeWallHorizontal2 = new LargeWallHorizontal();
        addObject(largeWallHorizontal2,118,327);
        MediumWallHorizontal mediumWallHorizontal = new MediumWallHorizontal();
        addObject(mediumWallHorizontal,278,324);
        largeWall.getImage().setTransparency(0);
        largeWall2.getImage().setTransparency(0);
        smallWall.getImage().setTransparency(0);
        mediumWallHorizontal.getImage().setTransparency(0);
        smallWallHorizontal.getImage().setTransparency(0);
        largeWallHorizontal.getImage().setTransparency(0);
        largeWallHorizontal2.getImage().setTransparency(0);
        Enemy enemy = new Enemy();
        addObject(enemy,357,82);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,143,424);
        Enemy enemy3 = new Enemy();
        addObject(enemy3,557,554);
        Enemy enemy4 = new Enemy();
        addObject(enemy4,727,302);
        Enemy enemy5 = new Enemy();
        addObject(enemy5,1017,425);
        DoorWarp doorWarp = new DoorWarp();
        doorWarp.setRotation(270);
        addObject(doorWarp,862,10);
    }
}
