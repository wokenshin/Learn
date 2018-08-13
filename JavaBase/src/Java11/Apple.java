package Java11;

import java.util.ArrayList;

/**
 * @author kenshin
 * @date 2018/5/24 下午3:31
 */
public class Apple<T> {

    //使用T类型形参定义实例变量
    private T info;
    public Apple(){}

    //下面方法中使用T类型形参来定义构造器
    public Apple(T info){
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args) {

        //由于传给T形参的是String，所以构造器只能是String
        Apple<String> a1 = new Apple<>("苹果");
        System.out.println(a1.getInfo());

        //由于传给T形参的是Double，所以构造器参数只能是double
        Apple<Double> a2 = new Apple<>(3.1415926);
        System.out.println(a2.getInfo());


        ArrayList<String> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        System.out.println("屌了：" + (l1.getClass() == l2.getClass()));
    }

}

class A1 extends Apple<String>{

    //正确重写父类的方法，返回值
    //与父类Apple<String>的返回值完全相同


    @Override
    public String getInfo() {
        return "子类" + super.getInfo();
    }

}