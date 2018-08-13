package Java11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author kenshin
 * @date 2018/5/24 上午9:00
 */
public class PropertiesTest {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        //添加属性
        props.setProperty("username", "kenshin");
        props.setProperty("password", "313911762");

        //将Properties中的健值对保存到 313911762.ini文件中
        //创建的文件 就在当前工程的根目录下
        props.store(new FileOutputStream("313911762.ini"), "commend line");

        //新建一个对象
        Properties props2 = new Properties();
        props2.setProperty("gender", "male");
        //将313911762.ini文件中的内容追加到props2中
        props2.load(new FileInputStream("313911762.ini"));
        System.out.println(props2);

    }
}
