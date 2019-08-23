import java.io.IOException;
import java.util.Properties;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName ConstantDemo
 * @date 2019/8/23
 * @description properties
 **/
public class ConstantDemo {

    public static final Integer GAME_WIDTH = Integer.parseInt(getValByKey("GAME_WIDTH"));

    public static void main(String[] args) {
        System.out.println(GAME_WIDTH);
    }
    public static String getValByKey(String Key){
        Properties properties = new Properties();
        try {
            properties.load(Object.class.getResourceAsStream("/setting.properties"));
            String key = (String)properties.get(Key);
            return key;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
