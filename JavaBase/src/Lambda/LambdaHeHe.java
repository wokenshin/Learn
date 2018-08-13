package Lambda;


import java.util.stream.Stream;


/**
 * @author kenshin
 * @date 2018/7/25 上午9:37
 */
public class LambdaHeHe {

    //https://www.cnblogs.com/snowInPluto/p/5981400.html
    public static void main(String[] args) {

        test1();


    }


    private static void test1() {

        int result = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println(result);
        //注意 reduce 的第一个参数，这是一个初始值。0 + 1 + 2 + 3 + 4 = 10

        int result2 = Stream.of(1,2,3,4)
                        .reduce(1, (a, b) -> a*b);
        System.out.println(result2);
        //因为任何数乘以 1 都为其自身嘛。1 * 1 * 2 * 3 * 4 = 24

    }


}
