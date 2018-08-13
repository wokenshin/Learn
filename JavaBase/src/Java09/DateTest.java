package Java09;

import java.util.Date;

/**
 * @author kenshin
 * @date 2018/5/22 下午2:34
 */
public class DateTest {

    public static void main(String[] args) {
        Date d1 = new Date();
        //获取当前时间之后100ms的时间
        Date d2 = new Date(System.currentTimeMillis() + 100);
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.before(d2));
        System.out.println(d1);
    }
}
