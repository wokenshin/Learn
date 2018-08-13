package Java15;

/**
 * @author kenshin
 * @date 2018/5/31 下午4:44
 */
public class StartDead extends Thread{

    private int i;

    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            System.out.println(getName() + "  " + j);
        }
    }

    public static void main(String[] args) {

        //创建线程对象
        StartDead sd = new StartDead();
        for (int i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            if (i == 20){
                //启动线程
                sd.start();
                //判断启动后线程的isAlive值
                System.out.println("线程的isAlive值: " + sd.isAlive());
            }
            //当线程处于新建、死亡两种状态时，isAlive方法返回false
            //当I>20时，该线程肯定已经启动过了，如果sd.isAlive为假时，那就是死亡状态了
            if (i > 20 && !sd.isAlive()){
                //视图再次启动该线程-此时线程已经死了 会引起 IllegalThreadStateException 异常
                sd.start();
            }

        }

    }
}
