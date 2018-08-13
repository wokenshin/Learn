package Java09;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author kenshin
 * @date 2018/5/22 下午3:58
 */
public class PredicateTest {

    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("秘密花园");
        books.add("我亲爱的甜橙树");
        books.add("番茄工作法");
        books.add("时间管理");
        books.add("学习之道");

        //视同Lembda表达式（目标类型Predicate）过滤集合
        books.removeIf(ele -> ((String)ele).length() < 5);
        System.out.println(books);

    }
}
