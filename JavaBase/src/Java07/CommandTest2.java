package Java07;

/**
 * @author kenshin
 * @date 2018/5/21 下午5:15
 */
public class CommandTest2 {

    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] arr = {3, -4, 6, 4};
        //处理数组，具体处理行为 取决于匿名内部类
        pa.process(arr, (int[] target) -> {

            int sum = 0;
            for (int tmp: target) {
                sum = sum + tmp;
            }
            System.out.println("数据元素的总和是: " + sum);
        });
    }

}
