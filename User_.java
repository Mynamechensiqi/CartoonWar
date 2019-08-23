import java.io.Serializable;

/**
 * @author chensiqi
 * @version 1.0
 * @ClassName User_
 * @date 2019/8/23
 * @description  测试-用户类
 **/
public class User_ implements Serializable {
    private String name;
    private Integer age;

    public User_() {
    }

    public User_(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User_{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
