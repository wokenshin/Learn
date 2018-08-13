package Java11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kenshin
 * @date 2018/5/24 下午3:08
 */
public class DiamondTest {

    public static void main(String[] args) {
        //Java自动推断出ArrayList的<>里应该是String
        List<String> books = new ArrayList<>();
        books.add("心是孤独的猎手");
        books.add("新人生");
        books.add("当下的力量");

        //遍历集合，集合元素就是String类型
        books.forEach(ele -> System.out.println(ele));

        //Java自动推断出 HashMap的<>里面应该是 String, List<String>
        Map<String, List<String>> schoolsInfo = new HashMap<>();
        //Java自动推断出ArrayList的<>里应该是String
        List<String> schools = new ArrayList<>();
        schools.add("新文小学");
        schools.add("万里小学");
        schools.add("玥珑小学");
        schools.add("遵义六中");
        schools.add("遵义二中");
        schools.add("山东建筑大学");

        schoolsInfo.put("kenshin", schools);
        //遍历map时 map的 key是 String类型 values是 List<String>类型
        schoolsInfo.forEach((key, value) -> System.out.println(key + " -----> " + value));

    }
}
