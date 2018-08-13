package Java07;

import java.net.CookieManager;

/**
 * @author kenshin
 * @date 2018/5/21 下午4:04
 */
public class CommandTest {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] target = {3, -4, 6, 4};
        //第一次处理数组，具体处理行为取决于PrintCommand
        pa.process(target, new PrintCommand());
        System.out.println("---------------------------------");

        //第二次处理数组，具体处理行为取决于AddCommand
        pa.process(target, new AddCommand());
    }
}

class PrintCommand implements Command{
    @Override
    public void process(int[] args) {
        for (int tmp:args) {
            System.out.println("迭代输出目标数组的元素: " + tmp);
        }
    }
}

class AddCommand implements Command{
    @Override
    public void process(int[] args) {
        int sum = 0;
        for (int tmp: args) {
            sum = sum + tmp;
        }
        System.out.println("数组元素的总和是: " + sum);
    }
}