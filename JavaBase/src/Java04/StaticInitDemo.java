package Java04;

/**
 * @author kenshin
 * @date 2018/5/19 上午11:17
 */
public class StaticInitDemo {

    public static void main(String[] args) {
        //静态初始化块
        new Leaf();
        new Leaf();
    }
}

class Root{

    static{
        System.out.println("Root 的静态初始化块");
    }

    {
        System.out.println("Root 的普通初始化块");
    }

    public Root(){
        System.out.println("Root 的无参构造函数");
    }

}

class Mid extends Root{

    static{
        System.out.println("Mid 的静态初始化块");
    }

    {
        System.out.println("Mid 的普通初始化块");
    }

    public Mid(){
        System.out.println("Mid 的无参构造函数");
    }

    public Mid(String msg){
        //通过this调用通一个类中重载的构造器
        this();
        System.out.println("Mid 的带参数构造器 参数是：" + msg);
    }

}

class Leaf extends Mid{

    static{
        System.out.println("Leaf 的静态初始化块");
    }

    {
        System.out.println("Leaf 的普通初始化块");
    }

    public Leaf(){
        //通过super调用父类中一个有字符串参数的构造器
        super("kenshin I love you ");
        System.out.println("Leaf 的无参构造函数");
    }
}
