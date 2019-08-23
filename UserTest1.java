import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName UserTest1
 * @date 2019/8/23
 * @description 序列化
 **/
public class UserTest1 {
    public static void main(String[] args) {
        User user = new User("张三", 12);
        System.out.println(user);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("D:\\1\\java.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != oos){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fos){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
