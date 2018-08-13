package Java12;

/**
 * @author kenshin
 * @date 2018/5/25 下午2:18
 */
public class GenericContructor {

    public static void main(String[] args) {

        //泛型构造器中的T为String
        new Foo("kenshin");

        //泛型构造器中的T为Integer
        new Foo(313911762);

        //显示指定泛型构造器中的T为String
        new <String>Foo("kenshin");

        //下面的代码出现编译错误
//        new <String>Foo(1234.12);

    }

}

class Foo{
    public <T> Foo(T t ){
        System.out.println(t);
    }
}
