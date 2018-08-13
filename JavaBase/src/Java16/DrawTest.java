package Java16;

/**
 * @author kenshin
 * @date 2018/6/1 上午9:19
 */
public class DrawTest {
    public static void main(String[] args) {
        //创建一个账户
        Account account = new Account("郑世红", 1000);

        //模拟两个线程对同意个账户取钱
        new DrawThread("甲", account, 800).start();
        new DrawThread("乙", account, 800).start();
    }
}
