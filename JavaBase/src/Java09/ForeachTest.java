package Java09;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author kenshin
 * @date 2018/5/22 下午3:52
 */
public class ForeachTest {

    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add("kenshin");
        books.add("naruto");
        books.add("hanamichi");

        for (Object obj:books) {
            String str = (String)obj;
            System.out.println(str);
            if (str.equals("kenshin")){
                books.remove(str);//ConcurrentModificationException
            }
        }
    }
}
