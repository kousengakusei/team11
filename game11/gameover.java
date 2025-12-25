import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameover extends World
{

    /**
     * Constructor for objects of class gameover.
     * 
     */
    public gameover(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);                  
        GreenfootImage image = new GreenfootImage(600,400);
        image.setColor(Color.BLACK);
        image.fill();
        showText("game over", 300, 300);
        if(Greenfoot.mouseClicked(this)){
            
            Greenfoot.setWorld(new home());
        }
    }
}
