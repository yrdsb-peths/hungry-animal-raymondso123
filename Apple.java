import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for elephant.
 * 
 * @author Raymond So   
 * @version 05/13/24
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    
    public void act()
    {
        setLocation(getX(),getY()+1+speed);
        
        if (getY()>=350) {
            MyWorld world = (MyWorld) getWorld();
            world.over();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd) {
        speed = spd;
    }
}
