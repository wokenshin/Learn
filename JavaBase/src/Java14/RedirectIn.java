package Java14;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author kenshin
 * @date 2018/5/30 下午3:46
 */
public class RedirectIn {

    public static void main(String[] args) {

        try(FileInputStream fis = new FileInputStream("props.txt")){

            //将标准输入重定向到fis输入流
            System.setIn(fis);
            //使用System.in创建Scanner对象，用于获取标准输入
            Scanner sc = new Scanner(System.in);
            //增加下面一行 只把回车作为分隔符
            sc.useDelimiter("\n");
            //判断是否还有下一个输入项
            while (sc.hasNext()){
                //输出输入项
                System.out.println("键盘输入的内容是：" + sc.next());
            }

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
