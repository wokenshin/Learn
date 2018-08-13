package Java16;

/**
 * @author kenshin
 * @date 2018/6/1 下午2:56
 */
public class DrawTest2 {

    public static void main(String[] args) {
        //创建一个账户
        Account2 account = new Account2("kenshin", 0);
        new DrawThread2("取钱勒", account, 800).start();
        new DepositThread("存钱甲", account, 800).start();
        new DepositThread("存钱乙", account, 800).start();
        new DepositThread("存钱丙", account, 800).start();
    }
}
