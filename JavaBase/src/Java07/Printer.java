package Java07;

import Java06.Output;

/**
 * @author kenshin
 * @date 2018/5/21 下午3:05
 * 让Printer类实现 Produce和Output接口
 */
public class Printer implements Product, Output {

    private String[] printData = new String[MAX_CACHE_LINE];
    //用以记录当前需要打印的作业数
    private int dataNum = 0;

    @Override
    public void out() {
        //只要还有作业就继续打印
        while (dataNum > 0){
            System.out.println("打印机打印: " + printData[0]);
            //把作业队列整体前移一位，并将剩下的作业数-1
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE){
            System.out.println("输出队列已满 添加失败");
        }
        else{
            //把打印数据添加到队列里，已保存的数据的数量+1
            printData[dataNum++] = msg;
        }
    }

    @Override
    public int getProduceTime() {
        return 45;
    }

    public static void main(String[] args) {
        //创建一个Printer对象 当成 Output使用
        Output o = new Printer();
        o.getData("轻量级 JavaEE企业应用实战");
        o.getData("疯狂Java讲义");
        o.out();

        o.getData("疯狂Android讲义");
        o.getData("疯狂Ajax讲义");
        o.out();

        //调用Output接口中定义的默认方法
        o.print("鸣人", "佐助", "小樱");
        o.test();

        //创建一个Printer对象 当成Product使用
        Product p = new Printer();
        System.out.println(p.getProduceTime());

        //所有接口类型的引用变量都可以直接赋给Object类型的变量
        Object obj = p;
    }
}

//定义一个Product接口
interface Product{
    int getProduceTime();
}

