package Java14;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author kenshin
 * @date 2018/5/30 下午2:13
 */
public class PrintStreamTest {

    public static void main(String[] args) {
        try(
                FileOutputStream fos = new FileOutputStream("test.txt");
                PrintStream ps = new PrintStream(fos)
                ){
            //使用PrintStream执行输出
            ps.println("普通字符串");
            //直接使用PrintStream输出对象
            ps.println(new PrintStreamTest());

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
