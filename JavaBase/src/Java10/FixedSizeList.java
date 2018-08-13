package Java10;

import java.util.Arrays;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/23 上午11:36
 */
public class FixedSizeList {

    public static void main(String[] args) {
        List fixedList = Arrays.asList("阿呆", "阿瓜");

        //获取fixedList的实现类，将输出 Arrays$ArrayList
        System.out.println(fixedList.getClass());

        //使用方法引用遍历集合元素
        fixedList.forEach(System.out::println);

        //视图增加，删除元素都会引发UnsupportedOperationException异常
//        fixedList.add("二狗");
//        fixedList.remove("阿呆");

    }
}
