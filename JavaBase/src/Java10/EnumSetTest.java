package Java10;

import java.util.EnumSet;

/**
 * @author kenshin
 * @date 2018/5/23 上午9:50
 */
public class EnumSetTest {

    public static void main(String[] args) {
        //创建一个EnumSet集合，集合元素就是Season枚举类的全部枚举值
        EnumSet el1 = EnumSet.allOf(Season.class);
        System.out.println(el1);

        //创建一个空集合，指定其集合元素是Season的枚举值
        EnumSet el2 = EnumSet.noneOf(Season.class);
        System.out.println(el2);

        //手动添加两个元素
        el2.add(Season.WINTER);
        el2.add(Season.SPRING);
        System.out.println(el2);

        //以指定枚举值创建EnumSet集合
        EnumSet el3 = EnumSet.of(Season.SUMMER, Season.WINTER);
        System.out.println(el3);

        EnumSet el4 = EnumSet.range(Season.SUMMER, Season.WINTER);
        System.out.println(el4);

        //新创建的EnumSet集合元素和el4有相同的类型
        EnumSet el5 = EnumSet.complementOf(el4);//补集
        System.out.println(el5);
    }
}

enum Season{
    SPRING, SUMMER, FALL, WINTER;
}