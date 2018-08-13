package Java10;

import java.util.ArrayDeque;

/**
 * @author kenshin
 * @date 2018/5/23 下午2:15
 */
public class ArrayDequeQueue {

    //队列：先进先出
    public static void main(String[] args) {
        ArrayDeque queue = new ArrayDeque();
        //依次将三个元素加入到队列
        queue.offer("美德");
        queue.offer("惠德");
        queue.offer("仁德");
        System.out.println(queue);

        //访问队列头部的元素，但并不将其pop出队列栈
        System.out.println(queue.peek());
        System.out.println(queue);

        //poll出一个元素
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
