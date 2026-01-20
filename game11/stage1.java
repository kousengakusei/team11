import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stage1 extends World
{

    /**
     * Constructor for objects of class stage1.
     * 
     */
    
    public stage1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        showText("stage1\ntype 「go stage2」", 300, 225);
        addObject(new teacher(), 300, 250);
        addObject( new textbox(), 300, 300 );
        TimerActor timer = new TimerActor(10);
        addObject(timer, 550, 10);
    }
    public void act()
    {
        if( inputdata.text.equals( "go stage2" ) ){
            World stage = new stage2();
            Greenfoot.setWorld( stage );
        }
    }
}
