package Java12;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author kenshin
 * @date 2018/5/25 上午10:20
 */
public class GenericMethodTest {

    //声明一个泛型方法，该泛型方法中带一个T类型形参
    static <T> void fromArrayToCollection(T[] a, Collection<T> c){
        for (T o : c) {
            c.add(o);
        }
    }

    public static void main(String[] args) {

        Object[] arrObj = new Object[100];
        Collection<Object> collObj = new ArrayList<>();
        //下面代码中T代表Object类型
        fromArrayToCollection(arrObj, collObj);

        String[] arrStr = new String[100];
        Collection<String> collStr = new ArrayList<>();
        //下面代码中T代表String类型
        fromArrayToCollection(arrStr, collStr);

        //下面代码中T代表Obj类型
        fromArrayToCollection(arrStr, collObj);

        Integer[] arrIn = new Integer[100];
        Float[] arrFa   = new Float[100];
        Number[] arrNu  = new Number[100];
        Collection<Number> collNum = new ArrayList<>();

        //下面代码中T代表Number
        fromArrayToCollection(arrIn, collNum);

        //下面代码中T代表Number
        fromArrayToCollection(arrFa, collNum);

        //下面代码中T代表Number
        fromArrayToCollection(arrNu, collNum);

        //下面代码中T代表Object类型
        fromArrayToCollection(arrNu, collObj);

        //下面代码中T代表String类型 但arrNu是一个Number类型数组 因为Number既不是String也不是它的子类 所以出现编译错误
        //fromArrayToCollection(arrNu, collStr);

    }
}
