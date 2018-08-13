package Java10;

import java.util.LinkedHashMap;

/**
 * @author kenshin
 * @date 2018/5/23 下午4:16
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {

        LinkedHashMap scores = new LinkedHashMap();
        scores.put("语文", 80);
        scores.put("英语", 82);
        scores.put("数学", 76);

        scores.forEach((key, value) -> System.out.println(key + "---->" + value));
    }
}


