package com;

import java.util.Properties;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName QQ
 * @date 2019/8/15
 * @description QQ实现了Car,Product
 **/
public class QQ implements Car,Product {
    @Override
    public void run() {
        System.out.println("启动出发");
    }

    @Override
    public void stop() {
        System.out.println("刹车");
    }

    @Override
    public double getPrice(){
        return 30000;
    }
}
