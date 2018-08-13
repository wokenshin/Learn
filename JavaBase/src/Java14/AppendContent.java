package Java14;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author kenshin
 * @date 2018/5/30 下午4:56
 */
public class AppendContent {

    public static void main(String[] args) {
        try(
                //以读、写方式打开以个RandomAccessFile对象
                RandomAccessFile raf = new RandomAccessFile("out.txt", "rw")){

            //将记录指针移动到 out.txt 文件的最后
            raf.seek(raf.length());
            raf.write("追加的内容！\r\n".getBytes());

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
