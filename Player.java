import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private boolean holdingGun;
    private Gun currentGun;
    private weaponMele currentMele;
    private int OFFSET;
    private int numOfEscenario;
    private int score;
    private int currentEscenario;
    private String escenarioName;
    private int nameDeley;

    Player(){
        holdingGun=false;
        OFFSET=2;
        numOfEscenario=1;
        score=0;
        currentEscenario=1;
        escenarioName="hola";
        nameDeley=300;
    }

    public void act()
    {
        setImage("images/player_walk_1_PA.png");

        MouseInfo mouse = Greenfoot.getMouseInfo();
        move();
        takeGun();   

        if(holdingGun){
            shotGun(mouse);            
        }else{
            hitEnemy(mouse);
        }
        rotation(mouse);
        changeEscenario();
        showScore();

        if(nameDeley>0){
            World world = getWorld();
            world.showText(escenarioName, 500,50);
            nameDeley--;
        }else{
            World world = getWorld();
            world.showText(" ", 500,50);
        }
    }

    public void move(){
        int offsetX=0;
        int offsetY=0;

        if(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a")){
            offsetX=-OFFSET;
        }
        if(Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d")){
            offsetX=OFFSET;
        }
        if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")){
            offsetY=-OFFSET;
        }
        if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
            offsetY=OFFSET;
        }
        setLocation(getX()+offsetX,getY()+offsetY);
    }

    public void rotation(MouseInfo mouse){
        if(mouse!=null){
            double dx = mouse.getX() - getX();  
            double dy = mouse.getY() - getY();  
            double angle = Math.atan2(dy,dx)*180.0/(Math.PI);
            setRotation((int)angle);
        }
    }

    public void takeGun() {
        Gun gun = (Gun) getOneIntersectingObject(Gun.class);
        if (gun != null) {
            if (!holdingGun && Greenfoot.isKeyDown("space") && currentMele==null) {
                holdingGun = true;
                currentGun = gun; 
            }
        }
        if (holdingGun && currentGun!=null) {
            currentGun.setLocation(getX(), getY());
            if (Greenfoot.isKeyDown("k")) {
                holdingGun = false;
                currentGun = null; 
            }
        }

        weaponMele mele = (weaponMele) getOneIntersectingObject(weaponMele.class);
        if (mele != null) {
            if (!holdingGun && Greenfoot.isKeyDown("space")) {
                currentMele = mele; 
            }
        }
        if (currentMele!=null) {
            currentMele.setLocation(getX(), getY());
            if (Greenfoot.isKeyDown("k")) {
                currentMele = null; 
            }
        }
    }

    public void shotGun(MouseInfo mouse){
        if(mouse!=null && currentGun!=null){
            currentGun.setRotation((int)getRotation());
            int shots=mouse.getClickCount();
            if(0<shots){
                currentGun.shot("Player");
            }
        }
    }

    public void changeEscenario(){
        DoorWarp exit=(DoorWarp)getOneIntersectingObject(DoorWarp.class);

        if(exit!=null){
            currentEscenario++; 
            World newEscenario=null;
            switch (currentEscenario) {
                case 2:
                    newEscenario = new pruebas2();
                    escenarioName = "cocina";
                    break;
                    /*case 3:
                    newEscenario = new pruebas3();
                    break;*/

                default:
                    newEscenario = new Scores();
                    break;
            }

            Greenfoot.setWorld(newEscenario);
            newEscenario.addObject(this, 50, 200);
            if(currentGun!=null){
                newEscenario.addObject(this.currentGun, 50, 200);
            }
            nameDeley=300;
        }

    }

    public void increaseScore() {
        score+=50;
    }

    public void showScore(){
        World world = getWorld();
        world.showText("Score: "+score, 200,50);
    }

    public void hitEnemy(MouseInfo mouse){
        if(mouse!=null){
            int hits=mouse.getClickCount();
            if(0<hits){
                //setImage(golpeDerecho);
                //setImage(golpeIzquierdo):
                if(currentMele==null){
                    List<Enemy> enemigos= getNeighbours(110,true,Enemy.class);
                    for(Enemy enemigo:enemigos){
                        enemigo.setStatus("Stunned");
                    }
                }else if(currentMele!=null){
                    List<Enemy> enemigos= getNeighbours(150,true,Enemy.class);
                    for(Enemy enemigo:enemigos){
                        enemigo.setStatus("Dead");
                    }
                }
            }
        }
    }


}
