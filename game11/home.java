import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.File;

/**
 * Write a description of class home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class home extends World
{
    KeyTypingManager2 man;
    /**
     * Constructor for objects of class home.
     * 
     */    

    public home()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        man = new KeyTypingManager2();
        showText("堀坊の落単を阻止せよ！", 300, 200);
        showText("press 「s」", 300, 300);
        addObject( new textbox(), 300, 300 );
    }
    
    public void act()
    {
        if( Greenfoot.isKeyDown( "s" ) ){
            World stage = new stage1();
            Greenfoot.setWorld( stage );
        }
    }
}
