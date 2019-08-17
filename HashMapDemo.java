package text1;

import java.util.HashMap;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName HashMapDemo
 * @date 2019/8/16
 * @description Map集合
 **/
public class HashMapDemo {
    // key存用户名 value存放购买信息 放一件商品
    public static void main(String[] args) {
        HashMap<String, Product> hashMap = new HashMap<>();
        hashMap.put("小明",new Product(100,"汽车",122F));
        System.out.println(hashMap);

        // 是否包含key，是否包含value
        // containsKey  containsValue
        boolean containsKey = hashMap.containsKey("小明");
        System.out.println(containsKey);
        boolean containsValue = hashMap.containsValue(120);
        System.out.println(containsValue);

        // 根据键获取值
        Product product = hashMap.get("小明");
        System.out.println(product);
        System.out.println();

        // putAll
        HashMap<String, Product> hashMap2 = new HashMap<>();
        hashMap2.put("小红",new Product(101,"积木",156F));
        hashMap2.put("小白",new Product(102,"衣服",256F));
        hashMap.putAll(hashMap2);
        System.out.println(hashMap);
        System.out.println();

        // remove
        Product remove = hashMap.remove("小红");
        System.out.println(remove);
        System.out.println(hashMap);
        System.out.println();

        // replace
        hashMap.replace("小明",new Product(110,"玩具",220F));
        System.out.println(hashMap);

        System.out.println(hashMap.size());
    }
}

