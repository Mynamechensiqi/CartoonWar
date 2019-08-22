import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName FileOutputStreamDemo
 * @date 2019/8/22
 * @description 字节输出流
 **/
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:/1/si.txt",true); // true追加
            String string = "ilovejava";
            fos.write(string.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
