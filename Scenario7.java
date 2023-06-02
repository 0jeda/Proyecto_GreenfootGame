import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario7 extends World
{

    /**
     * Constructor for objects of class Scenario7.
     * 
     */
    public Scenario7()
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
        addObject(largeWall,187,117);
        LargeWall largeWall2 = new LargeWall();
        addObject(largeWall2,187,356);
        LargeWall largeWall3 = new LargeWall();
        addObject(largeWall3,260,118);
        LargeWall largeWall4 = new LargeWall();
        addObject(largeWall4,261,360);
        LargeWall largeWall5 = new LargeWall();
        addObject(largeWall5,497,479);
        LargeWall largeWall6 = new LargeWall();
        addObject(largeWall6,495,250);
        LargeWall largeWall7 = new LargeWall();
        addObject(largeWall7,565,474);
        MediumWall mediumWall = new MediumWall();
        addObject(mediumWall,565,298);
        LargeWallHorizontal largeWallHorizontal = new LargeWallHorizontal();
        addObject(largeWallHorizontal,631,151);
        LargeWallHorizontal largeWallHorizontal2 = new LargeWallHorizontal();
        addObject(largeWallHorizontal2,842,151);
        LargeWallHorizontal largeWallHorizontal3 = new LargeWallHorizontal();
        addObject(largeWallHorizontal3,664,226);
        LargeWallHorizontal largeWallHorizontal4 = new LargeWallHorizontal();
        addObject(largeWallHorizontal4,840,227);
        MediumWallHorizontal mediumWallHorizontal = new MediumWallHorizontal();
        addObject(mediumWallHorizontal,223,482);
        mediumWallHorizontal.setLocation(242,472);
        MediumWall mediumWall2 = new MediumWall();
        addObject(mediumWall2,937,185);
        largeWall7.setLocation(572,413);
        mediumWall.setLocation(567,306);

        largeWall.getImage().setTransparency(0);
        largeWall2.getImage().setTransparency(0);
        largeWall3.getImage().setTransparency(0);
        largeWall4.getImage().setTransparency(0);
        largeWall5.getImage().setTransparency(0);
        largeWall6.getImage().setTransparency(0);
        largeWall7.getImage().setTransparency(0);
        mediumWall.getImage().setTransparency(0);
        mediumWall2.getImage().setTransparency(0);
        mediumWallHorizontal.getImage().setTransparency(0);
        largeWallHorizontal.getImage().setTransparency(0);
        largeWallHorizontal2.getImage().setTransparency(0);
        largeWallHorizontal3.getImage().setTransparency(0);
        largeWallHorizontal4.getImage().setTransparency(0);
        Enemy enemy = new Enemy();
        addObject(enemy,66,218);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,374,523);
        Enemy enemy3 = new Enemy();
        addObject(enemy3,487,71);
        Enemy enemy4 = new Enemy();
        addObject(enemy4,830,318);
        DoorWarp doorWarp = new DoorWarp();
        doorWarp.setRotation(90);
        addObject(doorWarp,756,590);
    }
}
