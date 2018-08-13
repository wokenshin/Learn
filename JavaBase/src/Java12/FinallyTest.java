package Java12;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author kenshin
 * @date 2018/5/25 下午5:31
 */
public class FinallyTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("a.txt");
        }
        catch (IOException ioe){
            System.out.println(ioe.getMessage());
            //return 语句 强制方法返回
            return;
            //使用 exit 退出虚拟机
            //System.exit(1);
        }
        finally {
            //关闭磁盘文件，回收资源
            if (fis != null){
                try {
                    fis.close();
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            System.out.println("执行finally块里的资源回收！");
        }
    }
}
