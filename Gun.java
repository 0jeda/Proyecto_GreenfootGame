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
    private int deleyOfGun;

    
    public void act()
    {
    
    }
    
    public void shot(MouseInfo mouse){
        
        int shots=mouse.getClickCount();
        if(0<shots && ammunition>0){
            Bullet bullet= new Bullet();
            getWorld().addObject(bullet,getX(),getY());
            bullet.setRotation(getRotation());
            ammunition--;
        }

    }
    
    public void shotByEnemy(){
        
        if(ammunition>0){
            Bullet bullet= new Bullet();
            getWorld().addObject(bullet,getX(),getY());
            bullet.setRotation(getRotation());
            ammunition--;
        }

    }
}
