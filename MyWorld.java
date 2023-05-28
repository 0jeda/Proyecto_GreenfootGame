import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public ImgScroll scroller;
    private Player player;

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        scroller = new ImgScroll(this, new GreenfootImage("images/bg_prueba.png"), 1200, 1766);
        setBackground("images/bg_prueba.png");
        player = new Player();
        addObject(player, 300, 200);
        prepare();
    }

    public void act()
    {
        scroller.scroll(getWidth()/2-player.getX(), getHeight()/2-player.getY());    
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Gun gun = new Gun();
        addObject(gun,573,205);
        Enemy enemy = new Enemy();
        addObject(enemy,581,518);
    }
}
