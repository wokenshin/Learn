package Java15;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * @author kenshin
 * @date 2018/5/31 上午9:02
 */
public class ReadObject {

    public static void main(String[] args) {
        try(
            //创建一个ObjectInputStream输入流
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))){
            //从输入流中读取一个java对象，并将起强制类型转换为Person类
            Person per = (Person)ois.readObject();
            System.out.println("名字：" + per.getName() +  "年龄：" + per.getAge());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
