package com.javase.generic;

/**
 * @author kenshin
 * @date 2018/7/10 上午9:14
 */
public class Box<T> {

    private T t;

    public void addT(T t){
        this.t = t;
    }

    public T getT(){
        return t;
    }

    public static void testFunction(){

        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox   = new Box<String>();

        integerBox.addT(new Integer(10));
        stringBox.addT("kenshin");

        System.out.println("——————————————————————————————————泛型类测试————————————————————————————————————");
        System.out.println("整形值为 " + integerBox.t);
        System.out.println("字符串为 " + stringBox.t);

    }

}
