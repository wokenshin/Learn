package Java10;

import java.util.ArrayDeque;

/**
 * @author kenshin
 * @date 2018/5/23 下午2:10
 */
public class ArrayDequeStack {

    //栈：后进先出
    public static void main(String[] args) {
        ArrayDeque stack = new ArrayDeque();
        //依次将三个元素push入栈
        stack.push("阿呆");
        stack.push("正南");
        stack.push("风间");
        System.out.println(stack);

        //访问第一个元素 但并不将其 pop 出栈
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
