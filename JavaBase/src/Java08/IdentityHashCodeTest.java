package Java08;

/**
 * @author kenshin
 * @date 2018/5/22 上午10:58
 */
public class IdentityHashCodeTest {


    public static void main(String[] args) {
        //下面程序中s1 和 s2 是两个不同的对象
        String s1 = new String("kenshin");
        String s2 = new String("kenshin");
        //String 重写了 hashCode方法 改为根据字符串序列生成hashcode值
        //因为s1 和 s2的字符串序列相同 所以它们的hashCode相同
        if (s1.hashCode() == s2.hashCode()){
            System.out.println("s1 和 s2 的 hashCode值相等");
            System.out.println(s1.hashCode());
            System.out.println(s2.hashCode());
        }

        //因为s1和s2是不同的对象 所以它们的 identityHashCoe不同
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));

        String s3 = "kenshin";
        String s4 = "kenshin";
        //因为s3和s4是相同的对象 所以它们的identityHashCode相同
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));
    }
}
