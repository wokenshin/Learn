package Java12;

import java.util.Collection;

/**
 * @author kenshin
 * @date 2018/5/25 下午2:23
 */
public class GenericDiamondTest {

    public static <T> void copy(Collection<T> dest, Collection<? extends T> src){

        for (T ele:src) {
            dest.add(ele);
        }

    }

    public static void main(String[] args) {
        //MyClass类声明中的E形参是String类型
        //泛型构造器中声明的T形参是Integer类型
        MyClass<String> mc1 = new MyClass<>(5);

        //显示指定泛型构造器中声明的T形参是Integer
        MyClass<String> mc2 = new <Integer>MyClass<String>(2);

        //MyClass类声明中的E形参是String类型
        //如果显示指定泛型构造器中声明的T形参是Integer类型
        //此时就不能使用 菱形语法，下面的代码出现错误
        //
        // MyClass<String> mc3 = new <Integer> MyClass<>(5);
    }

}

class MyClass<E>{

    public <T> MyClass(T t ){
        System.out.println("t参数的值为：" + t);
    }

}
