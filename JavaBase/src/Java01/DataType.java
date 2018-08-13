package Java01;

import java.math.BigDecimal;

/**
 * @author kenshin
 * @date   2018/5/16 下午4:42
 */
public class DataType {

    /*
    * 数据类型
    * 基本类型 boolean类型 和 数值类型（整数类型，浮点型）
    * 引用类型 类 接口 数组
    * */

    public static void main(String[] args){
        byte a = 56;
        long b = 9999999999999999L;

        //二进制
        int ba = 013;
        System.out.println(ba);
        //十进制
        int shi = ba;//8*1+3*1==11
        System.out.println(shi);
        //十六进制
        int sl = 0xaF;
        System.out.println(sl);

        char aChar = 'a';
        char bCahr = '\r';
        char cChar = '\u9999';
        System.out.println(cChar);

        char zhong = '范';
        int intZhong = zhong;
        System.out.println(intZhong);
        System.out.println(zhong);

        char zimu = 97;
        System.out.println(zimu);

        String name = "kenshin";
        System.out.println(name);

        //浮点数
        float f         = 3.141592612345f;
        double d        = 3.141592612345678912345;
        BigDecimal bigD = new BigDecimal("3.141592612345678912345");//关于BigDecimal的用法 百度

        System.out.println(f);
        System.out.println(d);
        System.out.println(bigD);

        //boolean
        boolean bool = true;
        String str   = bool+"";
        System.out.println(bool);
        System.out.println(str);

        short value = 5;
//        value       = value - 2;
        System.out.println(value);

        //字符串
        String s0 = "hello";
        String s1 = "hello";
        String s2 = "hel" + "lo";
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);

        //java貌似无法打印对象的内存地址
        System.out.println(s0.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }

    /*>> 3.4.3 浮点型
    Java 的浮点类型有两种：float 和 double。Java 的浮点类型有固定的表数范围和字段长度，字段长度和表数范围与机器无关。
    Java 的浮点数遵循 IEEE 754 标准，采用二进制数据的科学计数法来表示浮点数，对于 float 型数值，第 1 位是符号位，接下来 8 位表示指数，
    再接下来的 23 位表示尾数；对于 double 类型数值，第 1 位也是符号位，接下来的 11 位表示指数，再接下来的 52 位表示尾数。

    注意

    因为 Java 浮点数使用二进制数据的科学计数法来表示浮点数，因此可能不能精确表示一个浮点数。例如把 5.2345556 f 值赋给一个 float 类型变量，
    接着输出这个变量时看到这个变量的值已经发生了改变。使用 double 类型的浮点数比 float 类型的浮点数更精确，但如果浮点数的精度足够高（小数点后的数字很多时），
    依然可能发生这种情况。如果开发者需要精确保存一个浮点数，则可以考虑使用 BigDecimal 类。
    */


}
