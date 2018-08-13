package Java10;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author kenshin
 * @date 2018/5/23 上午11:02
 */
public class ListIteratorTest {

    public static void main(String[] args) {
        String[] books = {"秘密花园", "我亲爱的甜橙树", "心是孤独的猎手"};
        List bookList = new ArrayList();
        for (int i = 0; i < books.length; i++) {
            bookList.add(books[i]);
        }

        ListIterator lit = bookList.listIterator();
        while (lit.hasNext()){
            System.out.println(lit.next());
            lit.add("——————————————分隔符——————————");
        }

        System.out.println("===========下面开始反向迭代===========");
        while (lit.hasPrevious()){
            System.out.println(lit.previous());
        }
    }
}
