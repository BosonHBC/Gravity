package bochhuang2.scm.gravity;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;

/**
 * Created by 黄波铖 on 2017/3/15.
 */

public class Player {
    // default constructor
    public Player(){}

    float vertSpeed = 35;
    float horiSpeed = 15;

    float g = 9.8f;

    int hp = 3;

   public float valueX;
   public float valueY;

    PointF pos;
    RectF playRect;

    float posX;
    float posY;

    float upRectY;  // y position of celling
    float downRectY;// y position of roof

    public Player(float x, float y){
        posX = x;
        posY = y;
        pos = new PointF();
        UpdatePos();
    }

    public void setHp(int HP){
        hp = HP;
    }
    public int getHp(){
        return hp;
    }


    public void Move(){

        // hori is the tilt rate along X axis
        if(valueX < 0.02 && valueX > -0.02){
            valueX = 0;
        }
        posX += valueX * horiSpeed;

        if(posX > 2420 - playRect.width()/2){
            posX = 2420 - playRect.width()/2;
        }
        if(posX < 0 + playRect.width()/2 ){
            posX = 0 + playRect.width()/2 ;
        }

        // is Down is tilt rate along Y axis, and give a boolean
        if(valueY > 3){
            posY += vertSpeed;
            if(posY > downRectY - playRect.height()/2){
                posY = downRectY - playRect.height()/2;
            }
        }
        else if(valueY <3)
        {
            posY -= vertSpeed;
            if(posY < upRectY + playRect.height()/2){
                posY = upRectY +playRect.height()/2;
            }
        }
        /*
         if(valueY > 1){

            g = 9.8f;
        }
        else if(valueY <1)
        {
            g = -9.8f;

        }
        vertSpeed += g/20;

        posY += vertSpeed;
        if(posY > 1270){
            posY = 1270;
            vertSpeed = 0;
        }
        if(posY < 170){
            posY = 170;
            vertSpeed = 0;
        }
        */
    }

    public void setSpeed(float h, float v){
        valueX = h;
        valueY = v;
    }

    public void UpdatePos(){
        pos.x = posX;
        pos.y = posY;

        float sX = getPos().x-150;
        float sY = getPos().y-150;
       playRect = new RectF(sX+70,sY+70,sX+200,sY+250);
    }

    public PointF getPos(){
        return pos;
    }

    public void setPos(float x, float y){
        posX = x;
        posY = y;
    }

    public RectF getPlayRect(){
        return playRect;
    }

    public void setUpDownRectY(float up,float down){
        upRectY = up;
        downRectY = down;
    }
}
