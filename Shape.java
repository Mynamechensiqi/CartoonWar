package com;

import java.awt.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName Shape
 * @date 2019/8/15
 * @description 抽象方法 计算圆的面积
 **/
public abstract class Shape {
    protected Point location;
    public abstract double area();
    public boolean contains(Point p){
        return contains(p.x,p.y);
        
    }

    protected abstract boolean contains(int x, int y);
}

