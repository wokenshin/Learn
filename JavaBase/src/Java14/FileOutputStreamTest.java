package Java14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author kenshin
 * @date 2018/5/30 上午11:23
 */
public class FileOutputStreamTest {

    public static void main(String[] args) {
        try(
                //创建字节输入流
                FileInputStream fis = new FileInputStream("TestHeHe.java");

                //床架字节输出流
                FileOutputStream fos = new FileOutputStream("newFile.txt")){

            byte[] bbuf = new byte[32];
            int hasRead = 0;
            //循环从输入流中取数据
            while ((hasRead = fis.read(bbuf)) > 0){
                //每读取一次，即写如文件输出流，读了多少，就写多少
                fos.write(bbuf, 0, hasRead);
            }
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
