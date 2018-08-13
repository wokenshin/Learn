package Java10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/23 上午10:49
 */
public class ListTest3 {

    public static void main(String[] args) {
        List books = new ArrayList();
        books.add("1234");
        books.add("123");
        books.add("12");
        books.add("1");

        //使用目标类型为Comparator的lambda表达式对list集合排序
        books.sort((o1,o2) -> ((String)o1).length() - ((String)o2).length());
        System.out.println(books);

        //使用UnaryOperator的Lembad表达式来替换结合中所有元素
        //该Lembda表达式控制使用每个字符串的长度作为新的集合元素
        books.replaceAll(ele -> ((String)ele).length());
        System.out.println(books);

    }
}
