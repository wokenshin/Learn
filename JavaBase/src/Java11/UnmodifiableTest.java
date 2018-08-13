package Java11;

import java.util.*;

/**
 * @author kenshin
 * @date 2018/5/24 下午2:22
 */
public class UnmodifiableTest {

    public static void main(String[] args) {
        //创建一个空的不可改变的List对象
        List unmodifiableList = Collections.emptyList();

        //创建一个只有一个元素且不可改变的 Set对象
        Set unmodifiableSet = Collections.singleton("我要不要考公务员");

        //创建一个普通的Map对象
        Map scores = new HashMap();
        scores.put("iOs", 99);
        scores.put("Java", 40);
        scores.put("日语", 20);
        scores.put("公务员", 10);

        //返回普通的Map对象 对应的不可变版本
        Map unmodifiableMap = Collections.unmodifiableMap(scores);


        //下面任意一行代码将引发 UnsupportedOperationException 异常
//        unmodifiableList.add("test");
//        unmodifiableSet.add("test");
//        unmodifiableMap.put("建筑学", 999);
    }
}
