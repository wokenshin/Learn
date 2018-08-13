package Java05;

/**
 * @author kenshin
 * @date 2018/5/21 上午9:24
 */
public class FinalLocalVariableTest {

    //final 修饰 局部变量，形参
    public void test(final int a){//因为final修饰的是形参，所以初始值由具体传入的参数决定 比如 test(5);
        //不能对final修饰的形参赋值，下面语句非法
//        a = 5;
    }



    public static void main(String[] args) {

        //定义 final 修饰的局部变量 str 时，指定默认值，则str变量无法重新赋值
        final String str = "Hello";
        //下面赋值语句非法
        //str = "Java";

        //定义 final局部变量时没有指定默认值，则d变量可被赋值一次;
        final double d;
        d = 5.6;
        //非法
        //d = 5.5;

    }
}
