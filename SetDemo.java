package text1;

import java.util.HashSet;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName SetDemo
 * @date 2019/8/16
 * @description
 **/
public class SetDemo {
    public static void main(String[] args) {
        HashSet<Integer> objects = new HashSet<>();
        objects.add(2);
        objects.add(-1);
        objects.add(999);
        objects.add(37);
        objects.add(-100);
        objects.add(4);
        System.out.println(objects);

        HashSet<Person> people = new HashSet<>();
        people.add(new Person("张三",12));
        people.add(new Person("张三",12));
        System.out.println(people);
    }
}
