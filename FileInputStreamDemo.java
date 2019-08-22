import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName FileInputStreamDemo
 * @date 2019/8/22
 * @description 字节输入流
 **/
public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:/1/chen.txt");
            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = fis.read(buffer)) != -1){
                String string = new String(buffer,0,len);
                System.out.println(string);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
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
