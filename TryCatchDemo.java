/**
 * @author chensiqi
 * @version 1.0
 * @ClassName TryCatchDemo
 * @date 2019/8/21
 * @description
 * 经典笔试题目
 * 如下程序执行结果是什么
 **/
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println(test(null)+","+test("0")+","+test(""));
    }
    public static int test(String str){
        try{
            // 会出现空指针异常
            return str.charAt(0)-'0';
        }catch (NullPointerException e){
            // 打印异常
            e.printStackTrace();
            return 1;
        }catch (RuntimeException e){
            e.printStackTrace();
            return 2;
        }catch (Exception e){
            e.printStackTrace();
            return 3;
        }finally {
            return 4;
        }
    }
}
