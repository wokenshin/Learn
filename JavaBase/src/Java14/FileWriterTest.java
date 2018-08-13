package Java14;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author kenshin
 * @date 2018/5/30 上午11:34
 */
public class FileWriterTest {

    public static void main(String[] args) {
        try(
                FileWriter fw = new FileWriter("poem.txt")
                ){
            fw.write("美女\r\n");
            fw.write("美不美看大腿\r\n");
            fw.write("丑不丑看脸嘴\r\n");
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
