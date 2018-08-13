package Java14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author kenshin
 * @date 2018/5/30 上午8:50
 */
public class ErrorUtils {

    public static void faultyMethod(List<String>... listStrArray){

        //Java语言不允许创建泛型数组，因此listStrArray只能被当成 List[]处理
        //此时相当于把List<String>赋给List，已经发生来堆污染
        List[] listArray = listStrArray;
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(new Random().nextInt(100));

        listArray[0] = myList;
        String s = listStrArray[0].get(0);

    }

    public static void main(String[] args) {
        faultyMethod();
    }
}
