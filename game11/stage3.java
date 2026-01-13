import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stage3 extends World
{

    /**
     * Constructor for objects of class stage.
     * 
     */
    public stage3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        showText("stage3", 300, 75);
        TimerActor timer = new TimerActor(60);
        addObject( new textbox(), 300, 200 );
        addObject(timer, 550, 10);
    }
}
