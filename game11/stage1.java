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
        showText("stage1\npress t", 300, 75);
        addObject( new textbox(), 300, 200 );
    }
    
    public void act()
    {
        if( Greenfoot.isKeyDown( "t" ) ){
            World stage = new stage2();
            Greenfoot.setWorld( stage );
        }
    }
}
