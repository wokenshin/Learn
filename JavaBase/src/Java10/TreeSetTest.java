package Java10;

import java.util.TreeSet;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/5/23 上午8:49
 */
public class TreeSetTest {

    static void testTreeSet(){
        TreeSet nums = new TreeSet();
        //向TreeSet中添加4个Integer对象
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);

        //输出集合元素 看到集合元素已处于排序状态
        System.out.println(nums);

        //输出集合里的第一个元素
        System.out.println(nums.first());

        //输出集合里的最后一个元素
        System.out.println(nums.last());

        //返回小于4的子集 不包含4
        System.out.println(nums.headSet(4));

        //返回大于等于5的子集
        System.out.println(nums.tailSet(5));

        //返回大于等于-3 小于4的子集
        System.out.println(nums.subSet(-3, 4));
    }

    static void testError(){
        //当把一个对象插入到TreeSet时 该对象必须实现Comparable接口，否则程序将会抛出异常
        TreeSet tree = new TreeSet();
        tree.add(new Error(1));
        tree.add(new Error(2));
        System.out.println(tree);
    }

    static void testError2(){
        //因为TreeSet会对集合中的对象进行比较，所以传入对象的类型必须相同，不然会引起 比较异常
        TreeSet t = new TreeSet();
        t.add("kenshin");
        t.add(new Date());

    }

    public static void main(String[] args) {
        testTreeSet();
//        testError();
//        testError2();
    }

}

class Error{// implements Comparable
    int a = 0;
    public Error(int a){
        this.a = a;
    }

//    @Override
//    public int compareTo(Object obj) {
//        Error e = (Error)obj;
//        if (this.a > e.a){
//            return 1;
//        }
//        else if (this.a == e.a){
//            return 0;
//        }
//        else{
//            return -1;
//        }
//    }
}
