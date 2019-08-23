import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName UserTest2
 * @date 2019/8/23
 * @description 反序列化
 **/
public class UserTest2 {
    public static void main(String[] args) {
        reSerializable("D:\\1\\java.txt");
    }
    public static void reSerializable(String pathName){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(pathName);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            if (o instanceof User){
                User user = (User)o;
                System.out.println(user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (null != ois){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fis){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
