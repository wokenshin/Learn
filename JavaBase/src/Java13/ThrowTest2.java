package Java13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author kenshin
 * @date 2018/5/29 上午10:58
 */
public class ThrowTest2 {

    public static void main(String[] args) throws Exception{

        try {
            new FileOutputStream("a.txt");
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;//java6
        }

    }

}

//优化后 java7
class ThrowTest3
{
    public void test() throws FileNotFoundException {
        try {
            new FileOutputStream("a.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
