import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stage2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stage2 extends World
{
    private int i = 1;
    private boolean spaceDown;
    KeyTypingManager2 man;
    
    private TimerActor timer;

    /**
     * Constructor for objects of class stage2.
     * 
     */
    public stage2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        man = new KeyTypingManager2();
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
            showText("「廊下」", 300, 300);
            break; 
            
            case 2:
            timer = new TimerActor(90);
            addObject(timer, 550, 10);
            
            showText(" ", 300, 300);
            showText("あの性悪教師！\nあんな意地の悪いレポートを書かせる先生が悪い。\n俺ができないなら誰ができるんだ。\nあのレポートはやる意味があるのか。\nいちゃもんつけやがって。\n俺の作ったレポートの何が悪いというんだ。", 300, 150);
            
            man.append("アノショウワルキョウシアンナイジノワルイレポートヲカカセルセンセイガワルイオレガデキナイナラダレガデキルンダアノレポートハヤルイミガアルノカイチャモンツケヤガッテオレノレポートノナニガワルイトイウンダ");
            showText(man.upcoming(),300, 300);
            break; 
            
            case 3:
            if ( timer != null) {
                
                removeObject(timer);
            }
            
            timer = new TimerActor(40);
            addObject(timer, 550, 10);
            
            showText(" ", 300, 300);
            showText(" ", 300, 150);
            showText("堀　そうだ。上には上の権力がいる。上の権力には先生も逆らえないはず\nやってみるぞ！", 300, 275);
            
            man.append("ソウダウエニハウエノケンリョクガイルウエノケンリョクニハセンセイモサカラエナイハズヤッテミルゾ");
            showText(man.upcoming(),300, 300);
            break;

            case 4: 
            Greenfoot.setWorld(new stage3());
            break;
        }
    }
    
    public void stopped() {
        man.stop();
    }
}
