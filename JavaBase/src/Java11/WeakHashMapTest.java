package Java11;


import java.util.WeakHashMap;

/**
 * @author kenshin
 * @date 2018/5/24 上午9:49
 */
public class WeakHashMapTest {

    public static void main(String[] args) {
        WeakHashMap whm = new WeakHashMap();
        //三个key都是匿名字符串对象（没有其他引用）
        whm.put(new String("语文"), new String("良好"));
        whm.put(new String("数学"), new String("及格"));
        whm.put(new String("英语"), new String("中等"));

        //向 whm中添加一个 健值对
        //该key是一个系统缓存的字符串对象
        whm.put("Java", new String("中等"));
        System.out.println(whm);

        //通知系统立即进行垃圾回收
        System.gc();
        System.runFinalization();

        //通常情况下将之看到 一个 健值对
        System.out.println(whm);
    }
}
