package Java15;

import java.io.Serializable;

/**
 * @author kenshin
 * @date 2018/5/31 上午8:54
 */
public class Person implements Serializable {

    private String name;
    private int age;
    //注意此处没有提供无参数的构造器
    public Person(String name, int age){
        this.name = name;
        this.age  = age;
        System.out.println("有参数的构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
