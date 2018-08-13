package Lambda;

import Java14.FunInterface;
import Utils.FXWLog;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 参考 https://www.cnblogs.com/anakin/p/7742779.html
 * @author kenshin
 * @date 2018/7/20 下午3:58
 */
public class LambdaDemo {

    //1. 实现Runnable线程案例
    public static void runnableTest(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8");
            }
        }).start();

        //这里的方式 效果等同于上面
        new Thread(() -> System.out.println("In Java8")).start();

    }

    //3.使用Lambda表达式遍历List集合
    public static void iteratorTest(){

        List<String> friends = Arrays.asList("sakuragi", "kenshin", "naruto" , "katuya");
        for (String name:friends) {
            System.out.println(name);
        }

        FXWLog.pringLine();

        //Lambda
        friends.forEach(name -> System.out.println(name));

//        同上 遍历输出集合元素
//        friends.forEach(System.out::println);

    }

    //4.使用Lambda表达式和函数接口
    public static void test(){
        String []datas = new String[] {"tomoa", "sakuragi","naruto","kenshin",};
        Arrays.sort(datas);
        Stream.of(datas).forEach(param ->     System.out.println(param));



    }


    public static void main(String[] args) {

//        runnableTest();//1. 实现Runnable线程案例

//        iteratorTest();//3.使用Lambda表达式遍历List集合

        test();


    }

}
