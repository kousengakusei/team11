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
        showText("stage2\npress c", 300, 300);
        addObject(new principal(), 300, 250);
        addObject( new textbox(), 300, 300 );
        TimerActor timer = new TimerActor(10);
        addObject(timer, 550, 10);
    }
    
    public void act()
    {
        if( Greenfoot.isKeyDown( "c" ) ){
            World stage = new clear();
            Greenfoot.setWorld( stage );
        }
    }
}
