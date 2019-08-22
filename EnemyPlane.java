package com.neuedu.client;

import com.neuedu.action.ActionAble;
import com.neuedu.util.GetImageUtil;

import java.awt.*;
import java.util.Random;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName EnemyPlane
 * @date 2019/8/21
 * @description 敌机
 **/
public class EnemyPlane extends Plane implements ActionAble {

    // 敌机类型
    private Integer enemyType;

    private Integer speed;

    private GameClient gc;

    public static Image[] imgs1 = {
            GetImageUtil.getImg("enemy/enemy01BloodVolume01.png"),
            GetImageUtil.getImg("enemy/enemy01BloodVolume01.png"),
            GetImageUtil.getImg("enemy/enemy01BloodVolume01.png"),
    };

    public EnemyPlane(){

    }
    public EnemyPlane(int x,int y,int enemyType,GameClient gc,boolean isGood){
        this.x = x;
        this.y = y;
        this.enemyType = enemyType;
        this.speed = 1;
        this.gc = gc;
        this.isGood = isGood;
    }

    @Override
    public void move() {
        y += speed;
    }

    int count = 0;
    @Override
    public void draw(Graphics g) {
        if (count > 2 ){
            count = 0;
        }
        g.drawImage(imgs1[count++],x,y,null);
        move();
        if (random.nextInt(495) > 490){
            fire();
        }// 产生490-500之间十个数，所以频率降低
        outOfBounds();
    }

    // 敌机越界销毁
    public void outOfBounds() {
        if (x < 0 || x > 600) {
            gc.enemys.remove(this);
        }
    }

    // 随机数
    Random random = new Random();

    // 敌机发火
    public void fire(){
        Bullet bullet = new Bullet(x+imgs1[0].getWidth(null)/2, y, "enemy/bullet01.png", gc,false);
        gc.bullets.add(bullet);
    }

    // 获取子弹的矩形
    public Rectangle getRec(){
        return new Rectangle(x,y,this.imgs1[0].getWidth(null),this.imgs1[0].getHeight(null));
    }
}
