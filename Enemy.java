import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private boolean hadGun=false;
    private Gun gun;
    private int counterShotGunDeley=0; 
    
    public void act()
    {
        if(hadGun==false){
            generateGun();
        }
        identifyAnEnemy();
    }
    
    private void identifyAnEnemy(){
        List<Player> jugadores= getNeighbours(140,true,Player.class);
        for(Player jugador:jugadores){
            double dx = jugador.getX() - getX();  
            double dy = jugador.getY() - getY();  
            double angle = Math.atan2(dy,dx)*180.0/(Math.PI);
            setRotation((int)angle);
            shotEnemy(jugador);
        }
    }
    
    private void shotEnemy(Player jugador){
        if(counterShotGunDeley==0){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            gun.setRotation(getRotation());
            gun.shotByEnemy();
            counterShotGunDeley=100;
        }
        if(counterShotGunDeley>0){
            counterShotGunDeley--;
        }
        
    }
    
    private void generateGun(){
        gun= new Gun();
        getWorld().addObject(gun,getX(),getY());
        hadGun=true;
    }
    
}
