import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        move();
        rotation(mouse);
    }
    
    public void move(){
        if(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a")){
            if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")){
                setLocation(getX() - 1, getY() - 1);
            }else if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
                setLocation(getX() - 1, getY() + 1);
            }else{
                setLocation(getX() - 1, getY());
            }
        }else if(Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d")){
            if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")){
                setLocation(getX() + 1, getY() - 1);
            }else if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
                setLocation(getX() + 1, getY() + 1);
            }else{
                setLocation(getX() + 1, getY());
            }
        }else if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")){
            setLocation(getX() , getY() - 1);
        }else if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 1);
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
}
