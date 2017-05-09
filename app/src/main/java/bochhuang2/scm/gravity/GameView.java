package bochhuang2.scm.gravity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 黄波铖 on 2017/3/15.
 */

public class GameView extends View {

    // int
    int fps = 50;
    int wudiCount = 0;
    int floatTime = 0;

    // float
    float chara_f1 = 0;
    float chara_f2 = 3;

    float a = 0;
    float b = 500;
    float score = 0;

    int highScore = 0;


    // boolean
    boolean isGameStart = false;
    boolean isGameOver = false;

    boolean isWudi = false;

    boolean roadFloat = false;

    // image
    Bitmap character;
    Bitmap character2;
    Bitmap upLeft;
    Bitmap upRight;
    Bitmap hpUI;
    Bitmap endUI;

    Bitmap open;

    Bitmap hpImg;
    Bitmap coinImg;
    // Rect

    RectF gameStartRect = new RectF(933,892,1461,1055);

    RectF upRect = new RectF(0,-130,2420,170);
    RectF doRect = new RectF(0,1270,2420,1570);

    RectF restartRect = new RectF(885,408,1500,591);
    RectF backRect = new RectF(885,753,1500,940);
    // PointF

    // Paint
    Paint paint1 = new Paint();
    Paint blackPaint = new Paint();
    Paint playerPaint = new Paint();
    Paint hpPaint = new Paint();
    Paint textPaint = new Paint();

    // abstract data
    Timer t = new Timer();
    public Player player = new Player(120,1170);
    Levels levels = new Levels();
    Item item = new Item();



    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        Init();
    }
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Init();
    }

    public GameView(Context context) {
        super(context);

        Init();
    }

    private void Init() {

        // Image
        character = BitmapFactory.decodeResource(getResources(), R.drawable.character);
        character2 = BitmapFactory.decodeResource(getResources(), R.drawable.charater2);
        upLeft = BitmapFactory.decodeResource(getResources(), R.drawable.character3);
        upRight = BitmapFactory.decodeResource(getResources(), R.drawable.character4);
        hpUI = BitmapFactory.decodeResource(getResources(), R.drawable.hpui);
        endUI = BitmapFactory.decodeResource(getResources(), R.drawable.endui);
        open= BitmapFactory.decodeResource(getResources(), R.drawable.open);

        hpImg = BitmapFactory.decodeResource(getResources(), R.drawable.heart);
        coinImg = BitmapFactory.decodeResource(getResources(), R.drawable.score);
        // Paint
        paint1.setColor(Color.rgb(200,100,100));
        blackPaint.setColor(Color.rgb(40,40,40));
        playerPaint.setAlpha(255);
        hpPaint.setColor(Color.rgb(160,60,60));
        textPaint.setTextSize(80);
        textPaint.setColor(Color.rgb(240,240,240));
        t_timer();
    }

    private void WudiTime(){
        if(isWudi){
            wudiCount ++;
            if((wudiCount >= 0&& wudiCount< 20) || (wudiCount >= 40&& wudiCount< 60) || (wudiCount >= 80&& wudiCount< 100)){
                playerPaint.setAlpha(120);
            }
            if((wudiCount >= 20&& wudiCount< 40) || (wudiCount >= 60&& wudiCount< 80)){
                playerPaint.setAlpha(255);
            }
        }
        if(wudiCount >= fps*2){
            wudiCount = 0;
            isWudi = false;
            playerPaint.setAlpha(255);
        }
    }

    private void GameOver(){

        for (int i = 0; i<levels.getLevels()[levels.currentLevel].length;i++) {
            if (player.playRect.intersect(levels.getLevels()[levels.currentLevel][i])){
                //Random rd = new Random();
                if(!isWudi) {
                    isWudi = true;
                    player.setHp(player.getHp() - 1);

                    /*player.setPos(rd.nextFloat()*1210 + 300, rd.nextFloat()*1000 + 100);
                    player.UpdatePos();

                    for(int j = 0; j<1000;j++){
                        if(player.playRect.intersect(levels.getLevels()[levels.currentLevel][i])){
                            player.setPos(rd.nextFloat()*1210 + 300, rd.nextFloat()*1000 + 100);
                            player.UpdatePos();
                        }
                        else {
                            break;
                        }
                    }*/

                }
            }
        }
        for (int i = 0; i<levels.getLevels()[levels.nextLevel].length;i++) {
            if (player.playRect.intersect(levels.getLevels()[levels.nextLevel][i])){
                //Random rd = new Random();
                if(!isWudi) {
                    isWudi = true;
                    player.setHp(player.getHp() - 1);

                    /*player.setPos(rd.nextFloat()*1210 + 300, rd.nextFloat()*1000 + 100);
                    player.UpdatePos();

                    for(int j = 0; j<1000;j++){
                        if(player.playRect.intersect(levels.getLevels()[levels.nextLevel][i])){
                            player.setPos(rd.nextFloat()*1210 + 300, rd.nextFloat()*1000 + 100);
                            player.UpdatePos();
                        }
                        else {
                            break;
                        }
                    }*/

                }
            }
        }

        if(player.getHp() <= 0){
            isGameOver = true;
        }

        if(isGameOver){
            t.cancel();

        }


    }

    private void Restart() {
        isGameOver = false;
        score = 0;
        floatTime = 0;
        wudiCount = 0;
        isWudi = false;
        roadFloat = false;
        player = new Player(120,1170);
        levels = new Levels();
        t = new Timer();
        t_timer();
    }

    private void t_timer(){
        t.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        // test game start
                        if(isGameStart) {

                            // game loop
                            if(!isGameOver) {
                                if (roadFloat) {
                                    Random rd = new Random();
                                    a += 0.05;
                                    b += 0.05;

                                    if (a >= 1000)
                                        a = 0;
                                    if (b >= 1000)
                                        b = 0;

                                    upRect = new RectF(0, -130 + 130 * (float) Math.abs(Math.cos(a)), 2420, 170 + 130 * (float) Math.abs(Math.cos(a)));
                                    doRect = new RectF(0, 1270 - 130 * (float) Math.abs(Math.cos(b)), 2420, 1570 - 130 * (float) Math.abs(Math.cos(b)));

                                    floatTime++;

                                    if(floatTime >= fps * 4){
                                        floatTime = 0;
                                        roadFloat = false;

                                        upRect = new RectF(0,-130,2420,170);
                                        doRect = new RectF(0,1270,2420,1570);
                                    }

                                    //Log.d("log", "a: " + Math.abs(Math.cos(a)));
                                }

                                // levels
                                player.setUpDownRectY(upRect.bottom, doRect.top);
                                levels.Move();

                                if(levels.isNext){
                                    levels.isNext = false;
                                    item.GenerateItem();
                                }

                                // item
                                item.getData(levels.dir,levels.speed/2);

                                score += item.Contain(player);
                                score += 1;

                                if(score >= 1800 && score < 3600){
                                    levels.setSpeed(13);
                                }
                                if(score >= 3600 && score<5000){
                                    levels.setSpeed(15);
                                }

                                if(score >= 5000){
                                    item.Move();
                                }

                                if(score >= 7000 && score < 1000){
                                    levels.setSpeed(17);
                                }

                                if(score >= 10000 && !levels.isLevel2){
                                    levels.setSpeed(levels.getSpeed()*1.1f);
                                    levels.isLevel2 = true;
                                }
                                if(score >= 13000 && !levels.isLevel3){
                                    levels.setSpeed(levels.getSpeed()*1.2f);
                                    levels.isLevel3 = true;
                                }

                                if(score%1500 == 0){
                                    roadFloat = true;

                                }



                                // player controller
                                player.Move();
                               // Log.d("Game", "score: " +score);

                                WudiTime();

                                player.UpdatePos();



                                // test game over
                                GameOver();
                            }
                        }

                        // Update frame
                        postInvalidate();
                    }
                },
                0,
                1000/fps
        );
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.rgb(220,240,240));

        //int w = this.getWidth();
        //int h = this.getHeight();

        if(chara_f1 >= 4){
            chara_f1 = 0;
        }
        if(chara_f2 >= 6){
            chara_f2 = 3;
        }

        canvas.drawRect(upRect,blackPaint);
        canvas.drawRect(doRect,blackPaint);

        for (int i = 0; i<levels.getLevels()[levels.currentLevel].length;i++){

            canvas.drawRect(levels.getLevels()[levels.currentLevel][i],blackPaint);
        }
        for (int i = 0; i<levels.getLevels()[levels.nextLevel].length;i++){

            canvas.drawRect(levels.getLevels()[levels.nextLevel][i],blackPaint);
        }

        float sX = player.getPos().x-150;
        float sY = player.getPos().y-150;

        canvas.drawBitmap(hpUI,new Rect(0,0,2420,1440),new Rect(0,0,2420,1440),null);
        canvas.drawText(" " + (int)score, 330,1390, textPaint);

        if(player.getHp() > 0) {
            for (int i = 0; i < player.getHp(); i++) {
                canvas.drawCircle(250 + i*80,85,30,hpPaint);
            }
        }

        item.DrawItem(canvas,hpImg,coinImg);

        //Log.d("Game", "X:" + player.valueX + " Y: " + player.valueY);
        if(player.valueX> 0 && player.getPos().y >= 1440/2) {
            canvas.drawBitmap(character,
                    new Rect((int)chara_f1 * 300,300,300 *((int)chara_f1+1) ,600)
                    , new RectF(sX,sY,sX+300,sY+300)
                    , playerPaint);
        }
        else if(player.valueX<= 0 && player.getPos().y >= 1440/2) {
            canvas.drawBitmap(character2,
                    new Rect((int)chara_f2 * 300,300,300 *((int)chara_f2+1) ,600)
                    , new RectF(sX,sY,sX+300,sY+300)
                    , playerPaint);
        }
        else if(player.valueX<= 0 && player.getPos().y < 1440/2){
            canvas.drawBitmap(upLeft,
                    new Rect((int)chara_f2 * 300,300,300 *((int)chara_f2+1) ,600)
                    , new RectF(sX,sY,sX+300,sY+300)
                    , playerPaint);
        }
        else if(player.valueX > 0 && player.getPos().y < 1440/2){
            canvas.drawBitmap(upRight,
                    new Rect((int)chara_f1 * 300,300,300 *((int)chara_f1+1) ,600)
                    , new RectF(sX,sY,sX+300,sY+300)
                    , playerPaint);
        }

        if(isGameOver) {
            canvas.drawBitmap(endUI, new Rect(0, 0, 2420, 1440), new Rect(0, 0, 2420, 1440), null);

            if(score > highScore)
                highScore = (int)score;


            String ttx = "Your Score: " + (int)score + "   High score: " + highScore;
            canvas.drawText(ttx,600,115,textPaint );

        }

        if(!isGameStart){
            canvas.drawBitmap(open,new Rect(0,0,6722,4000),new Rect(0,0,2420,1440),null);
        }

        chara_f1 += 0.2;
        chara_f2 += 0.2;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:{
                Log.d("mouse","X: " + event.getX() + " Y: " + event.getY());
                PointF down = new PointF(event.getX(),event.getY());

                if(isGameOver && restartRect.contains(down.x,down.y)){
                    Restart();
                }
                if(isGameOver && backRect.contains(down.x,down.y)){
                   isGameStart = false;
                    postInvalidate();
                }

                if(!isGameStart && gameStartRect.contains(down.x,down.y)){
                    isGameStart = true;
                    if(isGameOver){
                        Restart();
                    }
                }

                break;
            }

        }

        return true;
    }
}
