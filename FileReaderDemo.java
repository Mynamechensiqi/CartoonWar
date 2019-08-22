import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName FileReaderDemo
 * @date 2019/8/22
 * @description 字符输入流
 **/
public class FileReaderDemo {
    public static void main(String[] args){
        fileReader("D:/1/qi.txt");
    }
    public static void fileReader(String pathName){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(pathName);
            // 缓冲流
            br = new BufferedReader(fr);
            String str = "";
            while(null != (str=br.readLine())){
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fr){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
