import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TimerActor extends Actor {
    private long startTime;
    public int timeLimit;
    private boolean isInitialized = false;

    // コンストラクタ：制限秒数を指定できるようにする
    public TimerActor(int seconds) {
        this.timeLimit = seconds;
    }

    public void act() {
        // Runボタンが押された最初の1回だけ実行開始時間を記録
        if (!isInitialized) {
            startTime = System.currentTimeMillis();
            isInitialized = true;
        }

        updateDisplay();
    }

    private void updateDisplay() {
        long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
        int remainingTime = timeLimit - (int)elapsedSeconds;

        if (remainingTime >= 0) {
            // 見た目を更新（文字サイズ24, 文字色BLACK, 背景透明）
            setImage(new GreenfootImage("Time: " + remainingTime, 24, Color.BLACK, new Color(0,0,0,0)));
        } else {
            World gameover = new gameover();
            Greenfoot.setWorld( gameover );
            Greenfoot.setWorld(new gameover());// 0秒になったら停止
        }
    }
}