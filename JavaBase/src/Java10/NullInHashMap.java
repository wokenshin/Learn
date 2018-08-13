package Java10;

import java.util.HashMap;

/**
 * @author kenshin
 * @date 2018/5/23 下午3:56
 */
public class NullInHashMap {

    public static void main(String[] args) {
        HashMap hm = new HashMap();
        //试图将两个 key == null 的 健值对 放入 HashMap中
        hm.put(null, null);
        hm.put(null, null);
        hm.put("a",  null);
        System.out.println(hm);
    }
}
