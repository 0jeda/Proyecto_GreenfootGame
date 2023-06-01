import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
    protected GreenfootSound shotSound;
    protected String path;
    
    public void act()
    {
        rotation();
    }
    
    public void shot(String shooterType){
        
        if(ammunition>0){
            
            Bullet bullet= new Bullet(shooterType);
            getWorld().addObject(bullet,getX(),getY());
            bullet.setRotation(getRotation());
            ammunition--;
        }

    }
    
    public int getDeleyOfGun(){
        return deleyOfGun;
    }
    
    public void rotation(){
        List<Player> jugadores= getNeighbours(50,true,Player.class);
        for(Player jugador:jugadores){
            double dx = jugador.getX() - getX();  
            double dy = jugador.getY() - getY();  
            double angle = Math.atan2(dy,dx)*180.0/(Math.PI);
            setRotation((int)angle);
    }
    }
    
}
