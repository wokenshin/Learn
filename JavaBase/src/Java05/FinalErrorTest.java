package Java05;

/**
 * @author kenshin
 * @date 2018/5/21 上午9:17
 */
public class FinalErrorTest {

    //如果打算在构造器/初始化块中对 final 修饰的成员变量进行初始化，则不要在初始化之前就访问成员变量的值
    //定义一个final修饰的实例变量
    //系统不会为final修饰的实例变量进行默认初始化
    final int age;
    {
        //age没有初始化 所以此处的代码将引起错误
        //System.out.println(age);
        age = 6;
        System.out.println(age);
    }

    public static void main(String[] args) {
        new FinalErrorTest();
    }
}
