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
    private String typeOfWeapon;
    private Gun gun;
    private weaponMele mele;
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
        timeStunned=900;
        typeOfWeapon=null;
    }

    public void act()
    {
        if(!hadGun){
            generateGun();
        }
        //checkWalls();
        if(status.equals("Alive")){
            identifyAnEnemy();
            stillAlive();
        }else if(status.equals("Stunned")){
            if(timeStunned>0){
                timeStunned--;
                stillAlive();
                setImage("images/enemy_walk_6_PA.png");
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
            checkWalls();
            setRotation((int)angle);
            shotEnemy(jugador);
        }
    }

    private void shotEnemy(Player jugador){
        if(typeOfWeapon.equals("Gun")){
            if(counterShotGunDeley==0){
                MouseInfo mouse = Greenfoot.getMouseInfo();
                gun.setRotation(getRotation());
                gun.shot("Enemy");
                counterShotGunDeley=gun.getDeleyOfGun();
            }
            if(counterShotGunDeley>0){
                counterShotGunDeley--;
            }
        }else if(typeOfWeapon.equals("Mele")){
            mele.setLocation(getX(),getY());
            move(1);
            hitEnemy();
        }

    }

    private void generateGun(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(4); 
        if (randomNumber == 0) {
            gun = new shotGun();
            typeOfWeapon="Gun";
            radius=250; 
        } else if (randomNumber == 1) {
            gun = new simpleGun();
            typeOfWeapon="Gun";
            radius=300;
        } else if (randomNumber == 2) {
            gun = new assaultRifle();
            typeOfWeapon="Gun";
            radius=450;
        }else{
            mele = new weaponMele();
            typeOfWeapon="Mele";
            radius=900;
        }
        if(typeOfWeapon.equals("Gun")){
            getWorld().addObject(gun,getX(),getY());
            hadGun=true;
        }else if(typeOfWeapon.equals("Mele")){
            getWorld().addObject(mele,getX(),getY());
            hadGun=true;
        }
    }

    private void stillAlive(){
        Bullet bullet=(Bullet)getOneIntersectingObject(Bullet.class);
        if(status.equals("Alive") && bullet!=null){
            String shooter = bullet.getShooterType();
            if (shooter != null && shooter.equals("Player")) {
                Player player = (Player)getWorld().getObjects(Player.class).get(0);
                player.increaseScore(100);
                setImage("images/enemy_dead_PA.png");
            }
        } else if(status.equals("Stunned") && timeStunned==0){
            Player player = (Player)getWorld().getObjects(Player.class).get(0);
            player.increaseScore(50);
        }
    }

    public void setStatus(String status){
        this.status=status;
    }

    public String getStatus(){
        return status;
    }

    public void hitEnemy(){

        setImage("images/enemy_melee_PA.png");
        if(typeOfWeapon.equals("Hand")){
            List<Player> jugadores= getNeighbours(110,true,Player.class);
            for(Player jugador:jugadores){
                jugador.setStatus("Stunned");
            }
        }else if(typeOfWeapon.equals("Mele")){
            List<Player> jugadores= getNeighbours(110,true,Player.class);
            for(Player jugador:jugadores){
                jugador.setStatus("Dead");
                setImage("images/enemy_bonk_PA.png");
            }
        }

    }
    
    public void checkWalls(){
        Wall wall = (Wall)getOneIntersectingObject(Wall.class);
        if(wall!=null){
            move(-1);
        }
    }
}
