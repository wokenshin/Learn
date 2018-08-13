package Java02;

/**
 * @author kenshin
 * @date 2018/5/17 下午3:40
 */
public class DefineClass {


    public static void test(String str, String myName){
        System.out.println(str);
        System.out.println("my name is " + myName);
    }

    public static void main(String[] args){

//        test("kenshin I love you", "toma");

        /*
        * Static 修饰的方法和成员变量，既可通过类来调用，也可通过实例来调用；没有使用 static 修饰的普通方法和成员变量，只可通过实例来调用。
        * 下面代码中通过 Person 实例来调用 Person 的成员变量和方法（程序清单同上）。
        * */

        Person p = new Person();
        p.name = "kenshin";
        p.age  = 28;
        p.say("我的家在遵义");
        System.out.println(p.name);

        //静态成员 可以被类访问 也可以被实例访问
        Person.saysay("666");
        p.saysay("我勒个擦");


    }

}

class Person{

    public String name;
    public int age;

    public void say(String content){
        System.out.println(content);
    }

    public static void saysay(String content){
        System.out.println(content);
    }

}
