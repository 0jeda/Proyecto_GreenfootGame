import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shotGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shotGun extends Gun
{
    shotGun(){
        ammunition=35;
        deleyOfGun=500;
    }
    
    public void act()
    {
        rotation();
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
    }
}

    
}
