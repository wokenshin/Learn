package com.javase.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/7/9 下午4:43
 */
public class GenericMethodTest {


    public static void line(String title){
        System.out.println("——————————————————————————————" + title +"————————————————————————————————");
    }

    //泛型方法printArray
    public static <E> void printArray(E[] inputArray, String space){

        //输出数组元素
        for (E element : inputArray){
            System.out.printf("%s", element + space);
        }
        System.out.println();

    }

    public static void test1(){
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[]   intArray    = { 1, 2, 3, 4, 5 };
        Double[]    doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray   = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println("整型数组元素为:");
        printArray(intArray, ""); // 传递一个整型数组

        System.out.println("\n双精度型数组元素为:");
        printArray(doubleArray,"  "); // 传递一个双精度型数组

        System.out.println("\n字符型数组元素为:");
        printArray(charArray,""); // 传递一个字符型数组
    }






    //声明一个有界的类型参数
    public static <T extends Comparable<T>> T maxABC(T x, T y, T z){

        T max = x;

        //注意当比较的内容是 字符串时 这里并不是比较的字符串的长度
        if (y.compareTo(max)>0){
            max = y;
        }
        if (z.compareTo(max)>0){
            max = z;
        }
        return max;

        /**
         * 关于 String 对 compareTo的使用的理解 可以查看如下内容
         * 1、【字典排序比较】https://www.cnblogs.com/hjy1017/p/6039586.html
         * 2、【字典排序】   https://blog.csdn.net/sysmedia/article/details/53667959
         */
    }


    /***
     * 为什么 "pear", "apple", "orange" 三个字符串比较大小 最大的是 pear ？
     */
    public static void test2(){

        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maxABC( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maxABC( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maxABC( "pear", "apple", "orange" ) );
    }


    public static void genericFun(){

        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();

        name.add("kenshin");
        age.add(28);
        number.add(9999999);

        getData(name);
        getData(age);
        getData(number);

//        getUperNumber(name); 由于类型限制 所以本行会报错
        getUperNumber(age);
        getUperNumber(number);

    }

    //类型通配符 可以接收任何类型
    public static void getData(List<?> data){
        System.out.println("data: " + data.get(0));
    }

    //限制 接收的参数 必须是 Number的子类
    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data :" + data.get(0));
    }

    public static void testMain(){

        System.out.println("泛型");
        test1();
        line("泛型方法 比较内容");
        test2();
        line("类型通配符");
        genericFun();


    }



}
