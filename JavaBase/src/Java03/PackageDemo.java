package Java03;


import Java02.PersonDemo;
import static java.lang.System.*;

/**
 * @author kenshin
 * @date 2018/5/18 下午2:50
 */
public class PackageDemo {

    public static void main(String[] args) {
//        Java02.PersonDemo p = new Java02.PersonDemo();
        PersonDemo p = new PersonDemo();//这样写 需要 import
        p.setAge(10);
        p.setName("阿呆");
        out.println("your name is " + p.getName() + " age is " + p.getAge());

    }
}
