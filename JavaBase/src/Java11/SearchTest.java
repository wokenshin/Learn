package Java11;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kenshin
 * @date 2018/5/24 下午2:06
 */
public class SearchTest {


    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);

        System.out.println(nums);
        System.out.println("输出最大元素：" + Collections.max(nums));
        System.out.println("输出最小元素: " + Collections.min(nums));

        //将nums中的 0 使用 1 来代替
        Collections.replaceAll(nums, 0, 1);
        System.out.println(nums);

        System.out.println("判断 -5 在 List集合中出现的次数: " + Collections.frequency(nums, -5));

        //对集合排序
        Collections.sort(nums);
        System.out.println(nums);

        //只有排序后的集合才可以使用二分查找法穿 输出 3
        System.out.println(Collections.binarySearch(nums, 3));
    }
}
