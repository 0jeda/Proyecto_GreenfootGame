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
        checkWalls();
        if(shooterType.equals("Player")){
            Enemy enemy=(Enemy)getOneIntersectingObject(Enemy.class);
            move(4);    
            if(getX()<=10 || getX()>=1070 || getY()<=10 || getY()>=590){
                getWorld().removeObject(this);
            }
            if(enemy!=null && enemy.getStatus().equals("Alive")){
                getWorld().removeObject(this);
                enemy.setStatus("Dead");
            }
        }
        if(shooterType.equals("Enemy")){
            Player player=(Player)getOneIntersectingObject(Player.class);
            move(4);    
            if(getX()<=10 || getX()>=1070 || getY()<=10 || getY()>=590){
                getWorld().removeObject(this);
            }
            if(player!=null && player.getStatus().equals("Alive")){
                getWorld().removeObject(this);
                player.setStatus("Dead");
            }
        }
        getShooterType();
    }
    
    public String getShooterType(){
        return shooterType;
    }
    
    public void checkWalls(){
        Wall wall = (Wall)getOneIntersectingObject(Wall.class);
        if(wall!=null){
            setLocation(0, 0);
        }
    }
}
