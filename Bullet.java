import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Item
{
    private String shooterType; 
    
    public Bullet(String shooterType) {
        this.shooterType = shooterType;
    }
    
    public void act()
    {
        if("Player"==shooterType){
            Enemy enemy=(Enemy)getOneIntersectingObject(Enemy.class);
            move(4);    
            if(getX()<=10 || getX()>=750 || getY()<=10 || getY()>=550 ){
                getWorld().removeObject(this);
            }
        }
        if("Enemy"==shooterType){
            Player player=(Player)getOneIntersectingObject(Player.class);
            move(4);    
            if(getX()<=10 || getX()>=750 || getY()<=10 || getY()>=550 ){
                getWorld().removeObject(this);
            }
        }
        getShooterType();
    }
    
    public String getShooterType(){
        return shooterType;
    }
}
