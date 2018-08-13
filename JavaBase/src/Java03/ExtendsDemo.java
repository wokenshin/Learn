package Java03;

/**
 * @author kenshin
 * @date 2018/5/18 下午4:20
 */
public class ExtendsDemo {



    public static void main(String[] args) {

        Apple apple = new Apple();
        apple.weight = 300;
        apple.info();

    }

}


//水果类
class Fruit{

    public double weight;
    public void info(){
        System.out.println("我是一个水果，重：" + weight + "g");
    }

}

//苹果类
class Apple extends Fruit{



}