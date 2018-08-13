package Java12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/25 上午8:59
 */
public class GenericTest {

//    static void test(List c){
//        for (int i = 0; i < c.size(); i++) {
//            System.out.println(c.get(i));
//        }
//    }

//    static void test(List<Object> obj){
//        for (int i = 0; i < obj.size(); i++) {
//            System.out.println(obj.get(i));
//        }
//    }

    static void test(List<?> what){
        for (int i = 0; i < what.size(); i++) {
            System.out.println(what.get(i));
        }
    }

    static void arrayErr(){
        //定义一个Integer数组
        Integer[] ia = new Integer[5];
        //可以把一个 Integer[]赋给Number[]变量
        Number[] na = ia;
        //下面代码编译正常，但运行时引发 ArrayStoreException 异常,因为 0.5并不是Integer
        na[0] = 0.5;

        //改进
        List<Integer> listIn = new ArrayList<>();
        List<Number>  listNu = new ArrayList<>();

        //下面的代码将会引起编译错误
        //listNu = listIn;

    }

    public static void main(String[] args) {
        //创建一个List<String>对象
        List<String> strList = new ArrayList<>();
        //调用test
        //test(strList);
        arrayErr();


        List<?> c = new ArrayList<String>();
        //如下代码会引起编译错误
        //c.add(new Object());
    }

}
