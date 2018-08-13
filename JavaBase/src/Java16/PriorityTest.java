package Java16;

/**
 * @author kenshin
 * @date 2018/6/1 上午8:44
 */
public class PriorityTest extends Thread {

    //定义一个有参数的构造器
    public PriorityTest(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + ", 其优先级是: " + getPriority() + " 循环值: " + i );
        }
    }

    public static void main(String[] args) {

        //改变主线程的优先级
        Thread.currentThread().setPriority(6);
        for (int i = 0; i < 30; i++) {
            if (i == 10){
                PriorityTest low = new PriorityTest("- 低级");
                low.start();
                System.out.println("创建之初的优先级：" + low.getPriority());

                //设置线程为最低优先级
                low.setPriority(Thread.MIN_PRIORITY);
            }
            if (i == 20){
                PriorityTest high = new PriorityTest("+ 高级");
                high.start();
                System.out.println("创建之初的优先级：" + high.getPriority());
                //设置线程为最高优先级
                high.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }
}
