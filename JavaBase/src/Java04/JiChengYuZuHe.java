package Java04;

/**
 * @author kenshin
 * @date 2018/5/19 上午10:01
 */
public class JiChengYuZuHe {

    public static void main(String[] args) {

        //下面代码会引发指针异常
        //原因：因为SubA中重写类 父类中的test方法，而初始化SubA的时候会调用父类的构造器，父类构造器中也调用类test方法，
        //此时父类调用的test方法变成类子类中的test方法，由于子类中的name没有进行初始化 默认值为 null，所以出现类指针异常
        //综上，不推荐在子类中重写父类构造器中调用到的方法 or才用其他方式避免
        //SubA s = new SubA();

        //利用组合 实现复用
        //下面是继承的列子 复用的例子省略
        Bird b = new Bird();
        b.breath();
        b.fly();

        System.out.println("————————————————————————————————————————————————————————————————");

        Wolf w = new Wolf();
        w.breath();
        w.run();


    }

}

class BaseA{

    public BaseA(){
        test();
    }

    public void test(){
        System.out.println("将被子类重写的方法");
    }

}

class SubA extends BaseA{

    private String name;
    public void test(){
        System.out.println("子类重写父类的方法， 其name字符串长度为：" + name.length());
    }

}

class Animal{

    private void beat(){
        System.out.println("心脏跳动...");
    }

    public void breath(){
        beat();
        System.out.println("呼吸...");
    }

}

class Bird extends Animal{

    public void fly(){
        System.out.println("我在天空中飞翔");
    }

}

class Wolf extends Animal{

    public void run(){
        System.out.println("我在陆地上快速奔跑");
    }
}