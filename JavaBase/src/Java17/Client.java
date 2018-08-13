package Java17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author kenshin
 * @date 2018/6/2 上午10:15
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("172.16.3.174", 30000);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //进行普通IO操作
        String line = br.readLine();
        System.out.println("来自服务器的数据：" + line);
        //关闭资源
        br.close();
        socket.close();
    }
}
