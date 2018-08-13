import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/6/28 上午11:05
 */
public class SimpleScheduler {

    public static void main(String[] args) throws SchedulerException {

        //打印当前的时间
        Date cuDate = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("SimpleScheduler 当前时间是：" + sf.format(cuDate));


        //创建一个JobDetail实例 将该实例与 HelloJob Class绑定
        JobDetail jobDetail = JobBuilder
                .newJob(SimpleJob.class)
                .withIdentity("myJob", "group1")
                .build();

        //获取距离当前时间4s后的时间
        cuDate.setTime(cuDate.getTime() + 4000);

        //距离当前时间4s中后执行 切仅执行一次任务
        SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder.newTrigger().
                withIdentity("myTrigger", "group1")
                .startAt(cuDate)
                .build();


        //创建Scheduler实例
        SchedulerFactory sfc = new StdSchedulerFactory();
        Scheduler scheduler = sfc.getScheduler();
        scheduler.start();


        scheduler.scheduleJob(jobDetail, trigger);

    }
}
