package Java05;

/**
 * @author kenshin
 * @date 2018/5/19 下午5:14
 */
public class SingletonDemo {

    //使用一个类变量来缓存曾经创建的实例
    private static SingletonDemo instance;

    //对构造器使用privete修饰 隐藏该构造器
    private SingletonDemo(){}

    //提供一个静态方法 用于返回 SingletonDemo 实例
    public static SingletonDemo getInstance(){
        //如果 instance == null 则表明还不曾创建过 SingletonDemo 对象
        //如果 instance != null 说明先前创建过 SingletonDemo 对象
        //将不会重新创建新的实例
        if (instance == null){
            instance = new SingletonDemo();
        }
        return instance;
    }


    public static void main(String[] args) {

        SingletonDemo s1 = SingletonDemo.getInstance();
        SingletonDemo s2 = SingletonDemo.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);

    }

}
