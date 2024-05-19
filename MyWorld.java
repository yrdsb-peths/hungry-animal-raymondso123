import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world our hero lives in.
 * 
 * @author Raymond So
 * @version 05/13/24
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public int score = 0;
    public int level = 0;
    
    Label label;
    Label death;
    
    Elephant hero;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        hero = new Elephant();
        addObject(hero,300,300);
        
        label = new Label(0,50);
        addObject(label,20,20);
        
        newApple();
    }
    
    public void up() {
        score++;
        label.setValue(score);
        hero.setSpeed(1);
        
        if (score % 5 == 0) {
            level += 1;
        }
        
        if (score % 15 == 0) {
            newApple();
        }
    }
    
    public void over() {
        death = new Label(0,50);
        addObject(death,300,200);
        death.setValue("Game Over!! >:(");
        
        label.setValue("Final Score: " + score);
        label.setLocation(300,250);
        Greenfoot.delay(100000000);
    }
    
    /**
     * Create apple
     */
    public void newApple() {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        addObject(apple,x,0);
    }
}
