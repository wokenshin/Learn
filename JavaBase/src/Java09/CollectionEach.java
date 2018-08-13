package Java09;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author kenshin
 * @date 2018/5/22 下午3:27
 */
public class CollectionEach {

    public static void main(String[] args) {
        //创建一个集合
        Collection books = new HashSet();
        books.add("kenshin");
        books.add("naruto");
        books.add("hanamichi");
        //调用foreach方法遍历集合
        books.forEach(obj -> System.out.println("迭代集合元素：" + obj));
    }
}
