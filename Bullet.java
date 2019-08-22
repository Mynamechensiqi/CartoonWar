package com.neuedu.client;

import com.neuedu.action.ActionAble;
import com.neuedu.entity.GameObj;
import com.neuedu.util.GetImageUtil;

import java.awt.*;
import java.util.List;
import java.util.Random;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName Bullet
 * @date 2019/8/20
 * @description
 **/
public class Bullet extends GameObj implements ActionAble {

    // 创建速度属性
    private Integer speed;

    // 拿到客户端
    public GameClient gc;

    // 子弹类型
    public boolean isGood;

    public Bullet() {
    }

    public Bullet(int x, int y, String imgName, GameClient gc,boolean isGood) {
        this.x = x;
        this.y = y;
        this.img = GetImageUtil.getImg(imgName);
        this.speed = 5;
        this.gc = gc;
        this.isGood = isGood ;
    }

    @Override
    public void move() {
        if (isGood){
            y -= speed;
        }else{
            y += speed;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
        move();
        outOfBounds();
    }

    // 子弹越界销毁
    public void outOfBounds() {
        if (y < 0 || y > 800) {
            gc.bullets.remove(this);
        }
    }

    // 随机生成道具
    Random random = new Random();

    // 子弹打一个敌机
    public boolean hitPlane(Plane plane){
        if (this.getRec().intersects(plane.getRec()) && this.isGood != plane.isGood ){
            Boom boom = new Boom(plane.x, plane.y,gc);
            if (plane.isGood){
                // 销毁自身
                gc.planes.remove(plane);
                // 添加爆炸
                gc.booms.add(boom);
             }else{
                // 移除打中敌人
                gc.enemys.remove(plane);
                // 移除子弹
                gc.bullets.remove(this);
                // 添加爆炸
                gc.booms.add(boom);
                // 生成一个道具出来
                if (random.nextInt(500) > 400){
                    if (plane instanceof EnemyPlane){
                        EnemyPlane enemyPlane = (EnemyPlane)plane;
                        Prop prop = new Prop(plane.x+enemyPlane.imgs1[0].getWidth(null)/2, plane.y+enemyPlane.imgs1[0].getHeight(null)/2, "prop/prop01.png");
                        gc.props.add(prop);
                    }
                }

            }
            return true;
        }
        return false;
    }
    // 子弹打多个敌机
    public boolean hitPlanes(List<Plane> planes){
        for (int i = 0; i < planes.size(); i++) {
            if (hitPlane(planes.get(i))){
                return true;
            }
        }
        return false;
    }

    // 获取子弹的矩形
    public Rectangle getRec(){
        return new Rectangle(x,y,this.img.getWidth(null),this.img.getHeight(null));
    }
}
