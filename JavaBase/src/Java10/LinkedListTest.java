package Java10;

import java.util.LinkedList;

/**
 * @author kenshin
 * @date 2018/5/23 下午2:22
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList books = new LinkedList();
        //将字符串元素加入到队列的尾部
        books.offer("疯狂Java讲义");

        //将一个字符串元素加入到栈的顶部
        books.push("轻量级JavaEE企业应用实战");

        //将字符串元素添加到队列的头部
        books.offerFirst("疯狂Android讲义");

        //以list的方式（按索引访问的方式）来遍历集合元素
        for (int i = 0; i < books.size(); i++) {
            System.out.println("遍历中：" + books.get(i));
        }

        //访问并不删除栈订的元素
        System.out.println(books.peekFirst());
        //访问并不删除队列的最后一个元素
        System.out.println(books.peekLast());

        //将栈顶的元素弹出栈
        System.out.println(books.pop());
        //下面输出将看到队列中第一个元素被删除
        System.out.println(books);

        //访问并删除队列中的最后一个元素
        System.out.println(books.pollLast());
        System.out.println(books);
    }
}
