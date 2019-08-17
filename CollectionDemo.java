package test1;

import java.util.*;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName CollectionDemo
 * @date 2019/8/15
 * @description
 **/
public class CollectionDemo {

    public static void main(String[] args) {
        List ac = new ArrayList<>();
        ac.add(67);
        ac.add("chensiqi");
        // 在索引处添加值
        ac.add(0,"lalala");
        System.out.println(ac);

        List<Integer> ac2 = new ArrayList<Integer>();
        ac2.add(35);
        ac2.add(1);
        System.out.println(ac2);
        ac.addAll(ac2);
        System.out.println(ac);
        boolean contains1 = ac.contains(50);
        System.out.println(contains1);

        // clear 清空
        ac.clear();
        System.out.println(ac);

        // contains 判断是否包含
        List<User> arrayList = new ArrayList<User>();
        User user1 = new User("张三", 22);
        User user2 = new User("李四", 23);
        arrayList.add(user1);
        arrayList.add(user2);
        boolean contains = arrayList.contains(user1);
        System.out.println(contains);

        // isEmpty 判断是否为空
        boolean empty = arrayList.isEmpty();
        System.out.println(empty);

        // lastIndexOf 查找最后一次出现次数
        arrayList.add(user1);
        arrayList.add(user1);
        int lastIndexOf = arrayList.lastIndexOf(user1);
        System.out.println(lastIndexOf);

        // remove 根据索引删除和根据内容删除
        // 返回User，要删除的那个人
        User remove = arrayList.remove(0);
        boolean remove1 = arrayList.remove(user2);
        System.out.println(remove);
        System.out.println("1."+remove1);
        System.out.println(arrayList);

        // 排序
        List arrayList1 = new ArrayList<>();
        arrayList1.add(34);
        arrayList1.add(-1);
        arrayList1.add(999);
        arrayList1.add(1);
        Collections.sort(arrayList1);
        System.out.println(arrayList1);

        // sublist() 截取子集合
        List<User> subList = arrayList1.subList(0, 2);
        System.out.println(subList);

        // toArray() 将集合转为数组
        Object[] array = arrayList1.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println(array.length);
        Object[] array1 = arrayList.toArray();
        System.out.println(Arrays.toString(array1));

        List objects = new ArrayList<>();
        System.out.println(objects.size());


    }
}
