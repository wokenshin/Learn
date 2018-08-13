package Java13;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author kenshin
 * @date 2018/5/29 上午9:17
 */
public class ThrowsTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
    }
}
