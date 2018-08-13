package Java09;

import java.math.BigDecimal;

/**
 * @author kenshin
 * @date 2018/5/22 下午2:03
 */
public class BigDecimalDemo {

    static void test(){
        System.out.println("0.05 + 0.01 == " + (0.05 + 0.01));
        System.out.println("1.0 - 0.42  == " + (1.0 - 0.42));
        System.out.println("4.015 * 100 == " + (4.015 * 100));
        System.out.println("123.3 / 100 == " + (123.3 / 100));
    }

    static void test2(){

        BigDecimal b1 = new BigDecimal("0.05");
        BigDecimal b2 = BigDecimal.valueOf(0.01);
        BigDecimal b3 = new BigDecimal(0.05);

        System.out.println("使用String作为BigDecimal构造器参数：");
        System.out.println("0.05 + 0.01 == " + b1.add(b2));
        System.out.println("0.05 - 0.01 == " + b1.subtract(b2));
        System.out.println("0.05 * 0.01 == " + b1.multiply(b2));
        System.out.println("0.05 / 0.01 == " + b1.divide(b2));

        System.out.println("使用double作为BigDecimal构造器参数：");
        System.out.println("0.05 + 0.01 == " + b3.add(b2));
        System.out.println("0.05 - 0.01 == " + b3.subtract(b2));
        System.out.println("0.05 * 0.01 == " + b3.multiply(b2));
        System.out.println("0.05 / 0.01 == " + b3.divide(b2));

    }

    public static void main(String[] args) {
        //不精确 丢精度
        //test();
        //test2();
        System.out.println("0.05 + 0.01 == " + Arith.add(0.05, 0.01));
        System.out.println("1.0 - 0.42  == " + Arith.subtract(1.0, 0.42));
        System.out.println("4.015 * 100 == " + Arith.multiply(4.015, 100));
        System.out.println("123.3 / 100 == " + Arith.divide(123.3, 100));

    }
}

class Arith{

    //默认触发运算精度
    private static final int DEF_DIV_SCALE = 10;

    //构造器私有 让这个类不能实例化
    private Arith(){}

    //提供精确的加法运算
    public static double add(double v1, double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    //提供精确的减法运算
    public static double subtract(double v1, double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    //提供精确的乘法运算
    public static double multiply(double v1, double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }

    //提供相对精确的触发运算，当除不尽时精确到小数点后10为 四舍五入
    public static double divide(double v1, double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}