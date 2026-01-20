import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class home extends World
{
    
    private int i = 0;
    private boolean spacePressed = false;
    
    /**
     * Constructor for objects of class home.
     * 
     */    

    public home()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        showText("堀坊の落単を阻止せよ！\n※テキストは'スペースキー'で進めます。", 300, 200);
        showText("START 'space'", 300, 300);
        addObject( new textbox(), 300, 300 );
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) { 
            
            if (!spacePressed) { 
                
                i++; spacePressed = true; 
            } 
        } else { 
            
            spacePressed = false; 
        }

        switch(i) { 
            
            case 0: 
            showText("堀坊の落単を阻止せよ！\n※テキストは'スペースキー'で進めます。", 300, 200);
            showText("START 'space'", 300, 300);
            break; 
            
            case 1: 
            showText("ある日、堀坊はいつもの通りに高専に登校していた。", 300, 300); 
            break; 
            
            case 2: 
            showText("登校中、堀坊はなぜだか胸騒ぎがした。", 300, 300); 
            break; 
            
            case 3: 
            showText("教室に着いたとき、\nその胸騒ぎの答え合わせが目の前にあった。", 300, 300); 
            break; 
            
            case 4: 
            showText("なぜなら、今日はレポート提出日だったのだから。", 300, 300); 
            break;
            
            case 5: 
            showText("レポートを出さなくては落単。", 300, 300); 
            break;
            
            case 6: 
            showText("今からレポートを作成するにはあまりにも現実的ではない。", 300, 300); 
            break;
            
            case 7: 
            showText("そこで、堀坊は担当の先生に直談判することにした。", 300, 300); 
            break;
            
            case 8: 
            showText("しかし、担当の先生は話を聞いてくれない。", 300, 300); 
            break;
            
            case 9: 
            showText("そこで校長先生に直談判をしようと決めた。", 300, 300); 
            break;
            
            case 10: 
            showText("何事も、最高権力を行使すれば言うことを聞くはず。", 300, 300); 
            break;
            
            case 11: 
            showText("なんとか上手く言い訳をして、落単を阻止する。", 300, 300); 
            break;
            
            case 12: 
            showText("すべては落単を回避するために___", 300, 300); 
            break;
            
            case 13: 
            World stage = new stage1();
            Greenfoot.setWorld( stage );
            break;
        }
    }
}
