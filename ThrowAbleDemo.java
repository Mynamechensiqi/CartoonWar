import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName ThrowAbleDemo
 * @date 2019/8/21
 * @description
 **/
public class ThrowAbleDemo {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader(new File("D:/hello1.txt"));
            System.out.println("hello");
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }
}
