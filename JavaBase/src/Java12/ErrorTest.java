package Java12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/25 上午11:34
 */
public class ErrorTest {

    //声明一个泛型方法
    static <T> void test(Collection<T> from, Collection<T> to){
        for (T ele : from) {
            to.add(ele);
        }
    }
    
    public static void main(String[] args) {
        List<Object> listObj = new ArrayList<>();
        List<String> listStr = new ArrayList<>();
        List<String> listStr2 = new ArrayList<>();

        //下面代码将引发编译错误
//        test(listObj, listStr);

        test(listStr, listStr2);
    }
}
