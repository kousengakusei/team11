import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class home extends World
{
    /**
     * Constructor for objects of class home.
     * 
     */    
    public home()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(600, 400, 1);
        TimerActor timer = new TimerActor(10);

        showText("堀坊の落単を阻止せよ！\npress 「s」", 300, 300);
        addObject( new textbox(), 300, 200 );
        addObject(timer, 550, 10);
    }
    
    public void act()
    {
        if( Greenfoot.isKeyDown( "s" )){
            World stage = new stage1();
            Greenfoot.setWorld( stage );
        }
    }
}
