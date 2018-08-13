import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/6/28 上午10:40
 */
public class SecondJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("SecondJob 当前时间是：" + sf.format(date));


        Trigger currentTrigger = jobExecutionContext.getTrigger();
        System.out.println("开始时间：" + sf.format(currentTrigger.getStartTime()));
        System.out.println("结束时间：" + sf.format(currentTrigger.getEndTime()));

        JobKey jobKey = currentTrigger.getJobKey();
        System.out.println("jobName: " + jobKey.getName() + "  jobGroup:" + jobKey.getGroup());

        System.out.println("—————————————————————————————————分割线—————————————————————————————————————————");
    }
}
