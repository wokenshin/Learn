package Java13;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author kenshin
 * @date 2018/5/29 上午9:27
 */
public class OverrideThrows {
    public void test() throws IOException{
        FileInputStream fis = new FileInputStream("a.txt");
    }
}

class Sub extends OverrideThrows {

    //子类方法声明抛出了比父类方法更大的异常
    //所以下面方法出错
//    @Override
//    public void test() throws Exception {
//
//    }
}
