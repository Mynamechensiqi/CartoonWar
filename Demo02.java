/**
 * @author chensiqi
 * @version 1.0
 * @ClassName Demo02
 * @date 2019/8/21
 * @description
 **/

public class Demo02 {
    // 写一个计算圆的面积的方法，传一个半径，返回面积
    public static void main(String[] args) {
        double s=0;
        s = area(-4);
        System.out.println(s);
    }
    public static double area(double r){
        try {
            if(r<=0){
                throw new RuntimeException();  //RuntimeException  运行异常，不会声明，不会处理异常，直接报错并且停止
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        double s=Math.PI*r*r;
        return s;
    }
}
