package Java15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author kenshin
 * @date 2018/5/31 上午9:36
 */
public class SerializeMutable {
    public static void main(String[] args) {
        try(
                //创建一个输出流
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mutable.txt"));
                //创建一个输入流
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mutable.txt"))) {

                Person per = new Person("kenshin", 28);
                //系统将per对象转换成字节序列并输出
                oos.writeObject(per);
                //改变per对象的name属性
                per.setName("希望");
                //系统只是输出序列化编号，所以改变后的name不会被序列化
                oos.writeObject(per);

                Person p1 = (Person)ois.readObject();
                Person p2 = (Person)ois.readObject();
                System.out.println("下面输出true 即反序列化后   p1 == p2 "+ (p1 == p2));
                System.out.println("名字并没有改变："+ p2.getName());
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
