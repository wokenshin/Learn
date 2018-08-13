package Java07;

/**
 * @author kenshin
 * @date 2018/5/21 下午2:57
 */
public class InterfaceExtendsTest {

    public static void main(String[] args) {
        System.out.println(interfaceC.PROP_A);
        System.out.println(interfaceC.PROP_B);
        System.out.println(interfaceC.PROP_C);
    }

}

interface interfaceA{
    int PROP_A = 5;
    void testA();

}

interface interfaceB{
    int PROP_B = 6;
    void testB();
}

interface interfaceC extends interfaceA, interfaceB{
    int PROP_C = 7;
    void testC();
}


