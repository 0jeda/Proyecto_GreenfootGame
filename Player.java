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
    private WeaponMele currentMele;
    private int OFFSET;
    private int numOfEscenario;
    private int score;
    private int currentEscenario;
    private String escenarioName;
    private int nameDeley;
    private String []images;
    private int playerDeley=30;
    private int playerImageIndex;
    private int ammunition;
    private String status;
    private int timeStunned;
    private String playerName="";
    private Highscores highscores = new Highscores();

    public Player(){
        timeStunned=900;
        status="Alive";
        holdingGun=false;
        ammunition=0;
        OFFSET=2;
        numOfEscenario=1;
        score=0;
        currentEscenario=1;
        escenarioName="Nivel 1 Sala 1";
        nameDeley=300;
        images = new String[7];
        images[0] = "images/player_walk_1_PA.png";
        images[1] = "images/player_walk_2_PA.png";
        images[2] = "images/player_walk_3_PA.png";
        images[3] = "images/player_walk_4_PA.png";
        images[4] = "images/player_walk_5_PA.png";
        images[5] = "images/player_walk_6_PA.png";
        images[6] = "images/player_walk_7_PA.png";
    }

    public void act()
    {   
        if(status.equals("Alive")){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            move();
            takeGun(mouse);   

            if(holdingGun){
                shotGun(mouse);            
            }else{
                hitEnemy(mouse);
            }
            rotation(mouse);
            changeEscenario();
            showScore();
            showAmmunition();
            movementAnimation();
            checkWalls();
        }else if(status.equals("Stunned")){
            if(timeStunned>0){
                timeStunned--;

            }else{
                status="Alive";
                timeStunned=900;
            }
        }else if(status.equals("Dead")){
            setImage("images/player_dead_PA.png");
            Greenfoot.delay(50);
            playerName=Greenfoot.ask("Ingresa tu nombre:");
            highscores.saveHighScore(playerName, score);
            Greenfoot.setWorld(new GameOver());
        }
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

    public void takeGun(MouseInfo mouse) {
        Gun gun = (Gun) getOneIntersectingObject(Gun.class);
        if (gun != null) {
            if (!holdingGun && Greenfoot.isKeyDown("space") && currentMele==null) {
                holdingGun = true;
                currentGun = gun; 
                ammunition=currentGun.getAmmunition();
                gun.getImage().setTransparency(0);
            }
        }
        if (holdingGun && currentGun!=null) {
            currentGun.setLocation(getX(), getY());
            if (Greenfoot.isKeyDown("k") && mouse!=null) {
                if(currentGun.getAmmunition()==0){
                    holdingGun = false;
                    double dx = mouse.getX() - currentGun.getX();  
                    double dy = mouse.getY() - currentGun.getY();  
                    double angle = Math.atan2(dy,dx)*180.0/(Math.PI);
                    currentGun.setRotation((int)angle);
                    currentGun.lanza(true);
                    currentGun = null; 
                    gun.getImage().setTransparency(255);
                }else{
                    holdingGun = false;
                    currentGun = null; 
                    gun.getImage().setTransparency(255);    
                }

            }
        }

        WeaponMele mele = (WeaponMele) getOneIntersectingObject(WeaponMele.class);
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
                ammunition=currentGun.getAmmunition();
            }
        }
    }

    public void changeEscenario(){
        DoorWarp exit=(DoorWarp)getOneIntersectingObject(DoorWarp.class);
        int nextX=100;
        int nextY=100;
        if(exit!=null){
            currentEscenario++; 
            World newEscenario=null;
            switch (currentEscenario) {
                case 2:
                    newEscenario = new Scenario2();
                    escenarioName = "Nivel 1 Sala 2";
                    nextX=56;
                    nextY=getY()-10;
                    break;
                    
                case 3:
                    newEscenario = new Scenario3();
                    escenarioName = "Nivel 1 Sala 3";
                    nextX=getX();
                    nextY=571;
                    break;
                
                case 4:
                    newEscenario = new Scenario4();
                    escenarioName = "Nivel 1 Sala 4";
                    nextX=1041;
                    nextY=getY();
                    break;
                
                case 5:
                    newEscenario = new Scenario5();
                    escenarioName = "Nivel 2 Sala 1";
                    nextX=139;
                    nextY=552;
                    break;
                
                case 6:
                    newEscenario = new Scenario6();
                    escenarioName = "Nivel 2 Sala 2";
                    nextX=52;
                    nextY=getY();
                    break;
                    
                case 7:
                    newEscenario = new Scenario7();
                    escenarioName = "Nivel 2 Sala 3";
                    nextX=52;
                    nextY=getY();
                    break;
                
                case 8:
                    newEscenario = new Scenario8();
                    escenarioName = "Nivel 3 Sala 1";
                    nextX=131;
                    nextY=473;
                    break;
                    
                case 9:
                    newEscenario = new Scenario9();
                    escenarioName = "Nivel 3 Sala 2";
                    nextX=40;
                    nextY=getY();
                    break;
                    
                case 10:
                    newEscenario = new Scenario10();
                    escenarioName = "Nivel 3 Sala 3";
                    nextX=50;
                    nextY=getY();
                    break;
                  
                default:
                    newEscenario = new Victory();
                    break;
            }

            Greenfoot.setWorld(newEscenario);
            newEscenario.addObject(this, nextX, nextY);
            if(currentGun!=null){
                newEscenario.addObject(this.currentGun, nextX, nextY);
            }
            nameDeley=300;
        }

    }

    public void increaseScore(int puntos) {
        score+=puntos;
    }

    public void showScore(){
        World world = getWorld();
        world.showText("Score: "+score, 200,50);
    }

    public void showAmmunition(){
        World world = getWorld();
        world.showText("Munición: "+ammunition, 80,50);
    }

    public void hitEnemy(MouseInfo mouse){
        if(mouse!=null){
            int hits=mouse.getClickCount();
            if(0<hits){
                //setImage(golpeDerecho);
                //setImage(golpeIzquierdo);
                if(currentMele==null){
                    setImage("images/player_punch_PA.png");
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

    public void setStatus(String status){
        this.status=status;
    }

    public String getStatus(){
        return status;
    }

    public void movementAnimation(){
        if(holdingGun==false){
            if(isPressingMovementKeys()){
                if(playerDeley==0){
                    playerImageIndex++;
                    if(playerImageIndex>6){
                        playerImageIndex=0;
                    }
                    setImage(images[playerImageIndex]);
                    playerDeley=30;
                }
                playerDeley--;
            }else{
                setImage("images/player_walk_1_PA.png");
            }
        }else{
            ShotGun shotgun = (ShotGun)getOneIntersectingObject(ShotGun.class);
            AssaultRifle rifle = (AssaultRifle)getOneIntersectingObject(AssaultRifle.class);
            SimpleGun simple = (SimpleGun)getOneIntersectingObject(SimpleGun.class);
            if(shotgun != null){
                setImage("images/player_shotgun_PA.png");
            }
            if(rifle != null){
                setImage("images/player_rifle_PA.png");
            }
            if(simple != null){
                setImage("images/player_gun_PA.png");
            }
        }
    }

    public boolean isPressingMovementKeys(){
        return Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a")
        || Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d");
    }

    public void checkWalls(){
        Wall wall = (Wall)getOneIntersectingObject(Wall.class);
        int offsetX=0;
        int offsetY=0;
        if(wall!=null){
            if(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a")){
                offsetX=OFFSET;
            }
            if(Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d")){
                offsetX=-OFFSET;
            }
            if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("w")){
                offsetY=OFFSET;
            }
            if(Greenfoot.isKeyDown("down")||Greenfoot.isKeyDown("s")){
                offsetY=-OFFSET;
            }
            setLocation(getX()+offsetX,getY()+offsetY); 
        }

        
    }
}
