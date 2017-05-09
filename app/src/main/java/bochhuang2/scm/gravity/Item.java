package bochhuang2.scm.gravity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.Random;
import java.util.concurrent.CancellationException;

/**
 * Created by 黄波铖 on 2017/3/19.
 */

public class Item {

    final int HP = 0;
    final int SCORE = 1;

    float posX;
    float posY;

    float frame = 0;
    boolean isEat = false;

    RectF itemRect;

    RectF[][] levels;

    int type;
    public Item(){

        GenerateItem();
    }

    int dir = 0;
    float speed = 0;

    public void getData(int dr, float sp){
        dir = dr;
        speed = sp;
    }

    public void GenerateItem(){
        Random rd = new Random();
        type = rd.nextInt(2);

        posX = rd.nextFloat()*2000 + 200;
        posY = rd.nextFloat()*1000 + 200;

        itemRect = new RectF(posX-80,posY-80, posX + 80, posY + 80);
        isEat = false;
    }

    public void Move(){
        posX += dir*speed;
        itemRect = new RectF(posX-80,posY-80, posX + 80, posY + 80);
    }

    public int Contain(Player player){
        switch (type){
            case HP:{
                if(itemRect.contains(player.getPos().x,player.getPos().y)&& !isEat){
                    isEat = true;
                    player.setHp(player.getHp() +1);
                    return 0;
                }
                break;
            }
            case SCORE:{
                if(itemRect.contains(player.getPos().x,player.getPos().y)&& !isEat){
                    isEat = true;
                    return 500;
                }
                break;
            }
        }
        return 0;
    }

    public void DrawItem(Canvas canvas, Bitmap hpImg, Bitmap scoreImg){

        switch (type){
            case HP:{
                if(!isEat) {
                    canvas.drawBitmap(hpImg,
                            null,
                            itemRect,
                            null);
                }
                break;
            }
            case SCORE:{
                if(!isEat) {
                    canvas.drawBitmap(scoreImg,
                            new Rect(420 * (int) frame, 0, 420 * ((int) frame + 1), 420),
                            itemRect,
                            null);

                    frame += 0.15;
                    if (frame >= 3) {
                        frame = 0;
                    }
                }
                break;
            }
        }





    }
}
