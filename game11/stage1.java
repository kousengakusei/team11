import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stage1 extends World
{
    
    private int i = 1;
    private boolean spaceDown;
    KeyTypingManager2 man;
    
    private TimerActor timer;
    
    /**
     * Constructor for objects of class stage1.
     * 
     */
    
    public stage1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        man = new KeyTypingManager2();
        showText(" ", 300, 225);
        addObject(new teacher(), 300, 250);
    }
    
    public void act()
    {
        if (man.upcoming().length() > 0 ) {
            String s = Greenfoot.getKey();
            if (s != null && s.length() == 1) {
                man.onTyped((char)s.getBytes()[0]);
                showText(man.upcoming(),300, 300);
                if (man.upcoming().length() == 0) {
                    i++;
                }
            }
            return;
        }
        
        if (spaceDown != Greenfoot.isKeyDown("space")) {
            
            spaceDown = !spaceDown;
            if (spaceDown) {
                
                i++;
            }
        }
        
        switch( i ) {
                              
            case 1:
            showText("「演習室」", 300, 300);
            break; 
            
            case 2: 
            showText("放課後... ", 300, 300);
            break; 
            
            case 3: 
            showText("堀　... ", 300, 300); 
            break;
            
            case 4: 
            showText("先　堀坊君 ", 300, 300); 
            break;
            
            case 5: 
            showText("堀　...... ", 300, 300); 
            break;
            
            case 6: 
            showText("先　堀坊君...!! ", 300, 300); 
            break;
            
            case 7: 
            timer = new TimerActor(20);
            addObject(timer, 550, 10);
            
            showText(" ", 300, 300);
            showText("なんですか！今忙しいので黙っててください！", 300, 275);
            
            man.append("ナンデスカイマイソガシイノデダマッテテクダサイ");
            showText(man.upcoming(),300, 300);
            break;
            
            case 8:
            if ( timer != null) {
                
                removeObject(timer);
            }
            
            showText(" ", 300, 275);
            showText("先　今何時だと思っているんだ！\nレポート提出時間はとうに過ぎているぞ！ ", 300, 300);
            break;
            
            case 9:
            timer = new TimerActor(20);
            addObject(timer, 550, 10);
            
            showText(" ", 300, 300);
            showText(" ", 300, 275);
            showText("堀　先生がこんなものを作らせるのが悪いんですよ！ ", 300, 275); 
            
            man.append("センセイガコンナモノヲツクラセルノガワルインデスヨ");
            showText(man.upcoming(),300, 300);
            break;
            
            case 10:
            if ( timer != null) {
                
                removeObject(timer);
            }
            
            showText(" ", 300, 300);
            showText(" ", 300, 275);
            showText("先　落単しても知らんからな！ ", 300, 275);
            break;
            
            case 11:
            if ( timer != null) {
                
                removeObject(timer);
            }
            
            showText(" ", 300, 300);
            showText(" ", 300, 275);
            showText("堀　えー！ ", 300, 275);
            
            man.append("エー");
            showText(man.upcoming(),300, 300);
            break;
            
            case 12: 
            Greenfoot.setWorld(new stage2());
            break;
        }
    }
    
    public void stopped() {
        man.stop();
    }
}
