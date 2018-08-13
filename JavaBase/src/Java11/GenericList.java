package Java11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/24 下午2:59
 */
public class GenericList {
    public static void main(String[] args) {
        //创建一个只想保存字符串的List集合
        List<String> strList = new ArrayList<String>();
        strList.add("政府单位");
        strList.add("人民教师");

        //不小心把一个 Integer对象 "丢"进了集合
        //下面代码将引起编译错误
//        strList.add(5);
        strList.forEach(str -> System.out.println(str.length()));
    }
}
