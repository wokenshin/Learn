package Java08;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author kenshin
 * @date 2018/5/22 上午10:35
 */
public class SystemTest {

    public static void main(String[] args) throws Exception{
        //获取系统所有的环境变量
        Map<String, String> env = System.getenv();
        for (String name: env.keySet()) {
            System.out.println(name + " -----> " + env.get(name));
        }

        //获取指定环境变量的值
        System.out.println("获取指定环境变量的值" + System.getenv("JAVA_HOME"));

        //获取所有的系统属性
        Properties props = System.getProperties();
        //将所有的属性保存到props.txt文件中
        props.store(new FileOutputStream("props.txt"), "System Properties");

        //输出特定的属性
        System.out.println(System.getProperty("os.name"));
    }
}
