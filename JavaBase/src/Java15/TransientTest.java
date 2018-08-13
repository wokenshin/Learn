package Java15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author kenshin
 * @date 2018/5/31 上午10:07
 */
public class TransientTest {

    public static void main(String[] args) {
        try(
                //创建一个输出流
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transient.txt"));
                //创建一个输入流
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transient.txt"))){
            Person2 per = new Person2("kenshin", 28);
            //系统将per对象转换成字节流并输出
            oos.writeObject(per);//程序运行到这一行代码会崩溃 暂时不知道为什么
            Person2 p = (Person2)ois.readObject();
            System.out.println(p.getAge());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
