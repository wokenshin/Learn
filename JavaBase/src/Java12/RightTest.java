package Java12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/25 上午11:54
 */
public class RightTest {

    //声明一个泛型方法
    static <T> void test(Collection<? extends T> from, Collection <T> to){
        for (T ele : from) {
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> listObj = new ArrayList<>();
        List<String> listStr = new ArrayList<>();
        listStr.add("阿呆");
        listStr.add("阿瓜");

        System.out.println(listObj);

        //下面代码完全正常
        test(listStr, listObj);

        System.out.println(listObj);
    }
}
