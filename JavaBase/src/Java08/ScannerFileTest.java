package Java08;

import java.util.Scanner;
import java.io.File;

/**
 * @author kenshin
 * @date 2018/5/22 上午10:22
 */
public class ScannerFileTest {

    public static void main(String[] args) throws Exception{
        //将一个File对象作为Scanner构造器参数，Scanner读取文件内容
        Scanner sc = new Scanner(new File("props.txt"));
        System.out.println("文件内容如下:");
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

    }

}
