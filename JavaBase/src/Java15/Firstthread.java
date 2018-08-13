package Java15;

/**
 * @author kenshin
 * @date 2018/5/31 下午2:45
 */
public class Firstthread extends Thread {

    private int i;

    //重写run方法 run方法的方法体就是线程执行体

    @Override
    public void run() {
        for (; i < 100; i++) {
            //当线程类继承Thread类时，直接使用this即可获取当前线程
            //Thread对象的getName返回当前线程的名字
            //因此可以直接调用getName方法返回当前线程的名字
            System.out.println(this.getName() + "--->" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //调用Thread的currentThread方法获取当前线程
            System.out.println(Thread.currentThread().getName() + "  " + i);
            if (i == 20){
                //创建并启动第一个线程
                new Firstthread().start();

                //创建并启动第二个线程
                new Firstthread().start();
            }
        }
    }
}
