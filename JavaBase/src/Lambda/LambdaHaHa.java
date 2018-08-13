package Lambda;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * @author kenshin
 * @date 2018/7/24 上午8:38
 */
public class LambdaHaHa {

    private boolean s;

    private static void defaultTest() {

        //接口泛型类 引用 = 返回值 -> 表达式()
        //右边的Lambda表达式 相当于实现了 接口中的方法
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);

        //这里的converter.convert("123")中的convert("123")会调用上面的Lambda表达式
        Integer converted = converter.convert("123");
        System.out.println(converted);

    }


    public static void predicateTest(){

        Predicate<String> predicate = (mmp) -> mmp.length() > 0;

        boolean a = predicate.test("foo");
        boolean b = predicate.negate().test("foo");

        System.out.println("a " + a);
        System.out.println("b " + b);

    }

    private static void optionTest() {

        Optional<String> optional = Optional.of("kenshin");

        System.out.println(optional.isPresent());
        System.out.println(optional.get());
        System.out.println(optional.orElse("fallBack"));
        
    }

    private static void streamTest() {

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");


        System.out.println("——————————————————————————Filter过滤————————————————————————————————");
        //Filter 过滤
        stringCollection
                .stream()
                .filter(x -> x.startsWith("a"))
                .forEach(r -> System.out.println(r));
        // "aaa2", "aaa1"

        //依然输出全部内容 说面上面的操作并不会修改集合的值
        System.out.println(stringCollection);

        System.out.println("——————————————————————————Sort排序————————————————————————————————");
        //Sort 排序
        stringCollection
                .stream()
                .sorted()
                .filter(a -> a.startsWith("a"))
                .forEach(System.out::println);

        //Map 映射
        /**
         * 中间操作map会将元素根据指定的Function接口来依次将元素转成另外的对象，下面的示例展示了将字符串转换为大写字符串。
         * 你也可以通过map来将对象转换成其他类型，map返回的Stream类型是根据你map传递进去的函数的返回值决定的
         */
        System.out.println("——————————————————————————Map映射————————————————————————————————");
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a,b) -> b.compareTo(a))//按字典顺序比较两个字符串
                .forEach(System.out::println);


        System.out.println("——————————————————————————Match 匹配————————————————————————————————");
        //Match 匹配
        /**
         * Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配整个Stream。所有的匹配操作都是最终操作，并返回一个boolean类型的值
         */
        boolean anyStartsWithA = stringCollection
                                    .stream()
                                    .anyMatch(s -> s.startsWith("a"));

        System.out.println("anyStartsWithA " + anyStartsWithA);

        boolean allStartsWithA = stringCollection
                                    .stream()
                                    .allMatch(s -> s.startsWith("a"));

        System.out.println("allStartsWithA " + allStartsWithA);

        boolean noneStartsWithZ = stringCollection
                                    .stream()
                                    .noneMatch(s -> s.startsWith("z"));

        System.out.println("noneStartsWithZ " + noneStartsWithZ);

        /**
         * Count 计数
         * 计数是一个最终操作，返回Stream中元素的个数，返回值类型是long
         */
        System.out.println("——————————————————————————Count 计数————————————————————————————————");

        long startsWithB = stringCollection.stream()
                                .filter(s -> s.startsWith("b"))
                                .count();

        System.out.println("startsWithB " + startsWithB);

        /**
         * Reduce 规约
         *
         * 这是一个最终操作，允许通过指定的函数来将stream中的多个元素规约为一个元素，规越后的结果是通过Optional接口表示的：
         */
        System.out.println("——————————————————————————Reduce 规约————————————————————————————————");

        Optional<String> reduce = stringCollection
                                        .stream()
                                        .sorted()
                                        .reduce((s1,s2) -> s1 + "#" + s2);

        reduce.ifPresent(System.out::println);

        /**
         * 并行Streams
         *
         * 前面提到过Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。
         * 下面的例子展示了是如何通过并行Stream来提升性能：
         */

        System.out.println("——————————————————————————并行Streams————————————————————————————————");

        //首先我们创建一个没有重复元素的大表：
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {

            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
            
        }

        //然后我们计算一下排序这个Stream要耗时多久，
        //串行排序：
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();

        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));


        //并行排序[要快一半的时间]
        long t2 = System.nanoTime();

        long count2 = values.parallelStream().sorted().count();
        System.out.println(count2);

        long t3 = System.nanoTime();

        long millis2 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("parallel sort took: %d ms", millis2));

        System.out.println("上面两个代码几乎是一样的，但是并行版的快了50%之多，唯一需要做的改动就是将stream()改为parallelStream()");
    }

    private static void streamTest2() {

        /**
         * Map
         *
         * 前面提到过，Map类型不支持stream，不过Map提供了一些新的有用的方法来处理一些日常任务
         */

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));
        //以上代码很容易理解， putIfAbsent 不需要我们做额外的存在性检查，而forEach则接收一个Consumer接口来对map里的每一个键值对进行操作

        System.out.println("下面的例子展示了map上的其他有用的函数");
        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println("map.computeIfPresent(3, (num, val) -> val + num); " + map.get(3));

        map.computeIfPresent(9, (num, val) -> null);
        System.out.println("map.computeIfPresent(9, (num, val) -> null); " + map.containsKey(9));

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println("map.containsKey(23); " + map.containsKey(23));

        map.computeIfAbsent(3, num -> "bam");
        System.out.println("map.get(3) " + map.get(3));

        System.out.println("接下来展示如何在Map里删除一个键值全都匹配的项：");
        map.get(3);
        System.out.println("map.get(3); " + map.get(3));

        map.remove(3, "val33");
        System.out.println("map.remove(3, \"val33\"); " + map.get(3));

        map.getOrDefault(42, "not found");
        System.out.println("map.getOrDefault(42, \"not found\"); " + map.getOrDefault(42, "not found"));

        System.out.println("对Map的元素做合并也变得很容易了");
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println("map.get(9); " + map.get(9));

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println("map.get(9); " + map.get(9));

        //Merge做的事情是如果键名不存则则插入，否则则对原键对应的值做合并操作并重新插入到map中

    }


    public static void main(String[] args) {
//        defaultTest();
//        predicateTest();
//        optionTest();

//        streamTest();
        streamTest2();
    }




}

@FunctionalInterface//当写了这个注解之后 interface里面有且只允许有一个方法定义，不然就会报错
interface Converter<F, T>{

    T convert(F from);


}
