import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Item
{
    public int ammunition=10;
    
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        int shots=mouse.getClickCount();
        if(0<shots && ammunition>0){
            shot(mouse);
        }
    }
    
    public void shot(MouseInfo mouse){
        double x=mouse.getX();
        double y=mouse.getY();
        
        Bullet bullet= new Bullet();
        bullet.setLocation(getX(),getY());
        
    }
}
