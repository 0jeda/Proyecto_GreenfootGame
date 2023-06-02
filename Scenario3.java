import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario3 extends World
{

    /**
     * Constructor for objects of class Scenario3.
     * 
     */
    public Scenario3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1);
        prepare();
    }
    
    private void prepare(){
        addObject(new LargeWallHorizontal(), 116, 454);
        addObject(new MediumWall(), 214, 378);
        addObject(new MediumWallHorizontal(), 378, 303);
        addObject(new LargeWallHorizontal(), 432, 303);
        addObject(new MediumWallHorizontal(), 607, 303);
        addObject(new LargeWall(), 685, 204);
        addObject(new MediumWall(), 214, 378);
        addObject(new LargeWallHorizontal(), 509, 463);
        addObject(new LargeWallHorizontal(), 743, 463);
        addObject(new SmallWallHorizontal(), 889, 463);
        addObject(new LargeWall(), 900, 325);
        addObject(new MediumWallHorizontal(), 255, 304);
        addObject(new MediumWall(), 410, 539);
        addObject(new Enemy(), 58, 69);
        addObject(new Enemy(), 594, 206);
        addObject(new Enemy(), 789, 162);
        addObject(new Enemy(), 299, 502);
        addObject(new AssaultRifle(), 102, 364);
        DoorWarp doorWarp = new DoorWarp();
        doorWarp.setRotation(180);
        addObject(doorWarp,3,540);
    }
}
