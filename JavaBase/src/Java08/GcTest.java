package Java08;

/**
 * @author kenshin
 * @date 2018/5/22 上午9:19
 */
public class GcTest {

    public static void main(String[] args) {
        //垃圾回收机制
        for (int i = 0; i < 4; i++) {
            new GcTest();
            System.gc();//强制系统进行垃圾回收
            //Runtime.getRuntime().gc(); 功能完全相同
        }
    }

    public void finalize(){
        System.out.println("系统正在清理GcTest对象的资源");
    }
}
