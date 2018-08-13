package Java06;

/**
 * @author kenshin
 * @date 2018/5/21 下午2:18
 */
public interface Output {
    //接口里定义成员变量只能是常量
    int MAX_CACHE_LINE = 50;

    //接口里定义普通方法 只能是 public的抽象方法
    void out();
    void getData(String msg);

    //接口中定义默认方法 需要使用default修饰符
    default void print(String... msgs){
        for (String str:msgs) {
            System.out.println(str);
        }
    }

    default void test(){
        System.out.println("默认的test()方法");
    }

    //在接口中定义类方法 需要使用 static修饰符
    static String staticTest(){
        return "接口里的类方法";
    }
}
