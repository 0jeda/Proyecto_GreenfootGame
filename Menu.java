import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

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
    private int counter = 60;
    private StartButton startButton = new StartButton();
    private ControlsButton controlsButton = new ControlsButton();
    private ScoresButton scoresButton = new ScoresButton();
    private EscButton escButton = new EscButton();
    private GreenfootSound menu_music;
    
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1080, 600, 1);
        prepareWorld();
        setBackground("images/HLMM_BG.png");
        menu_music = new GreenfootSound("sounds/menu.mp3");
        menu_music.play();
        menu_music.setVolume(30);
    }
    
    public void prepareWorld(){
        addObject(startButton, 850, 150);
        addObject(controlsButton, 850, 250);
        addObject(scoresButton, 850, 350);
        addObject(escButton, 850, 450);
        addObject(arrow, 690, 150);
    }
    
    public void act(){
        counter--;
        if(Greenfoot.isKeyDown("UP") && counter<=0/*&& option!=0*/){
            option--;
            counter=60;
        }
        if(Greenfoot.isKeyDown("DOWN") && counter<=0/*&& option!=4*/){
            option++;
            counter=60;
        }
        
        if(option>=4){option=3;}
        if(option<0){option=0;}
        
        arrow.setLocation(690, 150 + (option*100));
        
        if(Greenfoot.isKeyDown("ENTER")){
            switch(option){
                case 0:
                    startButton.setImage("images/iniciarSeleccionPA.png");
                    Greenfoot.delay(50);
                    menu_music.pause();
                    Greenfoot.setWorld(new Scenario1());
                    break;
                case 1:
                    controlsButton.setImage("images/comoJugarSeleccionPA.png");
                    menu_music.pause();
                    Greenfoot.delay(50);
                    Greenfoot.setWorld(new HowToPlay());
                    break;
                case 2:
                    scoresButton.setImage("images/puntuacionesSeleccionPA.png");
                    menu_music.pause();
                    Greenfoot.delay(50);
                    Greenfoot.setWorld(new Scores());
                case 3:
                    escButton.setImage("images/SalirSeleccionPA.png");
                    Greenfoot.delay(50);
                    Greenfoot.stop();
                    break;
            }
        }
    }
}
