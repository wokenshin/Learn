package Java10;

import java.util.TreeSet;

/**
 * @author kenshin
 * @date 2018/5/23 上午9:35
 */
public class TreeSetTest2 {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        Z z1 = new Z(6);
        set.add(z1);

        //第二次添加同一个对象，输出true 表明添加成功
        System.out.println(set.add(z1));
        //下面输出set集合 将看到有两个元素
        System.out.println(set);

        //修改set集合的第一个元素的age
        ((Z)set.first()).age = 18;

        //输出set集合的最后一个元素的age
        System.out.println(((Z)set.last()).age);//两个对象的地址相同 所以这里的集合里其实是两个相同的引用
    }
}

class Z implements Comparable{

    int age;
    public Z(int age){
        this.age = age;
    }

    //重写equals方法 总是返回true
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    //重写了compareTo方法 总是返回1
    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
