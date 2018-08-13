import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/6/28 上午1:17
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {

        //打印当前的时间
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("HelloScheduler 当前时间是：" + sf.format(date));


        //创建一个JobDetail实例 将该实例与 HelloJob Class绑定
        JobDetail jobDetail = JobBuilder
                .newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .usingJobData("stringJobValue", "hello myJob1")
                .usingJobData("floatJobValue", 3.14f)
                .usingJobData("testKey", "jobStringValue")
                .usingJobData("way2_stringValue", "kenshin")
                .build();


//        System.out.println("JobDetail's name " + jobDetail.getKey().getName());
//        System.out.println("JobDetail's group " + jobDetail.getKey().getGroup());
//        System.out.println("JobDetail's class " + jobDetail.getClass().getName());

        //创建一个Trigger实例 定义该job立即执行 并且每隔2s 重复执行 直到永远
        Trigger trigger = TriggerBuilder.newTrigger().
                withIdentity("myTrigger", "group1").
                usingJobData("stringTriggerValue", "hello myTrigger1")
                .usingJobData("doubleTriggerValue", 3.14)
                .usingJobData("testKey", "triggerStringValue")
                .usingJobData("way2_floatValue", 3.14F)
                .startNow()
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
