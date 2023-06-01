import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private boolean hadGun;
    private Gun gun;
    private int counterShotGunDeley; 
    private boolean life;
    private int radius;
    private int timeStunned;
    private String status;
    
    Enemy(){
        hadGun=false;
        counterShotGunDeley=0;
        radius=0;
        status="Alive";
        timeStunned=600;
    }
    
    public void act()
    {
        if(!hadGun){
            generateGun();
        }
            
        if(status.equals("Alive")){
            identifyAnEnemy();
            stillAlive();
        }else if(status.equals("Stunned")){
            if(timeStunned>0){
                timeStunned--;
                stillAlive();
                //setImage(aturdido);
            }else{
                status="Alive";
                timeStunned=900;
            }
        }else if(status.equals("Dead")){
            //No hace nada
        }
    }
    
    private void identifyAnEnemy(){
        List<Player> jugadores= getNeighbours(radius,true,Player.class);
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
            gun.shot("Enemy");
            counterShotGunDeley=gun.getDeleyOfGun();;
        }
        if(counterShotGunDeley>0){
            counterShotGunDeley--;
        }
        
    }
    
    private void generateGun(){
        
        Random rand = new Random();
        int randomNumber = rand.nextInt(3); 
        if (randomNumber == 0) {
            gun = new shotGun();
            radius=250; 
        } else if (randomNumber == 1) {
            gun = new simpleGun();
            radius=300;
        } else {
            gun = new assaultRifle();
            radius=450;
        }
        getWorld().addObject(gun,getX(),getY());
        hadGun=true;
    }
    
    private void stillAlive(){
        Bullet bullet=(Bullet)getOneIntersectingObject(Bullet.class);
        if(status.equals("Alive") && bullet!=null){
            String shooter = bullet.getShooterType();
            if (shooter != null && shooter.equals("Player")) {
                Player player = (Player)getWorld().getObjects(Player.class).get(0);
                player.increaseScore();
                setImage("images/enemy_dead_PA.png");
            }
        } 
    }
    
    public void setStatus(String status){
        this.status=status;
    }
    
    public String getStatus(){
        return status;
    }
    
}
