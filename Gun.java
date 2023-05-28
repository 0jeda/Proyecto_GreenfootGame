import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Item
{
    private int ammunition=10;
    
    public void act()
    {
    
    }
    
    public void shot(MouseInfo mouse){
        double dx = mouse.getX() - getX();  
        double dy = mouse.getY() - getY();  
        double angle = Math.atan2(dy,dx)*180.0/(Math.PI);
        
        int shots=mouse.getClickCount();
        if(0<shots && ammunition>0){
            Bullet bullet= new Bullet();
            getWorld().addObject(bullet,getX(),getY());
            bullet.setRotation((int)angle);
            ammunition--;
        }

    }
}
