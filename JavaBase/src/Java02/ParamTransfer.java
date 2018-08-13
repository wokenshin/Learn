package Java02;

/**
 * @author kenshin
 * @date 2018/5/18 上午9:15
 */
public class ParamTransfer {

    public static void swap(int a, int b){
        int tmp = a;
        a       = b;
        b       = tmp;

        System.out.println("swap方法中 a的值是：" + a + ", b的值是：" + b);
    }

    public  static void swap(DataWrap dw){

        int tmp = dw.a;
        dw.a    = dw.b;
        dw.b    = tmp;
        System.out.println("DataWrap a:"+dw.a+", b:"+dw.b);

    }

    public static void main(String[] args){

        //参数传递 java中所有的参数传递都是 值传递「副本」
//        int a = 10;
//        int b = 20;
//        swap(a,b);
//        System.out.println("main方法中 a的值是：" + a + ", b的值是：" + b);

//        DataWrap wrap = new DataWrap();
//        wrap.a = 10;
//        wrap.b = 20;
//        swap(wrap);
//        System.out.println("DataWrap a:"+wrap.a+", b:"+wrap.b);

        varTest(100, "《秘密花园》", "《我亲爱的甜橙树》", "《番茄工作法》", "《时间管理》", "《学习知道》");
    }

    //定义形参个数可变的方法
    public static void varTest(int a, String... books){
        //books被当成数组处理
        for (String book:books) {
            System.out.println(book);
        }

        //输出整数变量a的值
        System.out.println(a);
    }

}

class DataWrap{
    int a;
    int b;
}
