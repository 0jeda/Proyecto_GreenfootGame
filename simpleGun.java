import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class simpleGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class simpleGun extends Gun
{
    simpleGun(){
       ammunition=15;
       deleyOfGun=100;     
    }
    
    public void act()
    {
        if(flag && distance>0){
            move(4);
            distance-=2;
            impactWithEnemy();
        }else{
            rotation();
            flag=false;
        }
          
    }
    
    @Override
    public void shot(String shooterType){
        
        if(ammunition>0){
            
            Bullet bullet= new Bullet(shooterType);
            getWorld().addObject(bullet,getX(),getY());
            bullet.setRotation(getRotation());
            ammunition--;
            
            shotSound = new GreenfootSound("sounds/simpleShot.mp3");
            shotSound.play();
            shotSound.setVolume(50);
        }
    }
    
    public void lanza(boolean flag){
        this.flag=flag;
        distance=200;
    }
}
