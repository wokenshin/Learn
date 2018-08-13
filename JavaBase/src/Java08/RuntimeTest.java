package Java08;

/**
 * @author kenshin
 * @date 2018/5/22 上午11:08
 */
public class RuntimeTest {

    public static void main(String[] args) {
        //获取Java程序关联的运行时对象
        Runtime rt = Runtime.getRuntime();
        System.out.println("处理器数量：" + rt.availableProcessors());
        System.out.println("空闲内存数：" + rt.freeMemory());
        System.out.println("总内存数：" + rt.totalMemory());
        System.out.println("可用最大内存数：" + rt.maxMemory());
    }
}
