package Java15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author kenshin
 * @date 2018/5/31 上午9:24
 */
public class WriteTeacher {

    public static void main(String[] args) {
        try(
                //创建一个输出流
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"))){
            Person per = new Person("孙悟空", 500);
            Teacher t1 = new Teacher("菩提老祖", per);
            Teacher t2 = new Teacher("唐僧", per);

            //一次将四个对象写入输出流
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(per);
            oos.writeObject(t2);
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
