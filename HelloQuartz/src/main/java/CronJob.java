import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/6/28 上午11:36
 */
public class CronJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("CronJob 当前时间是：" + sf.format(date));

    }
}
