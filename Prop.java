package com.neuedu.client;

import com.neuedu.action.ActionAble;
import com.neuedu.constant.Constant;
import com.neuedu.entity.GameObj;
import com.neuedu.util.GetImageUtil;

import java.awt.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName Prop
 * @date 2019/8/21
 * @description 道具类
 **/
public class Prop extends GameObj implements ActionAble {

    // 拿到客户端
    public GameClient gc;

    public Prop() {

    }

    private int speed;
    public Prop(int x, int y, String imgName) {
        this.x = x;
        this.y = y;
        this.img = GetImageUtil.getImg(imgName);
        this.speed = 5;
    }
    // 角度
    private double thera = Math.PI/4;
    @Override
    public void move() {
        x += speed * Math.cos(thera);
        y += speed * Math.sin(thera);
        if (x<0 || x>Constant.GAME_WIDTH-img.getWidth(null)){
            thera = Math.PI-thera;
        }
        if (y<35){
            thera = -thera;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img,x,y,null);
        move();
    }

    // 获取当前的矩形
    public Rectangle getRec(){
        return new Rectangle(x,y,this.img.getWidth(null),this.img.getHeight(null));
    }

}
