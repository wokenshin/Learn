package Java15;

import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author kenshin
 * @date 2018/5/31 下午3:38
 */
public class ThirdThread {

    public static void main(String[] args) {
        //创建able对象
        ThirdThread tt = new ThirdThread();
        //先使用Lambda表达式创建Callable<Integer>对象
        //使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() -> {

            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() +  "循环变量i的值: " + i);
            }

            //call方法可以有返回值
            return i;
        });

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "循环变量i的值 " + i);
            if (i == 20){
                //实际还是以Callable对象来创建并启动线程的
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            //获取线程返回值
            System.out.println("子线程的返回值：" + task.get());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
