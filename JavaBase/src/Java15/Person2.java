package Java15;

/**
 * @author kenshin
 * @date 2018/5/31 上午10:06
 */
public class Person2 {

    private String name;
    private transient int age;

    //注意此处没有提供无参数的构造器
    public Person2(String name, int age){
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
