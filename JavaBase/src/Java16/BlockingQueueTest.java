package Java16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author kenshin
 * @date 2018/6/1 下午3:16
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws Exception{
        //定义一个长度为2的阻塞队列
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
        bq.put("Java");
        bq.put("Java");
        bq.put("Java");//阻塞线程 已经最多能放2个
    }
}
