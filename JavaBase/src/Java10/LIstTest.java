package Java10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/23 上午10:30
 */
public class LIstTest {

    public static void main(String[] args) {
        List books = new ArrayList();
        books.add("樱木花道");
        books.add("流川枫");
        books.add("宫城良田");
        books.add("三井寿");
        System.out.println(books);

        //将新字符串插入到第二个位置
        books.add(1,"赤木晴子");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }

        //删除第三个元素
        books.remove(2);
        System.out.println(books);

        //判断指定元素在集合中的位置 输出1 表明在第二的位置
        System.out.println(books.indexOf("赤木晴子"));

        //将第二个元素替换成新的字符串
        books.set(1, "彩子");
        System.out.println(books);

        //将books中 [2,3)截取成子集
        List subBooks = books.subList(2, 3);
        System.out.println(subBooks);
    }
}
