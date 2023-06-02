import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario8 extends World
{

    /**
     * Constructor for objects of class Scenario8.
     * 
     */
    public Scenario8()
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
        addObject(largeWall,215,129);
        LargeWall largeWall2 = new LargeWall();
        addObject(largeWall2,435,418);
        largeWall.setLocation(221,234);
        LargeWall largeWall3 = new LargeWall();
        addObject(largeWall3,652,184);
        LargeWall largeWall4 = new LargeWall();
        addObject(largeWall4,869,410);
        SmallWall smallWall = new SmallWall();
        addObject(smallWall,216,28);
        SmallWall smallWall2 = new SmallWall();
        addObject(smallWall2,437,564);
        SmallWall smallWall3 = new SmallWall();
        addObject(smallWall3,651,38);
        SmallWall smallWall4 = new SmallWall();
        addObject(smallWall4,870,557);
        largeWall.setLocation(221,119);
        largeWall.setLocation(216,182);
        largeWall.getImage().setTransparency(0);
        largeWall2.getImage().setTransparency(0);
        largeWall3.getImage().setTransparency(0);
        largeWall4.getImage().setTransparency(0);
        smallWall.getImage().setTransparency(0);
        smallWall2.getImage().setTransparency(0);
        smallWall3.getImage().setTransparency(0);
        smallWall4.getImage().setTransparency(0);
        DoorWarp doorWarp = new DoorWarp();
        addObject(doorWarp,1065,333);
        Enemy enemy = new Enemy();
        addObject(enemy,94,151);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,434,138);
        Enemy enemy3 = new Enemy();
        addObject(enemy3,663,499);
        Enemy enemy4 = new Enemy();
        addObject(enemy4,873,164);
        shotGun shotGun = new shotGun();
        addObject(shotGun,158,495);
        shotGun.setLocation(206,479);
    }
}
