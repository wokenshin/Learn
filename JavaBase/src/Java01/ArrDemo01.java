package Java01;

import org.omg.CORBA.OBJ_ADAPTER;

/**
 * @author kenshin
 * @date 2018/5/17 上午10:14
 */
public class ArrDemo01 {

    public static void test1(){

        //两种定义数组的方式，推荐使用第一种
        int[] arrAge  = new int[]{1,2,3};//静态初始化
        int arrAge2[] = null;
        System.out.println("这里打印的是一段内存地址？"+arrAge);
        System.out.println(arrAge2);

        String[] arrStr = {"kenshin", "toma", "xun"};//直接用大括号实现 静态初始化
        for (int i = 0; i <arrStr.length ; i++) {
            String strT = arrStr[i];
            System.out.println(strT);
        }

//        System.out.println(arrStr[3]);//数组越界

        //动态初始化
        Object[] arrObj = new Object[20];
        arrObj = null;

    }


    public static void testForeach(){

        String[] arrStr = {"小新", "正南", "阿呆", "妮妮", "风间"};
        for (String strT: arrStr) {
            System.out.println(strT);
        }
    }

    //相同类型的数组可以 赋值"指针"
    static void marr(){

        int[] a = {5, 7, 20};
        int[] b = new int[4];

        System.out.println("b数组的长度为:"+b.length);

        for (int x: a) {
            System.out.println(x);
        }

        for (int x: b) {
            System.out.println(x);
        }

        b = a;
        System.out.println("b数组的长度为:"+b.length);
    }

    static void setValueInArr(){

        int[] arr = new int[10];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = 10 + i;
            System.out.println(arr[i]);
        }

    }

    public static void initObjArr(){

        Person[] arrPerson = new Person[2];
        Person p1 = new Person();
        p1.age    = 18;
        p1.height = 180;

        Person p2 = new Person();
        p2.age    = 28;
        p2.height = 173;

        arrPerson[0] = p1;
        arrPerson[1] = p2;

        arrPerson[0].info();
        arrPerson[1].info();

    }

    public static void main(String[] args){

//        test1();
//        testForeach();
//        marr();
//        setValueInArr();
//        initObjArr();

    }



}

class Person{

    public int age;
    public  double height;

    //定义一个info方法
    public void info(){
        System.out.println("为的年龄是：" + age + ", 为的身高是：" + height);
    }

}