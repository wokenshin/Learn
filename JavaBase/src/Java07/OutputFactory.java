package Java07;

import Java06.Output;

/**
 * @author kenshin
 * @date 2018/5/21 下午3:40
 */
public class OutputFactory {

    public Output getOutput(){
        return new Printer();
    }

    public static void main(String[] args) {
        OutputFactory of = new OutputFactory();
        Computer c = new Computer(of.getOutput());
        c.keyIn("轻量级JavaEE企业应用实战");
        c.keyIn("疯狂Java讲义");
        c.print();
    }

}
