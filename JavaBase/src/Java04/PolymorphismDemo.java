package Java04;

import javax.security.auth.Subject;

/**
 * @author kenshin
 * @date 2018/5/19 上午8:35
 */
public class PolymorphismDemo {

    //多态性
    static void ploTest01(){
        //下面编译时类型和运行时类型完全一样
        Base b = new Base();
        //输出6
        System.out.println(b.book);

        //下面两次调用执行 Base类的方法
        b.baseFunc();
        b.test();

        System.out.println("——————————————————————————————————————————————————————————————————————————————");

        //下面编译时类型和运行时类型完全一样 因此不存在多态
        SubClass s = new SubClass();
        System.out.println(s.book);
        s.baseFunc();
        s.test();//执行当前类的test方法

        System.out.println("——————————————————————————————————————————————————————————————————————————————");

        //下面编译时和运行时类型不一样，出现多态
        Base plo = new SubClass();
        //输出6表明访问的是父类对象的实例
        System.out.println(plo.book);
        plo.baseFunc();
        //下面调用将执行当前类的test方法
        plo.test();
        //因为plo的编译时类型是Base
        //Base类没有提供给sub方法，所以下面的代码在编译时出现错误
//        plo.sub;
    }

    //强制类型转换
    static void ConversionTest(){

        double d = 13.4;
        long l   = (long)d;
        System.out.println(l);
        int in   = 5;
        //视图将一个数值类型转还成boolean类型，下面代码编译出错
        //boolean b = (boolean)in;
        Object obj = "hello";
        //obj的编译类型为Object， Object与String存在继承关系，可以强制类型转换
        //而且由于obj变量的实际类型是String 所以运行时也可通过
        String objStr = (String)obj;
        System.out.println(objStr);

        //定义一个objPri变量，编译时类型为Object 运行时类型为Integer
        Object objPri = new Integer(5);
        //因为 两者类型存在继承关系 所以可以强制类型转换，
        //但是右边的实际类型不是String 所以下面的代码运行时 出现ClassCastException异常
//        String objStr2 = (String)objPri;

        //判断一下类型 是否可以转换 就可以避免 这样的异常出现了
        if (objPri instanceof String){
            String objStr2 = (String)objPri;
        }
    }

    static void instanceofDemo(){

        //instanceof 用于判断 当前的对象是否是右边的类or子类

        //声明hellp时使用Object类型 则hello的编译类型是Object
        //Object是所有类型的父类 但hello的实际类型是String
        Object hello = "Hello";
        //等式两边类型存在继承关系 可以使用 instanceof运算
        System.out.println("字符串是否是Object类的实例 " + (hello instanceof Object));
        System.out.println("字符串是否是String类的实例 " + (hello instanceof String));
        //Math与obj类存在继承关系可以进行 instanceof运算
        System.out.println("字符串是否是Math类的实例 " + (hello instanceof Math));

        //String 实现类 Comparable接口 所以返回true
        System.out.println("字符串是否是Comparable类的实例 " + (hello instanceof Comparable));

        String a = "Hello";
        //String 与 Math 没有继承关系 所以下面的代码编译无法通过
//        System.out.println("字符串是否是Math类的实例 " + (a instanceof Math));
    }


    //多态性
    public static void main(String[] args) {
        //ploTest01();
        //ConversionTest();
        instanceofDemo();



    }

}

class Base{

    public int book = 6;
    public void baseFunc(){
        System.out.println("父类的普通方法");
    }

    public void test(){
        System.out.println("父类被覆盖的方法");
    }

}

class SubClass extends Base{

    //重新定义一个book实例变量 隐藏父类的实例变量
    public String book = "kenshin";

    public void test(){
        System.out.println("子类覆盖父类的方法");
    }

    public void sub(){
        System.out.println("子类的普通方法");
    }


}

