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
    
    Label Score;
    Label GO;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Elephant hero = new Elephant();
        addObject(hero,300,300);
        
        Score = new Label(0,0);
        addObject(Score,20,20);
        
        GO = new Label(0,0);
        addObject(GO,0,0);
        
        newApple();
    }
    
    public void up() {
        score++;
        Score.setValue(score);
    }
    
    /**
     * Create apple
     */
    public void newApple() {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        addObject(apple,x,0);
    }
}
