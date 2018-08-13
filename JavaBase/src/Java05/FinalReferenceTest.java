package Java05;

import java.util.Arrays;

/**
 * @author kenshin
 * @date 2018/5/21 上午9:31
 */
public class FinalReferenceTest {

    public static void main(String[] args) {
        //final 修饰 数组变量 数组是一个引用变量
        final int[] iArr = {5, 6, 12, 9};
        System.out.println(Arrays.toString(iArr));

        //对数组元素进行排序
        Arrays.sort(iArr);
        System.out.println(Arrays.toString(iArr));

        //对数组元素赋值
        iArr[2] = -8;
        System.out.println(Arrays.toString(iArr));

        //下面对iArr重新赋值 非法
        //iArr = null;

        //final 修饰 Person变量，p是一个引用变量
        final Person p = new Person(18);
        p.setAge(28);
        System.out.println(p.getAge());
        //下面的语句非法
        //p = null;

    }

}

class Person{

    private int age;

    public Person(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
