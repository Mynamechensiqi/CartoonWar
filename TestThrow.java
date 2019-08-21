/**
 * @author chensiqi
 * @version 1.0
 * @ClassName TestThrow
 * @date 2019/8/21
 * @description
 **/
public class TestThrow {
    public static void main(String[] args) {
        try {
            //调用带throws声明的方法，必须显式捕获该异常
            //否则，必须在main方法中再次声明抛出
            throwChecked(-3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //调用抛出Runtime异常的方法既可以显式捕获该异常，
        //也可不理会该异常
        throwRuntime(3);
    }
    public static void throwChecked(int a) throws Exception {
        if (a > 0){
            throw new Exception("a的值大于0，不符合要求");
        }
    }
    public static void throwRuntime(int a){
        if (a > 0){
            throw new RuntimeException("a的值大于0，不符合要求");
        }
    }
}
