package com;

import java.awt.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName Circle
 * @date 2019/8/15
 * @description
 **/
public class Circle extends Shape {
    private int r;
    public Circle(int x,int y,int r){
        location = new Point(x,y);
        this.r = r;
    }
    // 实现Shape中约定的方法
    @Override
    public double area() {
        return Math.PI * r * r;
    }
    // 实现Shape中约定的方法
    @Override
    protected boolean contains(int x, int y) {
        return this.location.distance(x,y) <= r;
    }
}
