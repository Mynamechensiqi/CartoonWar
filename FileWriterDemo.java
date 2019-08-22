import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName FileWriterDemo
 * @date 2019/8/22
 * @description 字符输出流
 **/
public class FileWriterDemo {
    public static void main(String[] args) {
        fileWriter("D:/1/si.txt");
    }

    public static void fileWriter(String pathName){
        try {
            FileWriter fw = new FileWriter(pathName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("大只儿");
            bw.newLine();
            bw.write("小巴狗");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
