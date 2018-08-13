import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/6/28 下午2:35
 */
public class CronSecondJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("CronSecondJob 当前时间是：" + sf.format(date));

    }

}
