import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title.
 * 
 * @author Raymond So
 * @version 05/19/24
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant",60);
    Label instructLabel = new Label("Use the \u2190 or \u2192 to Move \n Press <space> to start",30);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, getHeight()/2);
        addObject(instructLabel, getWidth()/2, getHeight()/2+70);
        prepare();
    }

    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,149,176);
        
        elephant.setLocation(405,150);
    }
}
