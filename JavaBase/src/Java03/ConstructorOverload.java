package Java03;

/**
 * @author kenshin
 * @date 2018/5/18 下午4:00
 */
public class ConstructorOverload {

    public String name;
    public int    count;
    public double height;

    //提供无需参数的构造器
    public ConstructorOverload(){}

    //提供带两个参数的构造器
    public ConstructorOverload(String name, int count){
        this.name  = name;
        this.count = count;
    }

    //提供带三个参数的构造器 并再构造器中调用其他构造器
    public ConstructorOverload(String name, int count, double height){
        //使用 this 调用另一个重载的构造器只能在构造器中使用，而且必须作为构造器执行体的第一条语句
        this(name, count);
        this.height = height;
    }

    //构造器重载
    public static void main(String[] args) {

        //通过无参数的构造器创建对象
        ConstructorOverload c1 = new ConstructorOverload();

        //通过有参数的构造器创建对象
        ConstructorOverload c2 = new ConstructorOverload("kenshin", 18);

        //通过三个参数的构造器创建对象
        ConstructorOverload c3 = new ConstructorOverload("kenshin", 18, 183);

        System.out.println("name is " + c1.name + " age is " + c1.count + " height " + c1.height);
        System.out.println("name is " + c2.name + " age is " + c2.count + " height " + c2.height);
        System.out.println("name is " + c3.name + " age is " + c3.count + " height " + c3.height);

    }


}
