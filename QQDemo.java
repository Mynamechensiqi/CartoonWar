package com;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName QQDemo
 * @date 2019/8/15
 * @description
 **/
public class QQDemo {
    public static void main(String[] args) {
        QQ qq = new QQ();
        Product p = qq;
        System.out.println(p.getPrice());
        Car car = qq;
        car.run();
        car.stop();

        Car c = (Car)p;  // Product强转Car
        c.run();
        c.stop();
    }
}
