package Java11;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kenshin
 * @date 2018/5/24 上午11:26
 */
public class SortTest {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        arrayList.add(-5);
        arrayList.add(3);
        arrayList.add(0);

        System.out.println(arrayList);
        //将集合数据反转
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        //将集合数据按自然顺序排序
        Collections.sort(arrayList);
        System.out.println(arrayList);

        //将集合元素按随机顺序排序
        Collections.shuffle(arrayList);
        System.out.println(arrayList);


    }
}
