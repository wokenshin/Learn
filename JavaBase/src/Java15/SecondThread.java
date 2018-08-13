package Java15;

/**
 * @author kenshin
 * @date 2018/5/31 下午3:01
 */
public class SecondThread implements Runnable {

    private int i;

    //线程执行体
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            //当线程类实现Runnable接口时，如果想获取当前线程Thread.currentThread()方法
            System.out.println(Thread.currentThread().getName() + "   " + j);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
            if (i == 20){
                SecondThread st = new SecondThread();
                //通过 new Thread(target, name)方法创建新线程
                new Thread(st, "线程1").start();
                new Thread(st, "线程2").start();

            }
        }
    }
}
