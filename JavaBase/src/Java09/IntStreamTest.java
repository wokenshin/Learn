package Java09;

import java.util.stream.IntStream;

/**
 * @author kenshin
 * @date 2018/5/22 下午4:18
 */
public class IntStreamTest {

    public static void main(String[] args) {

        IntStream is = IntStream.builder()
                                .add(20)
                                .add(13)
                                .add(-2)
                                .add(18)
                                .build();

        //下面调用聚集方法的代码每次只能执行一行[下面的代码必须注释掉 但行执行 不然会崩溃]
//        System.out.println("is 所有元素的最大值"     + is.max().getAsInt());
//        System.out.println("is 所有元素的最小值"     + is.min().getAsInt());
//        System.out.println("is 所有元素的总和"       + is.sum());
//        System.out.println("is 所有元素的总数"       + is.count());
//        System.out.println("is 所有元素的平均值"     + is.average());
//        System.out.println("is 所有元素的平方大于20" + is.anyMatch(ele -> ele*ele>20));



        //将is映射成一个新Stream，新Stream的每个元素是原Stream的 2倍+1
        IntStream newIs = is.map(ele -> ele*2+1);
        //使用方法引用的方式来遍历集合元素
        newIs.forEach(System.out::println);

    }

}
