import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant is our hero.
 * 
 * 
 * @author Raymond So 
 * @version 05/13/24
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound sfx = new GreenfootSound("sfx.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];
    SimpleTimer delay = new SimpleTimer();
    String facing = "left";
    boolean moving = false;
    int speed = 2;
    
    public Elephant() {
        int ogSizeX = 47;
        int ogSizeY = 35;
        int scale = 100;
        double scalePer = (double)scale/ogSizeY;
        
        for (int i = 0; i < idleRight.length; i++) {
            idleRight[i] = new GreenfootImage("images/walk/0" + i + "_walk.png");
            idleRight[i].scale((int)(ogSizeX*scalePer),scale);
        }
                
        for (int i = 0; i < idleLeft.length; i++) {
            idleLeft[i] = new GreenfootImage("images/walk/0" + i + "_walk.png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale((int)(ogSizeX*scalePer),scale);
        }
        
        delay.mark();
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    public void animateElephant() {
        if (delay.millisElapsed() < 100) {
            return;
        }
        delay.mark();
        if (facing.equals("left")) {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        } else {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
    }
    
    public void setSpeed(int spd) {
        speed = speed + spd;
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("left")) {
            move(-speed);
            facing = "left";
            moving = true;
        }
        else if (Greenfoot.isKeyDown("right")) {
            move(speed);
            facing = "right";
            moving = true;
        } else {
            moving = false;
        }
        
        
        eat();
        if (moving==true) {
            animateElephant();
        } else {
            if (facing=="left") {
                setImage(idleRight[0]);
            } else {
                setImage(idleLeft[0]);
            }
        }
    }
    
    public void eat() {
        if (isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.newApple();
            world.up();
            sfx.play();
        }
    }
}
