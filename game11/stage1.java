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
        
        showText("制作なう", 300, 300);
        addObject( new textbox(), 300, 300 );
        textbox textbox = new textbox();
        if (Greenfoot.mouseClicked(textbox)) // クリックされたら
        {
            Greenfoot.setWorld(new stage1()); // 切り替え
        }
    }
}
