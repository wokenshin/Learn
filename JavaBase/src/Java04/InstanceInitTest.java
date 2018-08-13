package Java04;

/**
 * @author kenshin
 * @date 2018/5/19 上午10:49
 */
public class InstanceInitTest {

    {
        a = 6;
    }

    int a = 9;

    public static void main(String[] args) {
        System.out.println(new InstanceInitTest().a);
    }

}
