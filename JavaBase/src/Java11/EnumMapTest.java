package Java11;

import java.util.EnumMap;

/**
 * @author kenshin
 * @date 2018/5/24 上午10:21
 */
public class EnumMapTest {

    public static void main(String[] args) {
        EnumMap enumMap = new EnumMap(Season.class);
        enumMap.put(Season.SUMMER, "夏日炎炎");
        enumMap.put(Season.SPRING, "春暖花开");
        System.out.println(enumMap);
    }

}

enum Season{
    SPRING,SUMMER,FALL,WINTER;
}
