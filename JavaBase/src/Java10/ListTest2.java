package Java10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/23 上午10:41
 */
public class ListTest2 {

    public static void main(String[] args) {
        List books = new ArrayList();
        books.add("鸣人");
        books.add("佐助");
        books.add("小樱");
        System.out.println(books);

        //删除集合中的A对象 将导致第一个元素被删除
        books.remove(new A());
        System.out.println(books);

        //删除集合中的A对象 再次致第一个元素被删除
        books.remove(new A());
        System.out.println(books);
    }
}


class A{

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
