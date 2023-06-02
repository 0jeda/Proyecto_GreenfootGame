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
        //battleMusic.play();
        battleMusic.setVolume(30);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new shotGun(),122,285);
        addObject(new Enemy(), 680, 108);
        addObject(new Enemy(), 442, 96);
        addObject(new Enemy(), 908, 521);
        addObject(new Player(), 111, 478);
        addObject(new DoorWarp(), 1070, 493);
        addObject(new LargeWallHorizontal(), 114, 361);
        addObject(new MediumWallHorizontal(), 254, 361);
        addObject(new SmallWall(), 297, 406);
        addObject(new SmallWall(), 297, 569);
        addObject(new LargeWall(), 586, 118);
        addObject(new LargeWallHorizontal(), 722, 216);
        addObject(new MediumWallHorizontal(), 896, 216);
        addObject(new LargeWall(), 669, 483);
    }
}
