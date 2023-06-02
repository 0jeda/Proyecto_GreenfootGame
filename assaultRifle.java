import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class assaultRifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AssaultRifle extends Gun
{
    private boolean flag1;
    private String shooterType;
    private int deleyOfGun;
    private int numberOfShot;
    private int delayBetweenShots;

    AssaultRifle(){
        ammunition=90;   
        deleyOfGun=150;
        flag=false;
        numberOfShot=3;
        shooterType=null;
        delayBetweenShots = 0; 
    }

    public void act()
    {
        if(numberOfShot > 0 && flag1 && delayBetweenShots == 0 && ammunition>0){
            generateBullet();
            numberOfShot--;
            delayBetweenShots = 10; 
        }
        if(delayBetweenShots > 0){
            delayBetweenShots--; 
        }
        if(flag && distance>0){
            move(3);
            distance-=2;
            impactWithEnemy();
        }else{
            rotation();
            flag=false;
        }
    }

    @Override
    public void shot(String shooterType) {
        flag1 = true;
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

    public void lanza(boolean flag){
        this.flag=flag;
        distance=300;
    }

}


