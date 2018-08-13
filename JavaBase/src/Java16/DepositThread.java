package Java16;

/**
 * @author kenshin
 * @date 2018/6/1 下午2:52
 */
public class DepositThread extends Thread {
    private Account2 account;
    private double drawAmount;
    public DepositThread(String name, Account2 account, double drawAmount){
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    //执行存钱 100 次
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.deposit(drawAmount);
        }
    }
}
