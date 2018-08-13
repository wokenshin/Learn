package Java08;

/**
 * @author kenshin
 * @date 2018/5/22 上午11:11
 */
public class ExecTest {

    public static void main(String[] args) throws Exception{

        Runtime rt = Runtime.getRuntime();
        //运行记事本程序
        rt.exec("notepad.exe");//由于mac oc 中没有 对应软件 or 这里的 exe文件不是mac中的可执行文件？
    }
}
