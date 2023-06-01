import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class assaultRifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class assaultRifle extends Gun
{
    private boolean flag;
    private String shooterType;
    private int deleyOfGun;
    private int numberOfShot;
    private int delayBetweenShots;

    assaultRifle(){
        ammunition=100;   
        deleyOfGun=150;
        flag=false;
        numberOfShot=3;
        shooterType=null;
        delayBetweenShots = 0; 
    }

    public void act()
    {
        if(numberOfShot > 0 && flag && delayBetweenShots == 0){
            generateBullet();
            numberOfShot--;
            delayBetweenShots = 10; 
        }
        rotation();
        if(delayBetweenShots > 0){
            delayBetweenShots--; 
        }
    }

    @Override
    public void shot(String shooterType) {
        flag = true;
        this.shooterType = shooterType;
        numberOfShot = 3;
        delayBetweenShots = 10; 
    }

    private void generateBullet(){
        shotSound = new GreenfootSound("sounds/assaultShot.mp3");
        shotSound.play();
        shotSound.setVolume(50);
        Bullet bullet = new Bullet(this.shooterType);
        getWorld().addObject(bullet, getX(), getY());
        bullet.setRotation(getRotation());
        ammunition--;
    }
    

}



