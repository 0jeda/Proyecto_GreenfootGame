import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario2 extends World
{

    /**
     * Constructor for objects of class Scenario2.
     * 
     */
    public Scenario2()
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
        addObject(new Enemy(),111,293);
        addObject(new Enemy(),46,57);
        //addObject(new Player(),27,493);
        addObject(new SimpleGun(),39,331);
        addObject(new SmallWall(),214,136);
        addObject(new LargeWall(),215,263);
        addObject(new LargeWallHorizontal(),117,399);
        addObject(new SmallWall(),215,320);
        addObject(new SmallWall(),215,445);
        DoorWarp doorWarp = new DoorWarp();
        doorWarp.setRotation(270);
        addObject(doorWarp,525,10);
        addObject(new LargeWall(),398,123);
        addObject(new LargeWall(),400,243);
        addObject(new SmallWall(),374,575);
        addObject(new LargeWallHorizontal(),507,176);
        addObject(new LargeWallHorizontal(),742,176);
        addObject(new LargeWall(),605,313);
        addObject(new SmallWall(),604,433);
        addObject(new MediumWallHorizontal(),879,176);
        addObject(new MediumWall(),953,444);
        addObject(new Enemy(),488,301);
        addObject(new Enemy(),1033,226);
        addObject(new ShotGun(),1043,515);
    }
}
