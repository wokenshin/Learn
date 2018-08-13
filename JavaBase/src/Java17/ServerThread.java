package Java17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**负责处理每个线程通信的线程类
 * @author kenshin
 * @date 2018/6/2 上午10:48
 */
public class ServerThread implements Runnable {

    Socket s = null;
    BufferedReader br = null;
    public ServerThread(Socket s) throws IOException {
        this.s = s;
        //初始化该socket对应的输入流
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        try{
            String content = null;
            //采用循环 不断地从socket中读取客户端发送过来的数据
            while ((content = readFromClient()) != null){
                //遍历socketList中的每一个socket
                //将读到的内容向每个socket发送一次
                for (Socket s : MyServer.socketList) {
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
                }
            }
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    //定义读取客户端数据的方法
    private String readFromClient(){
        try{
            return br.readLine();
        }
        catch (IOException e){
            //删除该socket
            MyServer.socketList.remove(s);
            e.printStackTrace();
        }
        return null;
    }
}
