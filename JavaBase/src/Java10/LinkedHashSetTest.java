package Java10;

import java.util.LinkedHashSet;

/**
 * @author kenshin
 * @date 2018/5/23 上午8:45
 */
public class LinkedHashSetTest {

    public static void main(String[] args) {

        //有顺序的,不允许集合元素重复
        LinkedHashSet books = new LinkedHashSet();
        books.add("剑心");
        books.add("神谷薰");
        System.out.println(books);

        //删除 剑心
        books.remove("剑心");
        //添加 剑心
        books.add("剑心");
        System.out.println(books);

    }
}
