import java.io.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName Filecopy
 * @date 2019/8/22
 * @description 字符缓复制
 **/
public class Filecopy {
    public static void main(String[] args) {
        fileCopy("D:/1/si.txt","D:/1/qi.txt");
    }
    public static void fileCopy(String pathName1,String pathName2){
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw= null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader(pathName1);
            br = new BufferedReader(fr);
            fw = new FileWriter(pathName2,true);
            bw = new BufferedWriter(fw);
            while(null != br.readLine()){
                bw.newLine();
                bw.write(br.readLine());
                bw.flush();
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
