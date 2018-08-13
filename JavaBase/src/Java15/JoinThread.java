package Java15;

/**
 * @author kenshin
 * @date 2018/5/31 下午4:53
 */
public class JoinThread extends Thread {

    //提供一个有参数的构造器 用于设置该线程的名字
    public JoinThread(String threadName){
        super(threadName);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动子线程
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20){
                JoinThread jt = new JoinThread("被Join的线程");
                jt.start();
                //main线程调用了jt线程的join方法，main线程必须等jt线程执行结束之后才会继续执行
                jt.join();
            }
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}
