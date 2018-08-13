package Java09;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author kenshin
 * @date 2018/5/22 下午3:45
 */
public class IteratorErrorTest {

    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("kenshin");
        books.add("naruto");
        books.add("hanamichi");

        Iterator it = books.iterator();
        while (it.hasNext()){
            String book = (String)it.next();
            System.out.println(book);
            if (book.equals("kenshin")){
                //使用迭代器过程中 不可修改集合元素 下面代码引发异常 ConcurrentModificationException
                books.remove("kenshin");
            }
        }
    }
}
