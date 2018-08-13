package Java13;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

/**
 * @author kenshin
 * @date 2018/5/29 上午8:53
 */
public class AutoCloseTest {

    public static void main(String[] args) throws Exception{
        try(
                //声明，初始化两个可关闭的资源
                //try语句会自动关闭这两个资源
                BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
                PrintStream ps = new PrintStream(new FileOutputStream("a.txt"));
                )
        {
            //使用两个资源
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        }
    }

}
