package Java07;

import Java06.Output;

/**
 * @author kenshin
 * @date 2018/5/21 下午3:37
 */
public class Computer {
    private Output out;
    public Computer(Output out){
        this.out = out;
    }

    //定义一个模拟获取字符串输入的方法
    public void keyIn(String msg){
        out.getData(msg);
    }

    //定义一个模拟打印的方法
    public void print(){
        out.out();
    }
}

