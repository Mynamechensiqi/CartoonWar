

import java.io.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName FilecopyDemo
 * @date 2019/8/22
 * @description 文件复制
 **/
public class FilecopyDemo {
    public static void main(String[] args) {
        File file1 = new File("D:/1/chen.txt");
        File file2 = new File("D:/1/chen_copy.txt");
        try {
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
