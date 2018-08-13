package Java05;

/**
 * @author kenshin
 * @date 2018/5/21 上午8:49
 */
public class FinalDemo {

    //定义成员变量时 指定默认值
    final int a = 6;

    //下面变量将在 构造器 or 初始化块 中分配初始值
    final String str;
    final int c;
    final static double d;

    //既没有指定默认值，又没有在初始化块/构造器中指定初始化
    //下面定义的ch实例变量是不合法的
    //final char ch；
    //初始化块，可对没有指定默认值的实例变量指定初始值
    {
        //在初始化块中为实例变量指定初始值，合法
        str = "Hello";

        //定义a 实例变量时已经指定类默认值 6 因此下面的赋值语句是非法的
        //a = 9;

    }

    //静态初始化块，可对没有指定默认值的类变量指定初始值
    static{
        //在静态初始化块中 为类变量指定初始值 合法
        d = 5.6;

    }

    //构造器，可对既没有指定默认值，有没有在初始化块中指定初始值的实例变量指定初始值
    public FinalDemo(){
        //如果在初始化块中已经对str指定类初始值
        //那么在构造器中不能对final变量重新赋值，下面的语句非法
        //str = "kenshin";
        c = 5;

    }

    public void changeFinal(){
        //普通方法不能为final修饰的成员变量赋值
        //d = 1.2;
        //不能在普通方法中为成员变量指定初始值
        //ch = 'a';
    }

    public static void main(String[] args) {
        //final 修饰 类，变量，方法 用于表示它修饰的类，变量，方法 不可改变
        FinalDemo f = new FinalDemo();
        System.out.println(f.a);
        System.out.println(f.c);
        System.out.println(f.d);
        System.out.println(f.str);
    }

}
