package Java08;

import java.util.Scanner;

/**
 * @author kenshin
 * @date 2018/5/22 上午10:05
 */
public class ScannerTest {

    static void scannerTest1(){
        //System.in 代表标准输入 就是键盘输入
        Scanner sc = new Scanner(System.in);
        //增加下面一行 将只把回车作为分隔符
        sc.useDelimiter("\n");
        //判断是否还有下一个输入项
        while (sc.hasNext()){
            //输出输入项
            System.out.println("键盘输入的内容是： " + sc.next());
        }
    }

    static void scannerTest2(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()){
            System.out.println("键盘输入的内容是: " + sc.nextLong());
        }
    }

    public static void main(String[] args) {
        //获取键盘输入
        //scannerTest1();
        scannerTest2();

    }
}
