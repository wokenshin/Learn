package Java02;

/**
 * @author kenshin
 * @date 2018/5/18 上午10:38
 */
public class OverloadFunc {

    public static void test(){
        System.out.println("test func");
    }

    public static void test(String content){
        System.out.println("重载 test func " + content);
    }


    public static void main(String[] args){
        //方法重载
        //下面定义了2个test方法，但方法的形参列表不同
        //系统可以区分这两个方法，这叫做方法的重载
        test();
        test("kenshin");

    }


}
