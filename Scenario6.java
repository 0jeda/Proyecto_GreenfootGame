import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario6 extends World
{

    /**
     * Constructor for objects of class Scenario6.
     * 
     */
    public Scenario6()
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
        LargeWallHorizontal largeWallHorizontal = new LargeWallHorizontal();
        addObject(largeWallHorizontal,116,162);
        LargeWallHorizontal largeWallHorizontal2 = new LargeWallHorizontal();
        addObject(largeWallHorizontal2,352,161);
        LargeWallHorizontal largeWallHorizontal3 = new LargeWallHorizontal();
        addObject(largeWallHorizontal3,119,232);
        LargeWallHorizontal largeWallHorizontal4 = new LargeWallHorizontal();
        addObject(largeWallHorizontal4,360,228);
        SmallWall smallWall = new SmallWall();
        addObject(smallWall,488,191);
        LargeWallHorizontal largeWallHorizontal5 = new LargeWallHorizontal();
        addObject(largeWallHorizontal5,254,391);
        MediumWallHorizontal mediumWallHorizontal = new MediumWallHorizontal();
        addObject(mediumWallHorizontal,435,391);
        LargeWallHorizontal largeWallHorizontal6 = new LargeWallHorizontal();
        addObject(largeWallHorizontal6,254,458);
        MediumWallHorizontal mediumWallHorizontal2 = new MediumWallHorizontal();
        addObject(mediumWallHorizontal2,440,455);
        SmallWall smallWall2 = new SmallWall();
        addObject(smallWall2,489,422);
        SmallWall smallWall3 = new SmallWall();
        addObject(smallWall3,155,424);
        LargeWall largeWall = new LargeWall();
        addObject(largeWall,797,115);
        LargeWall largeWall2 = new LargeWall();
        addObject(largeWall2,796,349);
        LargeWall largeWall3 = new LargeWall();
        addObject(largeWall3,872,119);
        LargeWall largeWall4 = new LargeWall();
        addObject(largeWall4,873,350);
        MediumWallHorizontal mediumWallHorizontal3 = new MediumWallHorizontal();
        addObject(mediumWallHorizontal3,834,455);

        largeWallHorizontal.getImage().setTransparency(0);
        largeWallHorizontal2.getImage().setTransparency(0);
        largeWallHorizontal3.getImage().setTransparency(0);
        largeWallHorizontal4.getImage().setTransparency(0);
        smallWall.getImage().setTransparency(0);
        largeWallHorizontal5.getImage().setTransparency(0);
        largeWallHorizontal6.getImage().setTransparency(0);
        mediumWallHorizontal.getImage().setTransparency(0);
        mediumWallHorizontal2.getImage().setTransparency(0);
        mediumWallHorizontal3.getImage().setTransparency(0);
        smallWall.getImage().setTransparency(0);
        smallWall2.getImage().setTransparency(0);
        smallWall3.getImage().setTransparency(0);
        largeWall.getImage().setTransparency(0);
        largeWall2.getImage().setTransparency(0);
        largeWall3.getImage().setTransparency(0);
        largeWall4.getImage().setTransparency(0);
        Enemy enemy = new Enemy();
        addObject(enemy,654,66);
        enemy.setLocation(665,96);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,73,328);
        enemy2.setLocation(56,376);
        Enemy enemy3 = new Enemy();
        addObject(enemy3,460,543);
        Enemy enemy4 = new Enemy();
        addObject(enemy4,801,539);
        simpleGun simpleGun = new simpleGun();
        addObject(simpleGun,169,76);
        DoorWarp doorWarp = new DoorWarp();
        addObject(doorWarp,1065,83);
        doorWarp.setLocation(1068,82);
    }
}
