import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName TestDemo
 * @date 2019/8/23
 * @description
 **/
public class TestDemo {
    public static void main(String[] args) {
        checkCount("D:\\精英8班\\java\\20190823\\IP.txt");
    }
    public static void checkCount(String pathName){
        FileReader fr = null;
        BufferedReader br = null;
        HashMap<String, Integer> map = new HashMap<>();
        try {
            fr = new FileReader(pathName);
            br = new BufferedReader(fr);
            String str = null;
            while(null != (str = br.readLine())){
                if (!map.containsKey(str)){
                    map.put(str,1);
                }else{
                    map.put(str,map.get(str)+1);
                }
            }
            System.out.println(map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
