package Java08;

/**
 * @author kenshin
 * @date 2018/5/22 上午11:47
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        //追加字符串
        sb.append("Java");//sb = "Java"
        System.out.println(sb);

        //插入字符串
        sb.insert(0, "Hello");
        System.out.println(sb);

        //替换
        sb.replace(5, 6, ",");
        System.out.println(sb);

        //删除
        sb.delete(5,6);
        System.out.println(sb);

        //反转
        sb.reverse();
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());

        //改变长度
        sb.setLength(sb.length()-2);
        System.out.println(sb);
    }
}
