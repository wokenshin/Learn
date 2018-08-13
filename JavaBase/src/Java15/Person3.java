package Java15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author kenshin
 * @date 2018/5/31 上午10:20
 */
public class Person3 implements Serializable {

    private String name;
    private transient int age;

    //注意此处没有提供无参数的构造器
    public Person3(String name, int age){
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

    private void writeObject(ObjectOutputStream out) throws IOException {
        //将name实例变量值反转后写入二进制流
        out.writeObject(new StringBuilder(name).reverse());
        out.writeObject(age);
    }

    private void readObject(ObjectInputStream in) throws  IOException, ClassNotFoundException{
        //将读取的字符串反转后赋给name实例变量
        this.name =  ((StringBuilder)in.readObject()).reverse().toString();
        this.age  = in.readInt();
    }

}
