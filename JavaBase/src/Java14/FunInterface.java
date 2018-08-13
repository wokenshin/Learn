package Java14;

/**
 * @author kenshin
 * @date 2018/5/30 上午9:06
 */
@FunctionalInterface
public interface FunInterface {

    static void foo(){
        System.out.println("foo 类方法");
    }

    default void bar(){
        System.out.println("bar 默认方法");
    }

    //只定义一个抽象方法
    void test();

    //再定义一个抽象方法 编译时将会引起错误
    //void abc();
}
