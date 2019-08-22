package com.neuedu.client;

import com.neuedu.constant.Constant;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName GameClient
 * @date 2019/8/17
 * @description 游戏客户端
 **/
public class GameClient extends Frame {

    // 创建一个plane出来
//    Plane plane = new Plane(210, 700, "plane/hero01.png",this,true);

    // 创建一个我方角色的集合
    public List<Plane> planes = new ArrayList<>();

    // 创建道具集合
    public List<Prop> props = new ArrayList<>();

    // 创建一个道具出来
//    Prop prop = new Prop(400,70,"prop/prop01.png");

    // 创建一颗子弹出来
//    Bullet bullet = new Bullet(300,600, "zidan1.png");

    // 创建一个子弹集合
    public List<Bullet> bullets = new ArrayList<>();

    // 创建一个背景图出来
    BackGround backImg = new BackGround(0,0,"beijing.png");

    // 创建敌机一号出来
    EnemyPlane enemy1 = new EnemyPlane(10,0,1,this,false);
    // 2号
    EnemyPlane enemy2 = new EnemyPlane(100,100,1,this,false);
    // 3号
    EnemyPlane enemy3 = new EnemyPlane(50,-120,1,this,false);
    // 4号
    EnemyPlane enemy4 = new EnemyPlane(450,130,1,this,false);
    // 5号
    EnemyPlane enemy5 = new EnemyPlane(210,-110,1,this,false);
    // 6号
    EnemyPlane enemy6 = new EnemyPlane(550,15,1,this,false);

    // 创建敌机集合
    public List<Plane> enemys = new ArrayList<>();

    // 创建一个爆炸集合
    public List<Boom> booms = new ArrayList<>();

    // 解决图片闪烁的问题
    public void update(Graphics g) {
        Image backImg = createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        Graphics backg = backImg.getGraphics();
        Color color = backg.getColor();
        backg.setColor(Color.WHITE);
        backg.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        backg.setColor(color);
        paint(backg);
        g.drawImage(backImg, 0, 0, null);
    }

    Plane plane = null;
    // 生成客户端窗口的方法
    public void launchFrame() {
        // 设置窗口大小
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        // 设置标题
        this.setTitle("卡通大作战");
        // 设置是否能够显示
        this.setVisible(true);
        // 禁止最大化
//        this.setResizable(false);
        // 窗口居中
        this.setLocationRelativeTo(null);
        // 关闭窗口 添加关闭监视器
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        plane = new Plane(210, 700, "plane/hero01.png",this,true);
        // 往我方容器中添加自己
        planes.add(plane);

        // 添加鼠标监听
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("你点了一下鼠标");
            }
        });

        // 添加键盘监听
        this.addKeyListener(new KeyAdapter() {
            // 键盘按下的情况
            @Override
            public void keyPressed(KeyEvent e) {
                plane.keyPressed(e);
//
            }
            @Override
            public void keyReleased(KeyEvent e) {
                plane.keyReleased(e);
            }
        });

        // 启动线程
        new paintThread().start();

        // 向敌方容器中添加敌机
        enemys.add(enemy1);
        enemys.add(enemy2);
        enemys.add(enemy3);
        enemys.add(enemy4);
        enemys.add(enemy5);
        enemys.add(enemy6);
    }

    // 重写paint方法
    @Override
    public void paint(Graphics g) {
        backImg.draw(g);
        for (int i = 0; i < planes.size(); i++) {
            Plane plane2 = planes.get(i);
            plane2.draw(g);
            plane2.containItems(props);

        }
        // 循环画出每一个子弹
        // 增强for循环不能做任何操作
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.draw(g);
            bullet.hitPlanes(enemys);
            bullet.hitPlanes(planes);
        }
        g.drawString("当前子弹数量"+bullets.size(),15,60);
        g.drawString("当前敌机数量"+enemys.size(),15,78);
        g.drawString("当前爆炸数量"+booms.size(),15,96);
        g.drawString("当前道具数量"+props.size(),15,114);

        // 循环画敌机
        for (int i = 0; i < enemys.size(); i++) {
            enemys.get(i).draw(g);
        }
        // 循环爆炸
        for (int i = 0; i < booms.size(); i++) {
            booms.get(i).draw(g);
        }
        // 循环画道具
        for (int i = 0; i < props.size(); i++) {
            props .get(i).draw(g);
        }
    }

    // 内部类
    class paintThread extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
