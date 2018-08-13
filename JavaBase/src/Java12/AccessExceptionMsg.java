package Java12;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author kenshin
 * @date 2018/5/25 下午5:16
 */
public class AccessExceptionMsg {

    public static void main(String[] args) {

        try{
            FileInputStream fis = new FileInputStream("a.txt");
        }
        catch (IOException ioe){

            System.out.println("我是输出语句:" + ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
