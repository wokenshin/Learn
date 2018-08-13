package Java14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/30 上午8:30
 */
public class AnnotationTest extends Father{

    @Override
    public String info(){
        return "使用@Override后，如果这里的方法写错来的话，会有提示";
    }

    //下面的注解貌似没作用 可能是ider或当前java版本的缘故
//    @SuppressWarnings(value = "unchecked")
    public static void main(String[] args) {
        //new AnnotationTest().test1();

//        List<String> myList = new ArrayList();

        List list = new ArrayList<Integer>();
        list.add(20);//添加元素时引发 unchecked异常

        //下面代码引起 未经检查的转换 的警告，编译，运行时完全正常
        List<String> ls = list;
        System.out.println(ls.get(0));
    }

}

class Father{

    public String info(){
        return "info";
    }

    @Deprecated
    public void test1(){
        System.out.println("本方法已过时");
    }

}