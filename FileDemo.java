import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName FileDemo
 * @date 2019/8/22
 * @description File练习
 **/
public class FileDemo {
    public static void main(String[] args) {
        // 创建
        File file = new File("D:/1/chen.txt");
        File file3 = new File("D:/1/si.txt");
        File file4 = new File("D:/1/qi.txt");
        try {
            file.createNewFile();
            file3.createNewFile();
            file4.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file);
        // 可读
        boolean file1 = file.canRead();
        System.out.println(file1);
        // 可写
        boolean file2 = file.canWrite();
        System.out.println(file2);
        // 删除
        boolean file5 = file4.delete();
        System.out.println(file5);
        // 是否存在
        if (!file4.exists()){
            File file6 = new File("D:/1/qi.txt");
            try {
                boolean newFile = file6.createNewFile();
                System.out.println(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            return;
        }
        // 获取文件名
        String name = file.getName();
        System.out.println(name);
        // 父路径
        String parent = file.getParent();
        System.out.println(parent);
        File parentFile = file.getParentFile();
        System.out.println(parentFile);
        // 路径
        String path = file.getPath();
        System.out.println(path);

        // mkdir 创建一个文件，mkdirs 创建内部多个文件
        File file7 = new File("D:/1/082");
        boolean mkdir1 = file7.mkdir();
        System.out.println(mkdir1);
        File file6 = new File("D:/1/chensiqi/chen/si/qi");
        boolean mkdir = file6.mkdirs();
        System.out.println(mkdir);
        // 重命名
        boolean b = file7.renameTo(new File("D:/1/0822"));
        System.out.println(b);
        // 获取路径名
        String s = file7.toString();
        System.out.println(s);
        // D盘所有文件
        File file8 = new File("D:/");
        String[] list = file8.list();
        System.out.println(Arrays.toString(list));
        // 路径
        File[] files = file8.listFiles();
        System.out.println(Arrays.toString(files));

    }
}
