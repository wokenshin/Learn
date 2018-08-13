package Java14;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author kenshin
 * @date 2018/5/30 下午4:14
 */
public class WriteToProcess {

    public static void main(String[] args) throws IOException {

        //运行java命令 编译java代码 返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("java ReadStandard");
        try(
                //以p进程的输出流创建PrintStream对象
                //这个输出流对本程序是输出流，对p进程是输入流
                PrintStream ps = new PrintStream(p.getOutputStream())){

            //向ReadStandard程序写入内容，这些内容将被ReadStandard读取
            ps.println("普通字符串");
            ps.println(new WriteToProcess());

        }

    }
}

class ReadStandard{

    public static void main(String[] args) {

        try(
                //使用System.in创建Scanner对象，用于获取标准输入
                Scanner sc = new Scanner(System.in);
                PrintStream ps = new PrintStream("out2.txt");
                ){

            //只把 回车 作为分隔符
            sc.useDelimiter("\n");
            //判断是否还有下一个输入项
            while (sc.hasNext()){
                ps.println("键盘输入的内容是："+sc.next());
            }

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}