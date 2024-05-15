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
    GreenfootImage idle = new GreenfootImage("images/walk/00_walk.png");
    SimpleTimer delay = new SimpleTimer();
    String facing = "left";
    
    public void act()
    {
        if (Greenfoot.isKeyDown("left")) {
            move(-2);
            facing = "left";
        }
        else if (Greenfoot.isKeyDown("right")) {
            move(2);
            facing = "right";
        }
        
        eat();
        delay.mark();
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
