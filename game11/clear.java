import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class clear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class clear extends World
{

    /**
     * Constructor for objects of class clear.
     * 
     */
    public clear()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        showText("こうして、堀坊は単位を落とすことはなかった。\n今日も堀坊は冬道を元気に自転車で登校する。\n後日、一通の手紙が家に届くことを知らずに。", 300, 300);  
        showText("ホーム画面へ戻る 'H'", 300, 500);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown( "h" )){
            
            World stage = new home();
            Greenfoot.setWorld( stage );
        }
    }
}
