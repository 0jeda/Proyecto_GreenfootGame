import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario4 extends World
{

    /**
     * Constructor for objects of class Scenario4.
     * 
     */
    public Scenario4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1);
        prepare();
    }
    
    public void prepare(){
        addObject(new LargeWallHorizontal(), 965, 465);
        addObject(new LargeWallHorizontal(), 731, 465);
        addObject(new LargeWallHorizontal(), 497, 465);
        addObject(new LargeWallHorizontal(), 265, 465);
        addObject(new LargeWallHorizontal(), 115, 302);
        addObject(new LargeWallHorizontal(), 348, 302);
        addObject(new LargeWallHorizontal(), 581, 302);
        addObject(new LargeWallHorizontal(), 813, 302);
        addObject(new MediumWall(), 911, 225);
        addObject(new SmallWall(), 536, 255);
        addObject(new MediumWall(), 540, 54);
        addObject(new Enemy(), 61, 423);
        addObject(new Enemy(), 1007, 90);
        addObject(new Enemy(), 425, 65);
        addObject(new Enemy(), 72, 226);
        DoorWarp doorWarp = new DoorWarp();
        doorWarp.setRotation(270);
        addObject(doorWarp,174,10);
        simpleGun simpleGun = new simpleGun();
        addObject(simpleGun,802,544);
    }
}
