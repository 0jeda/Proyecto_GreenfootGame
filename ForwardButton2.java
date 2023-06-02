import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForwardButton2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForwardButton2 extends Button
{
    /**
     * Act - do whatever the ForwardButton2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        gotClicked();
    }
    
    public void gotClicked()  
    {  
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new HowToPlay3());
        }
    }
}
