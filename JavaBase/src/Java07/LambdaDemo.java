package Java07;

/**
 * @author kenshin
 * @date 2018/5/21 下午5:22
 */
public class LambdaDemo {

    //调用该方法需要Eatable对象
    public void eat(Eatable e){
        System.out.println(e);
        e.taste();
    }

    //调用该方法需要Flyable对象
    public void drive(Flyable f){
        System.out.println("我正在驾驶: " + f);
        f.fly("碧空如洗的清空");
    }

    //调用该方法需要Addable对象
    public void test(Addable a){
        System.out.println("5 + 3 == " + a.add(5, 3));
    }

    //这里知识作为了解 并未深入学习
    public static void main(String[] args) {
        LambdaDemo l = new LambdaDemo();
        //Lambda表达式的代码块只有一条语句，可以省略花括号
        l.eat(()-> System.out.println("苹果的味道不错!"));

        //Lambda表达式的形参列表只有一个参数，可以省略圆括号
        l.drive(weather -> {
            System.out.println("今天天气是: " + weather);
            System.out.println("直升机飞行平稳");
        });

        //Lambda表达式的代码块只有一条语句，了一省略花括号
        //代码块中只有一条语句，即使该表达式需要返回值，也可以省略return关键字
        l.test((a, b) -> a + b);

        Runnable r = () ->{
            for(int i = 0; i < 100; i++){
                System.out.println(i);
            }
        };


    }

}

interface Eatable{
    void taste();
}

interface Flyable{
    void fly(String weather);
}

interface Addable{
    int add(int a, int b);
}

