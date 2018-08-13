package Java14;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author kenshin
 * @date 2018/5/30 上午11:07
 */
public class FIleReaderTest {

    public static void main(String[] args) throws IOException {

        try(//创建字符输入流
            FileReader fr = new FileReader("props.txt")){
            //创建一个长度为32的"竹筒"
            char[] cbuf = new char[32];
            //用户保存实际读取的字符数
            int hasRead = 0;
            //使用循环来重复"取水"过程
            while ((hasRead = fr.read(cbuf)) > 0){
                //取出"竹筒"中的"水滴"（字符），将字符数组转换成字符串输入
                System.out.println(new java.lang.String(cbuf, 0, hasRead));
            }
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
