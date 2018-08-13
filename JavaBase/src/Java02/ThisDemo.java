package Java02;

/**
 * @author kenshin
 * @date 2018/5/17 下午5:16
 */
public class ThisDemo {

    public static void main(String[] args){

//        Dog dog = new Dog();
//        dog.run();

        ThisInConstructor demo = new ThisInConstructor();
        System.out.println(demo.foo);

    }

}

class ThisInConstructor{

    public int foo;

    public ThisInConstructor(){

        //在构造器里定义一个foo变量
        int foo = 0;

        this.foo = 6;

    }

}

class Dog{

    public void jump(){
        System.out.println("dog jumping");
    }

    public void run(){
//        this.jump();
        jump();//可以省略 this
        System.out.println("dog running");
    }

    public static void test(){
        System.out.println("xxx");
        //这里演示了静态方法直接访问非静态方法时引发的错误
//        jump();
    }

}