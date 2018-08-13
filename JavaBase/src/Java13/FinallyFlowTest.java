package Java13;

/**
 * @author kenshin
 * @date 2018/5/29 上午8:37
 */
public class FinallyFlowTest {

    public static void main(String[] args) throws Exception{
        boolean a = test();
        System.out.println(a);
    }

    static boolean test(){
        try {
            //因为finally中包含了return语句，所以下面一行的return语句失去了作用
            return true;
        }
        finally {
            return false;
        }
    }
}
