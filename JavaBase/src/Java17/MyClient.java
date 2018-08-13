package Java17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author kenshin
 * @date 2018/6/2 上午11:10
 */
public class MyClient {

    public static void main(String[] args) throws Exception{
        Socket s = new Socket("172.16.3.174", 30000);
        //客户端启动ClientThread 线程不断地读取来自服务器的数据
        new Thread(new ClientThread(s)).start();
        //读取该socket对应的输出流
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        //不断地读取键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null){
            //将用户的键盘内容输入socket对应的输出流
            ps.println(line);
        }
    }
}
