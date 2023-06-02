import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shotGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShotGun extends Gun
{
    ShotGun(){
        ammunition=36;
        deleyOfGun=500;
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
    public void shot(String shooterType) {
        if (ammunition > 0) {
            // Disparo central
            Bullet bullet = new Bullet(shooterType);
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation());
            ammunition--;

            // Disparo hacia la izquierda
            Bullet bulletLeft = new Bullet(shooterType);
            getWorld().addObject(bulletLeft, getX() - 10, getY());
            bulletLeft.setRotation(getRotation() - 10);
            ammunition--;

            // Disparo hacia la derecha
            Bullet bulletRight = new Bullet(shooterType);
            getWorld().addObject(bulletRight, getX() + 10, getY());
            bulletRight.setRotation(getRotation() + 10);
            ammunition--;

            shotSound = new GreenfootSound("sounds/shotgunShot.mp3");
            shotSound.play();
            shotSound.setVolume(50);
        }
    }

    public void lanza(boolean flag){
        this.flag=flag;
        distance=250;
    }

}
