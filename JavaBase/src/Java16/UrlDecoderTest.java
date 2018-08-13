package Java16;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author kenshin
 * @date 2018/6/1 下午5:03
 */
public class UrlDecoderTest {

    public static void main(String[] args) throws Exception{

        //将 那啥 字符串 转换成普通字符串
        String keyWord = URLDecoder.decode("%B7%E8%BF%F1Java%BD%B2%D2%E5", "utf-8");
        System.out.println(keyWord);

        String urlStr = URLEncoder.encode("疯狂Java讲义", "GBK");
        System.out.println(urlStr);

    }
}
