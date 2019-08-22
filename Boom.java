package com.neuedu.client;

import com.neuedu.action.ActionAble;
import com.neuedu.entity.GameObj;
import com.neuedu.util.GetImageUtil;

import java.awt.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName Boom
 * @date 2019/8/21
 * @description 爆炸类
 **/
public class Boom extends GameObj implements ActionAble {

    private boolean isLive;
    private GameClient gc;

    // 动态初始化爆炸效果
    private static Image[] boomImgs = new Image[2];
    static {
        for (int i = 0; i < 2; i++) {
            boomImgs[i] = GetImageUtil.getImg("boom/baozha"+(i+1)+".png");

        }
    }

//    静态初始化爆炸效果
//    private static Image[] boomImgs = {
//            GetImageUtil.getImg("baozha1.png"),
//            GetImageUtil.getImg("baozha2 .png"),
//    };

    public Boom() {
    }

    public Boom(int x, int y,GameClient gc) {
        this.x = x;
        this.y = y;
        this.isLive = true;
        this.gc = gc;
    }

    @Override
    public void move() {

    }

    int count = 0;

    @Override
    public void draw(Graphics g) {
        if (isLive){
            if (count > 1) {
                isLive = false;
                // 移除爆炸
                gc.booms.remove(this);
                return;
            }
            g.drawImage(boomImgs[count++], x, y, null);
        }
    }
}
