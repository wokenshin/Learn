import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/6/28 上午10:40
 */
public class SecondScheduler {

    public static void main(String[] args) throws SchedulerException {

        //打印当前的时间
        Date cuDate = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("SecondScheduler 当前时间是：" + sf.format(cuDate));


        //创建一个JobDetail实例 将该实例与 HelloJob Class绑定
        JobDetail jobDetail = JobBuilder
                .newJob(SecondJob.class)
                .withIdentity("myJob", "group1")
                .build();

        //获取距离当前时间3s后的时间 作为执行时间
        cuDate.setTime(cuDate.getTime() + 3000);//时间戳的单位是毫秒 所以这里3s == 3000

        //获取距离当前时间6s后的时间 停止执行
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 6000);


        //创建一个Trigger实例 定义该job立即执行 并且每隔2s 重复执行 直到永远
        Trigger trigger = TriggerBuilder.newTrigger().
                withIdentity("myTrigger", "group1")
                .startAt(cuDate)//设置启动时间
                .endAt(endDate)//设置结束时间
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();

        //创建Scheduler实例
        SchedulerFactory sfc = new StdSchedulerFactory();
        Scheduler scheduler = sfc.getScheduler();
        scheduler.start();



        scheduler.scheduleJob(jobDetail, trigger);

    }
}
