package Java17;

/**
 * @author kenshin
 * @date 2018/6/2 下午2:39
 */
public class A {
    static int a = 6;
}

class ATest1{
    public static void main(String[] args) {
        A a = new A();
        a.a++;
        System.out.println(a.a);
    }
}

class ATest2{
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.a);
    }
}
