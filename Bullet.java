import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Item
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Enemy enemy=(Enemy)getOneIntersectingObject(Enemy.class);
        move(4);    
        if(getX()<=10 || getX()>=750 || getY()<=10 || getY()>=550 ){
            getWorld().removeObject(this);
        }
    }
}
