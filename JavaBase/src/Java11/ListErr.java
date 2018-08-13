package Java11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/24 下午2:49
 */
public class ListErr {

    public static void main(String[] args) {
        //创建一个只想保存字符串的List集合
        List strList = new ArrayList();
        strList.add("政府单位");
        strList.add("人民教师");

        //不小心把一个 Integer对象 "丢"进了集合
        strList.add(5);
        strList.forEach(str -> System.out.println(((String)str).length()));

        /**
         * for (int i = 0; i < strList.size(); i++) {
         *             Object obj = strList.get(i);
         *             if (obj.getClass() == String.class){
         *                 System.out.println(obj.toString());
         *             }
         *         }
         * */

    }
}
