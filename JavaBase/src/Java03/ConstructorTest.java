package Java03;

/**
 * @author kenshin
 * @date 2018/5/18 下午3:50
 */
public class ConstructorTest {

    public String name;
    public int count;

    //提供自定义的构造器 该构造器包含两个参数
    public ConstructorTest(String name, int count){
        this.name  = name;
        this.count = count;
    }

    //深入构造器
    public static void main(String[] args) {
        //使用自定义构造器来创建对象
        ConstructorTest con = new ConstructorTest("kenshin", 28);
        System.out.println(con.name);
        System.out.println(con.count);

        //当实现自定义构造器之后 系统就不再提供默认的构造器来 下面的代码会报错-->当然你也可以自己实现一个无参数的构造器
        //ConstructorTest con1 = new ConstructorTest();

    }
}
