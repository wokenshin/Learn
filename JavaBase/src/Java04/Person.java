package Java04;

/**
 * @author kenshin
 * @date 2018/5/19 上午10:42
 */
public class Person {

    //定义无参数的构造器
    public Person(){
        System.out.println("Person 类的无参数构造器");
    }

    //下面定义一个初始化块
    {
        int a = 6;
        if (a > 4){
            System.out.println("Person初始化块：局部变量a的值大于4");
        }
        System.out.println("Person 的初始化块");
    }

    //定义第二个初始化块
    {
        System.out.println("Person 的第二个初始化块");
    }

    public static void main(String[] args) {

        new Person();
    }

}
