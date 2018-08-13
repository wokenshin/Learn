package Java08;

import java.util.Arrays;
import java.util.Random;

/**
 * @author kenshin
 * @date 2018/5/22 上午11:54
 */
public class RandomTest {

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("rand.nextBoolean() " + rand.nextBoolean());
        byte[] buffer = new byte[16];
        rand.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));

        System.out.println("0.0~1.0 之间的随机数 double：" + rand.nextDouble());
        System.out.println("0.0~1.0 之间的随机数 float：" + rand.nextFloat());
    }
}
