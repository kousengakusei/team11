import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class textbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class textbox extends Actor
{
    /**
     * Act - do whatever the textbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        getImage().setTransparency(128);
        if (Greenfoot.mouseClicked(this)) // クリックされたら
        {
            Greenfoot.setWorld(new stage1()); // 切り替え
        }
    }    
}
