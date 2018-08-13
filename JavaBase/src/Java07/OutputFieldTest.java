package Java07;

import Java06.Output;

/**
 * @author kenshin
 * @date 2018/5/21 下午2:28
 */
public class OutputFieldTest {

    public static void main(String[] args) {
        //访问另一个包中的接口
        System.out.println(Output.MAX_CACHE_LINE);
        //下面的语句将引发为 final变量赋值的 编译错误
        //Output.MAX_CACHE_LINE = 100;

        //使用接口调用类方法
        System.out.println(Output.staticTest());
    }
}
