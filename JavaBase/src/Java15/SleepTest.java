package Java15;


import java.util.Date;

/**
 * @author kenshin
 * @date 2018/5/31 下午5:25
 */
public class SleepTest {

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10; i++) {
            System.out.println("当前时间：" + new Date());
            //调用sleep方法 让当前线程 暂停1s
            Thread.sleep(1000);
        }
    }
}
