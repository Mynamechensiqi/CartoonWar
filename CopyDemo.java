import java.io.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName CopyDemo
 * @date 2019/8/23
 * @description
 **/
public class CopyDemo {
    public static void main(String[] args){
    }
    public static void copyDemo(String pathName1,String pathName2){
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader(pathName1);
            br = new BufferedReader(fr);
            fw = new FileWriter(pathName2);
            bw = new BufferedWriter(fw);
            String str = null;
            while(null != (str = br.readLine())){
                bw.write(br.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != bw){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fw){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
