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
    private String text = "";
    private boolean active = false;
    private int delay = 100;
    public void act() 
    {
        // Add your action code here.
        getImage().setTransparency(128);
        String key = Greenfoot.getKey();
        
        // 最初の数フレームは入力無効
        if (!active)
        {
            delay--;
            text = "";
            if (delay <= 0) active = true;
            return;
        }       
        
        if (key != null)
        {
            if (key.equals("backspace") && text.length() > 0)
            {
                text = text.substring(0, text.length() - 1);
            }
            if (key.equals("space") && text.length() > 0)
            {
                text += " ";
            }
            else if (key.length() == 1)
            {
                text += key;
            }
            inputdata.text = text;
            updateImage();
        }
    }    
    
    private void updateImage()
    {
        GreenfootImage img = new GreenfootImage(300, 64);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.drawString(text, 60, 30);
        setImage(img);
    }
}
