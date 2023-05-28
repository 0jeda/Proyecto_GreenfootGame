import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private boolean holdingGun;
    private int offSet=2;

    public void act()
    {
        setImage("images/survivor-idle_rifle_0.png");
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        move();
        takeGun();
        shotGun(mouse);
        rotation(mouse);
    }
    
    public void move(){
        if(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a")){
            if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")){
                setLocation(getX() - offSet, getY() - offSet);
            }else if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
                setLocation(getX() - offSet, getY() + offSet);
            }else{
                setLocation(getX() - offSet, getY());
            }
        }else if(Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d")){
            if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")){
                setLocation(getX() + offSet, getY() - offSet);
            }else if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
                setLocation(getX() + offSet, getY() + offSet);
            }else{
                setLocation(getX() + offSet, getY());
            }
        }else if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")){
            setLocation(getX() , getY() - offSet);
        }else if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + offSet);
        }
    }
    
    public void rotation(MouseInfo mouse){
        if(mouse!=null){
            double dx = mouse.getX() - getX();  
            double dy = mouse.getY() - getY();  
            double angle = Math.atan2(dy,dx)*180.0/(Math.PI);
            if(getX()<mouse.getX()){
                if(getY() < mouse.getY()){
                    setRotation((int)angle);
                }else if(getY()>mouse.getY()){
                    setRotation((int)angle);
                }
            }else if(getX()>mouse.getX()){
                if(getY()<mouse.getY()){
                    setRotation((int)angle);
                }else if(getY()>mouse.getY()){
                    setRotation((int)angle);
                }
            }
        }
    }
    
    public void takeGun(){
        Gun gun=(Gun)getOneIntersectingObject(Gun.class);
        if(gun!=null){
            if(Greenfoot.isKeyDown("space")){
                holdingGun=true;
            }
        }
        if(holdingGun==true){   
            gun.setLocation(getX(),getY());
            if(Greenfoot.isKeyDown("k") ){
                holdingGun=false;
            }
        }
    }
    
    public void shotGun(MouseInfo mouse){
        if(mouse!=null){
            Gun gun=(Gun)getOneIntersectingObject(Gun.class);
            if(gun!=null){
                int shots=mouse.getClickCount();
                if(0<shots){
                    gun.shot(mouse);
                }
            }
        }
    }
    
    
}
