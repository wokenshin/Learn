package Java10;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kenshin
 * @date 2018/5/23 下午3:02
 */
public class MapTest {

    public static void main(String[] args) {
        Map map = new HashMap();
        //成对放入对个 key-value
        map.put("疯狂Java讲义", 109);
        map.put("疯狂iOS讲义",  10);
        map.put("疯狂Ajax讲义", 79);

        //多次放入的 key-value对中 value可以重复
        map.put("轻量级 JavaEE 企业应用实战", 99);

        //放入重复的key时，新的value会覆盖老的value
        //如果新的value覆盖老原有的value，该方法会返回被覆盖的value
        System.out.println(map.put("疯狂iOS讲义", 99));//输出10
        System.out.println(map);

        //判断是否包含指定的key
        System.out.println("是否包含 疯狂iOS讲义 key：" + map.containsKey("疯狂iOS讲义"));

        //判断是否包含指定value
        System.out.println("是否包含值为 99 value：" + map.containsValue(99));

        System.out.println("==============分隔符=================");

        //获取Map集合的所有key组成的集合，通过遍历key来实现遍历所有的 key-value对
        for (Object key:map.keySet()) {
            System.out.println(key + "---->" + map.get(key));
        }

        System.out.println("==============分隔符=================");

        map.remove("疯狂Ajax讲义");
        System.out.println(map);

    }
}
