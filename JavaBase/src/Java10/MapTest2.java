package Java10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kenshin
 * @date 2018/5/23 下午3:22
 */
public class MapTest2 {

    public static void main(String[] args) {
        Map map = new HashMap();
        //成对放入多个key-value
        map.put("疯狂Java讲义", 109);
        map.put("疯狂iOS讲义",  99);
        map.put("疯狂Ajax讲义", 79);

        //尝试替换key为"疯狂XML讲义"的value，由于原map中没有对应的key，因此map没有改变 不会添加新的 key-value
        map.replace("疯狂XML讲义", 66);
        System.out.println(map);

        //使用原value与传入参数计算出的结果覆盖原有的value
        map.merge("疯狂iOS讲义", 10, (oldVa, param) -> (Integer)oldVa + (Integer)param);
        System.out.println(map);//疯狂iOS讲义的 value 增大来 10

        //当key为"Java"对应的value为null或不存在时，使用计算的结果作为新value
        map.computeIfAbsent("Java", (key) -> ((String)key).length());
        System.out.println(map);//map中 新增来 "Java=4"

        //当key为 Java 对应的 value存在时，使用计算的结果作为新value
        map.computeIfPresent("Java", (key, value) -> (Integer)value * (Integer)value);
        System.out.println(map);

    }
}
