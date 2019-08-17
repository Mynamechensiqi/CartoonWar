package com;

import javax.swing.*;
import java.awt.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName ShapeDemo
 * @date 2019/8/15
 * @description
 **/
public class ShapeDemo {
    public static void main(String[] args){
        // Shape shape = new Shape();
        // 错误，不能直接创建抽象类的实例
        // 变量可以是抽象的，对象必须是具体的
        // 代词可以是抽象的，东西必须是具体的
        Shape s = new Circle(5, 6, 4);
        Point p = new Point(7, 8);
        System.out.println(s.area());
        System.out.println(s.contains(p));
    }
}
