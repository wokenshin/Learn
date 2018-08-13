package Java14;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author kenshin
 * @date 2018/5/30 下午4:42
 */
public class RandomAccessFileTest {

    public static void main(String[] args) {

        try(RandomAccessFile raf = new RandomAccessFile("props.txt", "r")){
            //获取RandomAccessFile对象文件指针的位置，初始位置是0
            System.out.println("RandomAccessFile对象文件指针的位置: " + raf.getFilePointer());

            //移动raf的文件记录指针的位置
            raf.seek(300);
            byte[] buff = new byte[1024];
            //用于保存实际读取的字节数
            int hasRead = 0;
            while ((hasRead = raf.read(buff)) > 0){
                System.out.println(new String(buff, 0, hasRead));
            }
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
