package Java09;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author kenshin
 * @date 2018/5/22 下午3:32
 */
public class IteratorTest {

    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("kenshin");
        books.add("naruto");
        books.add("hanamichi");

        //获取books集合对应的迭代器
        Iterator it = books.iterator();
        while (((Iterator) it).hasNext()){
            //it.next()方法返回的是Object 所以需要强制类型转换
            String book = (String)it.next();
            System.out.println(book);
            if (book.equals("hanamichi")){
                //从集合中删除上一次next()返回的元素
                it.remove();
            }
        }
        System.out.println(books);
    }
}
