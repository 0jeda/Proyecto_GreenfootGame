import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scenario5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scenario5 extends World
{

    /**
     * Constructor for objects of class Scenario5.
     * 
     */
    public Scenario5()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1); 
        prepare();
    }
    
    public void prepare(){
        LargeWall largeWall_1 = new LargeWall();
        LargeWall largeWall_2 = new LargeWall();
        MediumWall mediumWall_1 = new MediumWall();
        MediumWall mediumWall_2 = new MediumWall();
        SmallWallHorizontal smallWall_1 = new SmallWallHorizontal();
        SmallWallHorizontal smallWall_2 = new SmallWallHorizontal();
        largeWall_1.getImage().setTransparency(0);
        largeWall_2.getImage().setTransparency(0);
        mediumWall_1.getImage().setTransparency(0);
        mediumWall_2.getImage().setTransparency(0);
        smallWall_1.getImage().setTransparency(0);
        smallWall_2.getImage().setTransparency(0);

        LargeWall largeWall_3 = new LargeWall();
        LargeWall largeWall_4 = new LargeWall();
        LargeWall largeWall_5 = new LargeWall();
        LargeWall largeWall_6 = new LargeWall();
        SmallWallHorizontal smallWall_3 = new SmallWallHorizontal();
        largeWall_3.getImage().setTransparency(0);
        largeWall_4.getImage().setTransparency(0);
        largeWall_5.getImage().setTransparency(0);
        largeWall_6.getImage().setTransparency(0);
        smallWall_3.getImage().setTransparency(0);

        LargeWall largeWall_7 = new LargeWall();
        LargeWall largeWall_8 = new LargeWall();
        LargeWall largeWall_9 = new LargeWall();
        LargeWall largeWall_10 = new LargeWall();
        SmallWallHorizontal smallWall_4 = new SmallWallHorizontal();
        largeWall_7.getImage().setTransparency(0);
        largeWall_8.getImage().setTransparency(0);
        largeWall_9.getImage().setTransparency(0);
        largeWall_10.getImage().setTransparency(0);
        smallWall_4.getImage().setTransparency(0);

        addObject(largeWall_1, 197, 243);
        addObject(largeWall_2, 275, 243);
        addObject(mediumWall_1, 197, 414);
        addObject(mediumWall_2, 276, 414);
        addObject(smallWall_1, 231, 143);
        addObject(smallWall_2, 235, 455);

        addObject(largeWall_3, 498, 243);
        addObject(largeWall_4, 498, 479);
        addObject(largeWall_5, 574, 243);
        addObject(largeWall_6, 574, 479);
        addObject(smallWall_3, 532, 143);

        addObject(largeWall_7, 796, 117);
        addObject(largeWall_8, 797, 353);
        addObject(largeWall_9, 874, 117);
        addObject(largeWall_10, 874, 353);
        addObject(smallWall_4, 837, 451);
        Enemy enemy = new Enemy();
        addObject(enemy,95,78);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,417,534);
        Enemy enemy3 = new Enemy();
        addObject(enemy3,740,551);
        shotGun shotGun = new shotGun();
        addObject(shotGun,115,560);
        Enemy enemy4 = new Enemy();
        addObject(enemy4,413,77);
        enemy2.setLocation(394,420);
        shotGun.setLocation(197,567);
        DoorWarp doorWarp = new DoorWarp();
        addObject(doorWarp,1063,58);
        doorWarp.setLocation(1069,58);
    }
}
