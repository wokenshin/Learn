import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/6/28 下午2:36
 */
public class CronSecondScheduler {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("CronSecondScheduler 当前时间是：" + sf.format(date));

        //创建一个JobDetail实例 将该实例与 HelloJob Class绑定
        JobDetail jobDetail = JobBuilder
                .newJob(CronJob.class)
                .withIdentity("myJob", "group1")
                .build();

        //每秒钟触发一次任务
        CronTrigger trigger = (CronTrigger)TriggerBuilder.newTrigger().
                withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))//*表示 每次 的意思
                .build();


        //创建Scheduler实例
        SchedulerFactory sfc = new StdSchedulerFactory();
        Scheduler scheduler = sfc.getScheduler();
        scheduler.start();

        scheduler.scheduleJob(jobDetail, trigger);

        //设置在scheduler执行2s中之后挂起
        Thread.sleep(2000L);
        scheduler.standby();

        //scheduler挂起3s后继续执行
        Thread.sleep(3000L);
        scheduler.start();
    }
}
