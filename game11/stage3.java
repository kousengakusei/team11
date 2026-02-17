import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class stage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class stage3 extends World
{
    private int i = 1;
    private boolean spaceDown;
    KeyTypingManager2 man;
    
    private TimerActor timer;
    
    /**
     * Constructor for objects of class stage.
     * 
     */
    public stage3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        man = new KeyTypingManager2();
        addObject(new principal(), 300, 250);
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
            showText("「校長室」", 300, 300);
            break; 
            
            case 2:
            showText("扉　バンッ！！！！ ", 300, 300);
            break; 
            
            case 3:
            timer = new TimerActor(20);
            addObject(timer, 550, 10);
            
            showText(" ", 300, 300);
            showText("堀　校長先生！！", 300, 275);
            
            man.append("コウチョウセンセイ");
            showText(man.upcoming(),300, 300);
            break;
            
            case 4:
            if ( timer != null) {
                
                removeObject(timer);
            }
            
            showText(" ", 300, 275);
            showText("校　うわぁ！なんだ君は！？", 300, 300);
            break;
            
            case 5:
            timer = new TimerActor(50);
            addObject(timer, 550, 10);
            
            showText(" ", 300, 275);
            showText("校長先生、僕の名前知らないんですか！？堀坊です！", 300, 275);
            
            man.append("コウチョウセンセイボクノナマエシラナインデスカホリボウデス");
            showText(man.upcoming(),300, 300);
            break;
            
            case 6:
            if ( timer != null) {
                
                removeObject(timer);
            }
            
            showText(" ", 300, 275);
            showText("校　私に謁見するためにはまず総務課に・・・", 300, 300);   
            break;
            
            case 7:
            timer = new TimerActor(50);
            addObject(timer, 550, 10);
            
            showText(" ", 300, 300);
            showText("そんなことはどうでもいいんです！\n校長先生、俺の単位がピンチなんです。\nどうにかして、俺の単位をあの先生から認めさせてください！ ", 300,200);
            
            man.append("ソンナコトハドウデモイインデスコウチョウセンセイオレノタンイガピンチナンデスドウニカシテオレノタンイヲアノセンセイカラミトメサセテクダサイ");
            showText(man.upcoming(),300, 300);
            break;
            
            case 8:
            if ( timer != null) {
                
                removeObject(timer);
            }
            
            showText(" ", 300, 200);
            showText("校　!?", 300, 300);   
            break;
            
            case 9:
            showText(" ", 300, 300);
            showText("校　そんなことできわけないだろう！\nそもそも、君がまともに先生の話を聞かないのが悪いのではないか！？", 300, 300);   
            break;
            
            case 10:
            timer = new TimerActor(50);
            addObject(timer, 550, 10);
            
            showText(" ", 300, 300);
            showText("あれは先生が悪いんです！\n先生があんな性悪なレポートを出してこなければ！", 300,275);
            
            man.append("アレハセンセイガワルインデスセンセイガアンナショウワルナレポートヲダシテコナケレバ");
            showText(man.upcoming(),300, 300);
            break;
            
            case 11:
            if ( timer != null) {
                
                removeObject(timer);
            }
            
            showText(" ", 300, 275);
            showText("校　...", 300, 300);   
            break;
            
            case 12:
            showText(" ", 300, 300);
            showText("校　もうわかった...認めよう。認めるから、頼むから校長室で暴れないでくれ。", 300, 300);   
            break;
            
            case 13:
            timer = new TimerActor(40);
            addObject(timer, 550, 10);
            
            showText(" ", 300, 300);
            showText("堀　校長先生、わかってくれましたか！よっしゃー！", 300,275);
            
            man.append("コウチョウセンセイワカッテクレマシタカヨッシャー");
            showText(man.upcoming(),300, 300); 
            break;
            
            case 14:
            if ( timer != null) {
                
                removeObject(timer);
            }
            
            showText(" ", 300, 275);
            showText("校　ああ。もうわかったから。とりあえず、今日はもう帰ってくれ。", 300, 300);   
            break;
            
            case 15:
            timer = new TimerActor(40);
            addObject(timer, 550, 10);
            
            showText(" ", 300, 300);
            showText("堀　本当に良いんですね！校長先生、ありがとうございました！", 300,275);
            
            man.append("ホントウニイインデスネコウチョウセンセイアリガトウゴザイマシタ");
            showText(man.upcoming(),300, 300); 
            break;
            
            case 16:
            if ( timer != null) {
                
                removeObject(timer);
            }
            
            showText(" ", 300, 275);
            showText("数時間後", 300, 300);   
            break;
            
            case 17:
            showText(" ", 300, 300);
            showText("校　...やっと終わった。", 300, 300);   
            break;
            
            case 18: 
            Greenfoot.setWorld(new clear());
            break;
        }
    }
    
    public void stopped() {
        man.stop();
    }
}
