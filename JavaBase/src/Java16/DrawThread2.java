package Java16;

/**
 * @author kenshin
 * @date 2018/6/1 下午2:49
 */
public class DrawThread2 extends Thread{

    //模拟用户账户
    private Account2 account;
    //当前取钱线程所希望取的钱数
    private double drawAmount;
    public DrawThread2(String name, Account2 account, double drawAmount){
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    //重复100次 执行取钱操作
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.draw(drawAmount);
        }
    }


}
