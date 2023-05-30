import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    SelectionArrow arrow = new SelectionArrow();
    private int option=0;
    
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1);
        prepareWorld();
        setBackground("menu_bg.jpg");
    }
    
    public void prepareWorld(){
        addObject(new StartButton(), 400, 250);
        addObject(new EscButton(), 400, 350);
        addObject(arrow, 275, 250);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("UP") && option!=0){option++;}
        if(Greenfoot.isKeyDown("DOWN") && option!=1){option--;}
        
        if(option>=2){option=0;}
        if(option<0){option=1;}
        
        arrow.setLocation(275, 250 + (option*100));
        
        if(Greenfoot.isKeyDown("ENTER")){
            switch(option){
                case 0:
                    Greenfoot.setWorld(new MyWorld());
                    break;
                case 1:
                    Greenfoot.stop();
                    break;
            }
        }
    }
}
