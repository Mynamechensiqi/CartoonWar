package com.neuedu.client;

import com.neuedu.action.ActionAble;
import com.neuedu.entity.GameObj;
import com.neuedu.util.GetImageUtil;

import java.awt.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName BackGround
 * @date 2019/8/20
 * @description 北京类
 **/
public class BackGround extends GameObj implements ActionAble {
    private Integer speed;

    public BackGround() {
    }

    public BackGround(int x, int y, String imgName) {
        this.x = x;
        this.y = y;
        this.img = GetImageUtil.getImg(imgName);
        this.speed = 2;
    }

    @Override
    public void move() {
//        y += speed;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(img ,x,y,null);
        move();

    }
}
