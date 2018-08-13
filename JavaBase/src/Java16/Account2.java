package Java16;

/**
 * @author kenshin
 * @date 2018/6/1 下午2:33
 */
public class Account2 {
    private String accountNo;
    private double balance;

    //标识账户中是否已有存款
    private boolean flag = false;
    public Account2(){};

    //构造器
    public Account2(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance   = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    //因为账户余额不允许随便修改，所以只为balance提供getter方法
    public double getBalance() {
        return balance;
    }

    public synchronized void draw(double drawAccount){
        try{
            //如果flag==false 表明账户中还没有人存钱进去 取钱方法阻塞
            if (!flag){
                wait();
            }
            else {
                //执行取钱操作
                System.out.println(Thread.currentThread().getName() + "取钱: " + drawAccount);
                balance = balance - drawAccount;
                System.out.println("账户余额为：" + balance);
                flag = false;
                //唤醒其他线程
                notifyAll();
            }
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount){
        try{
            //如果flag == true 表明账户中已有人存钱，存钱方法阻塞
            if (flag){
                wait();
            }
            else{
                //执行存钱操作
                System.out.println(Thread.currentThread().getName() + "存款: " + depositAmount);
                balance = balance + depositAmount;
                System.out.println("账户余额为：" + balance);
                flag = true;
                //唤醒其他线程
                notifyAll();
            }
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
