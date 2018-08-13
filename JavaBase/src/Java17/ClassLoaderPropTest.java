package Java17;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author kenshin
 * @date 2018/6/2 下午3:41
 */
public class ClassLoaderPropTest {

    public static void main(String[] args) throws IOException {
        //获取系统类加载器
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + systemLoader);

        Enumeration<URL> em1 = systemLoader.getResources("");
        while (em1.hasMoreElements()){
            System.out.println(em1.nextElement());
        }
        //获取系统类的加载器的父类加载器，得到扩展类加载器
        ClassLoader extensionLader = systemLoader.getParent();
        System.out.println("扩展类加载器：" + extensionLader);
        System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的parent：" + extensionLader.getParent());

    }
}
