package Java10;

import java.util.PriorityQueue;

/**
 * @author kenshin
 * @date 2018/5/23 上午11:56
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        //下面代码依次想pq中加入四个元素
        pq.offer(6);
        pq.offer(-3);
        pq.offer(20);
        pq.offer(18);

        //输出pr队列 并不是按元素的加入顺序排列
        System.out.println(pq);

        //访问队列的第一个元素 其实就是队列中最小的元素
        System.out.println(pq.poll());
    }
}
