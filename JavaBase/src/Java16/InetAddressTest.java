package Java16;

import java.net.InetAddress;

/**
 * @author kenshin
 * @date 2018/6/1 下午4:18
 */
public class InetAddressTest {

    public static void main(String[] args) throws Exception{

        //根据主机名来获取对应的InetAddress实例
        InetAddress ip =  InetAddress.getByName("www.crazyit.org");

        //判断是否可达
        System.out.println("疯狂系列——网站——是否可达：" + ip.isReachable(2000));

        System.out.println("获取该InetAddress实例的ip字符串" + ip.getHostAddress());

        //根据原始ip地址在获取对应的实例
        InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
        System.out.println("本机是否可达: " + local.isReachable(5000));

        System.out.println("获取该InetAddress实例对应的全限定域名" + local.getCanonicalHostName());
    }
}
