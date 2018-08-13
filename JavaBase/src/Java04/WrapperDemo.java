package Java04;

/**
 * @author kenshin
 * @date 2018/5/19 下午2:11
 */
public class WrapperDemo {

    //自动装箱 自动拆箱
    static void autoBoxingUnboxing(){

        //直接把一个基本类型变量赋值给Integer对象
        Integer inObj = 5;

        //直接把一个boolean类型的变量赋给Obj类型的变量
        Object booleanObj = true;

        //直接把一个Integer赋给int类型的变量
        int it = inObj;
        if (booleanObj instanceof Boolean){
            //先把 object 对象强制类型转换为 Boolean 类型，再赋给 boolean 变量
            boolean b = (Boolean) booleanObj;
            System.out.println(b);

        }

    }

    //字符串 和 基本数据类型 之间的转换
    static void primitiveToString(){
        //把字符串类型的值转换为基本类型的值有两种方式
        String intStr = "123";
        //把一个特定字符串转换成int变量
        int it1 = Integer.parseInt(intStr);
        int it2 = new Integer(intStr);
        System.out.println(it1);
        System.out.println(it2);

        String floatStr = "4.56";
        //把一个特定字符串转换成float变量
        float ft1 = Float.parseFloat(floatStr);
        float ft2 = new Float(floatStr);
        System.out.println(ft1);
        System.out.println(ft2);

        //把一个float变量变成String变量
        String ftStr = String.valueOf(3.1415f);
        System.out.println(ftStr);

        //把一个double变量变成String变量
        String dbSTr = String.valueOf(3.14159);
        System.out.println(dbSTr);

        //把一个boolean变量转换成字符串
        String boolStr = String.valueOf(true);
        System.out.println(boolStr.toUpperCase());//将字符串字母全部大写

    }

    public static void main(String[] args) {
        //autoBoxingUnboxing();
        //primitiveToString();

        //包装类 和 基本数据类型 比较
        Integer a = new Integer(6);
        System.out.println("6的包装类实例是否大于5："+(a > 5));

        //比较两个包装类实例是否相等
        System.out.println("比较两个包装类实例是否相等:"+ (new Integer(2) == new Integer(2)));

        Integer x = 2;
        Integer y = 2;
        System.out.println("x == y " + (x == y));//true

        Integer x2 = 128;
        Integer y2 = 128;
        System.out.println("x2 == y2 " + (x2 == y2));//false


    }
}
