package Java04;

/**
 * @author kenshin
 * @date 2018/5/19 下午3:16
 */
public class DengdengAndEquals {


    //字符串比较
    static void stringCompareTest(){

        //s1 直接引用常量池中的 "疯狂Java"
        String s1 = "疯狂Java";
        String s2 = "疯狂";
        String s3 = "Java";
        String s4 = "疯狂" + "Java";
        String s5 = "疯" + "狂" + "Java";
        String s6 = s2 + s3;
        String s7 = new String("疯狂Java");

        // == 两边是引用变量时 只有它们指向同一个引用变量时 才会返回true
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s7);

    }


    static void dengdeng(){
        int it = 65;
        float ft = 65.0f;
        //将输出true
        System.out.println("65和65.0f是否相等："+ (it == ft));

        char ch = 'A';
        //将输出true
        System.out.println("65和'A'是否相等：" + (it == ch));

        String str1 = new String("Hello");
        String str2 = new String("Hello");
        //将输出false
        System.out.println("str1 和 str2 是否相等：" + (str1 == str2));

        //将输出true
        System.out.println("str1 和 str2 是否equals：" + (str1.equals(str2)));

        //由于java.lang.String 与 本类没有继承关系 所以下面的代码出现编译错误
//        System.out.println("Hello" == new DengdengAndEquals());
    }

    public static void main(String[] args) {

        //dengdeng();
        stringCompareTest();


    }

}
