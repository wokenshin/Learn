package Java15;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author kenshin
 * @date 2018/5/31 上午9:29
 */
public class ReadTeacher {

    public static void main(String[] args) {

        try(
                //创建一个输入流
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"))){
            //一次读取输入流中的四个对象
            Teacher t1 = (Teacher)ois.readObject();
            Teacher t2 = (Teacher)ois.readObject();
            Person  p  = (Person)ois.readObject();
            Teacher t3 = (Teacher)ois.readObject();

            System.out.println("t1的student和p是否相同：" + (t1.getStudent() == p));
            System.out.println("t2的student和p是否相同：" + (t2.getStudent() == p));
            System.out.println("t2和t3是否相同：" + (t2 ==  t3));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
