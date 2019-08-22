package com.neuedu.client;

import com.neuedu.action.ActionAble;
import com.neuedu.constant.Constant;
import com.neuedu.entity.GameObj;
import com.neuedu.util.GetImageUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName Plane
 * @date 2019/8/20
 * @description 创建一个攻击类
 **/
public class Plane extends GameObj implements ActionAble {

    // 速度
    private int speed;
    // 方向 布尔变量
    private boolean left, up, right, down;

    // 把客户端拿过来
    public GameClient gc;

    // 判断我军还是敌军
    public boolean isGood;

    // 添加飞机子弹等级变量
    public int Bulletlevel = 1;

    public Plane() {
    }

    public Plane(int x, int y, String imgName, GameClient gc,boolean isGood) {
        this.x = x;
        this.y = y;
        this.img = GetImageUtil.getImg(imgName);
        this.speed = 25;
        this.gc = gc;
        this.isGood = isGood;
    }

    // 移动的方法
    @Override
    public void move() {
        if (left) {
            x -= speed;
        }
        if (up) {
            y -= speed;
        }
        if (right) {
            x += speed;
        }
        if (down) {
            y += speed;
        }
    }

    // 画一个飞机出来
    @Override
    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
        move();
        outOfBound();
    }

    // 处理越界
    public void outOfBound() {
        if (y <= 30) {
            y = 40;
        }
        if (x <= 5) {
            x = 0;
        }
        if (x >= Constant.GAME_WIDTH - img.getWidth(null)) {
            x = Constant.GAME_WIDTH - img.getWidth(null);
        }
        if (y >= Constant.GAME_HEIGHT - img.getHeight(null)) {
            y = Constant.GAME_HEIGHT - img.getHeight(null);
        }
    }

    // 键盘按下
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            default:
                break;
        }
    }

    // 键盘释放
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_M:
                fire();
                break;
            default:
                break;
        }
    }

    // 我方飞机开火
    public void fire() {
        Bullet bullet = new Bullet(x+5 , y, "bullet/zidan"+Bulletlevel+".png",gc,true);
        gc.bullets.add(bullet);
        Bullet bullet2 = new Bullet(x+57, y, "bullet/zidan"+Bulletlevel+".png",gc,true );
        gc.bullets.add(bullet2);
    }
    // 获取当前的矩形
    public Rectangle getRec(){
        return new Rectangle(x,y,this.img.getWidth(null),this.img.getHeight(null));
    }

    // 检测我方角色碰撞到道具
    public void containItem(Prop prop){
        if (this.getRec().intersects(prop.getRec())){
            // 移除道具
            gc.props.remove(prop);
            // 更改子弹等级
            if (Bulletlevel > 2){
                Bulletlevel = 3;
            }
            this.Bulletlevel += 1;
        }
    }
    // 检测我方角色碰撞到多个道具
    public void containItems(List<Prop> props){
        if (props == null){
            // 移除道具
            return;
        }else{
            for (int i = 0; i < props.size(); i++) {
                containItem(props.get(i));
            }
        }
    }
}
