package Java11;

import java.util.IdentityHashMap;

/**
 * @author kenshin
 * @date 2018/5/24 上午10:10
 */
public class IdentityHashMapTest {

    public static void main(String[] args) {
        IdentityHashMap ihm = new IdentityHashMap();
        //添加两个健值对
        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 90);

        //下面两行代码只会向IdentityHashMap中添加一个健值对
        ihm.put("Java", 100);
        ihm.put("Java", 100);
        System.out.println(ihm);

    }
}
