import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForwardButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForwardButton extends Button
{
    /**
     * Act - do whatever the ForwardButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        gotClicked();
    }
    
    public void gotClicked()  
    {  
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new HowToPlay2());
        }
    }
}
