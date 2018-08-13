package Java16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author kenshin
 * @date 2018/6/1 下午3:22
 */
public class Producer extends Thread {

    private BlockingQueue<String> bq;
    public Producer(BlockingQueue<String> dq){
        this.bq = bq;
    }

    @Override
    public void run() {
        String[] strArr = new String[]{"kenshin", "naruto", "hinato"};
        for (int i = 0; i < 999999999; i++) {
            System.out.println(getName() + " 生成者准备生产集合元素！");
            try{
                Thread.sleep(200);
                //尝试放入元素 如果队列已满 则阻塞
                bq.put(strArr[i % 3]);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(getName() + " 生产完成：" + bq);
        }

    }
}

class Consumer extends Thread{
    private BlockingQueue<String> bq;
    public Consumer(BlockingQueue<String> bq){
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(getName() + " 消费者准备消费集合元素！");
            try{
                Thread.sleep(200);
                bq.take();//尝试取出元素 如果队列为空 则阻塞
            }
            catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(getName() + "消费完成：" + bq);
        }
    }
}

class BlockingQueueTest2{
    public static void main(String[] args) {
        //创建一个容量为1的队列
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        //启动3个生产者线程
        new Producer(bq).start();
        new Producer(bq).start();
        new Producer(bq).start();
        //启动一个消费者线程
        new Consumer(bq).start();
    }
}