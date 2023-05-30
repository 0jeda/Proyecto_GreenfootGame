import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Item
{
    protected int ammunition;
    protected int deleyOfGun;

    
    public void act()
    {
    
    }
    
    public void shot(String shooterType){
        
        if(ammunition>0){
            
            Bullet bullet= new Bullet(shooterType);
            getWorld().addObject(bullet,getX(),getY());
            bullet.setRotation(getRotation());
            ammunition--;
        }

    }
    
}
