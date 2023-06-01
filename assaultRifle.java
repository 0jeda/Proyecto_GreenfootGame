import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class assaultRifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class assaultRifle extends Gun
{
    assaultRifle(){
       ammunition=100;
       deleyOfGun=200;     
    }
    public void act()
    {
        rotation();
    }
    
    @Override
    public void shot(String shooterType) {
    if (ammunition > 0) {
        for (int i = 0; i < 3; i++) {
            Bullet bullet = new Bullet(shooterType);
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation());
            ammunition--;
            bullet.move(50-(i*20));
            Greenfoot.delay(10); // Pequeño retraso entre cada disparo (ajusta el valor según tus necesidades)
        }
    }
    }

}




