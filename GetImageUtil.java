package com.neuedu.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName GetImageUtil
 * @date 2019/8/20
 * @description 获取图片的工具类
 **/
public class GetImageUtil {

    // URL
    // 获取图片的方法
    public static Image getImg(String ImgName){
        // 反射
        URL resource = GetImageUtil.class.getClassLoader().getResource("com/neuedu/img/"+ImgName);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

}
