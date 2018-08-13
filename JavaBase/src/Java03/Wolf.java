package Java03;



//生物
class Creature{

    public Creature(){
        System.out.println("Creature 无参数的构造器");
    }

}

class Animal extends Creature{

    public Animal(String name){
        System.out.println("Animal 带一个参数的构造器 该动物的name为 " + name);
    }

    public Animal(String name, int age){
        this(name);
        System.out.println("Animal 带两个参数的构造器 该动物的 age为 " + age);
    }

}

/**
 * @author kenshin
 * @date 2018/5/18 下午5:26
 */
public class Wolf extends Animal{

    public Wolf(){
        super("灰太狼", 18);
        System.out.println("Wolf 无参数构造器");
    }

    public static void main(String[] args) {
        new Wolf();
    }

}

