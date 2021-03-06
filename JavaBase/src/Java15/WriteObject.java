package Java15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author kenshin
 * @date 2018/5/31 上午8:56
 */
public class WriteObject {

    public static void main(String[] args) {
        try(
                //创建一个ObjectOutputStream输出流
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))){
            Person per = new Person("孙悟空", 500);
            //将per对象写入输出流
            oos.writeObject(per);
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
