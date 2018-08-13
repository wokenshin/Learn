package Java14;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author kenshin
 * @date 2018/5/30 下午2:28
 */
public class StringNoteTest {

    public static void main(String[] args) {
        String src =   "1 \n"
                     + "2  \n"
                     + "3  \n"
                     + "4  \n"
                     + "5  \n"
                     + "6  \n"
                     + "7  \n";

        char[] buffer = new char[32];
        int hasRead = 0;
        try(
                StringReader sr = new StringReader(src)
                ){
            //采用循环读取的方式读取字符串
            while ((hasRead = sr.read(buffer)) > 0){
                System.out.println(new java.lang.String(buffer, 0 , hasRead));
            }
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

        try(
                //创建StringWriter时，实际上以一个StringBuffer作为输出节点
                //下面指定的20就是StringBuffer的初始长度
                StringWriter sw = new StringWriter()
                ){
            sw.write("有一个美丽的新世界 \n");
            sw.write("她在远方等我 \n");
            sw.write("那里有天真的孩子 \n");
            sw.write("还有菇凉的就我 \n");
            System.out.println("-----------------下面是sw字符串节点里的内容----------------");
            System.out.println(sw.toString());

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
