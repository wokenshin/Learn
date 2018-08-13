package Java05;

/**
 * @author kenshin
 * @date 2018/5/21 上午10:02
 */
public class FinalMethodTest {

    public final void test(){}

    private final void test2(){}

    public static void main(String[] args) {

    }

}

class Sub extends FinalMethodTest{

    //下面方法将出现编译错误，不能重写final方法
    //public void test(){}

    public void test2(){}
}
