import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario9 extends World
{

    /**
     * Constructor for objects of class Scenario9.
     * 
     */
    public Scenario9()
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
        addObject(largeWall,217,272);
        LargeWall largeWall2 = new LargeWall();
        addObject(largeWall2,434,268);
        LargeWall largeWall3 = new LargeWall();
        addObject(largeWall3,652,263);
        LargeWall largeWall4 = new LargeWall();
        addObject(largeWall4,867,271);
        SmallWall smallWall = new SmallWall();
        addObject(smallWall,217,418);
        SmallWall smallWall2 = new SmallWall();
        addObject(smallWall2,434,422);
        SmallWall smallWall3 = new SmallWall();
        addObject(smallWall3,652,413);
        SmallWall smallWall4 = new SmallWall();
        addObject(smallWall4,868,422);
        largeWall.getImage().setTransparency(0);
        largeWall2.getImage().setTransparency(0);
        largeWall3.getImage().setTransparency(0);
        largeWall4.getImage().setTransparency(0);
        smallWall.getImage().setTransparency(0);
        smallWall2.getImage().setTransparency(0);
        smallWall3.getImage().setTransparency(0);
        smallWall4.getImage().setTransparency(0);
        DoorWarp doorWarp = new DoorWarp();
        addObject(doorWarp,1068,202);
        Enemy enemy = new Enemy();
        addObject(enemy,160,90);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,329,414);
        Enemy enemy3 = new Enemy();
        addObject(enemy3,543,133);
        Enemy enemy4 = new Enemy();
        addObject(enemy4,779,424);
        Enemy enemy5 = new Enemy();
        addObject(enemy5,939,93);
        enemy5.setLocation(772,77);
    }
}
