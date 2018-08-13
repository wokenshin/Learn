import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/6/28 上午1:12
 */
public class HelloJob implements Job {

    //可以通过 dataMap的方法就行参数传递

    //也可以通过与设置dataMap同名成员变量 的方法进行参数传递[这里的参数在外部 还是通过 usingJobData 来设置值]
    private String way2_stringValue;
    private Float  way2_floatValue;

    public String getWay2_stringValue() {
        return way2_stringValue;
    }

    public void setWay2_stringValue(String way2_stringValue) {
        this.way2_stringValue = way2_stringValue;
    }

    public Float getWay2_floatValue() {
        return way2_floatValue;
    }

    public void setWay2_floatValue(Float way2_floatValue) {
        this.way2_floatValue = way2_floatValue;
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //编写具体的业务逻辑

        //为了看起来更具体，这里我们打印当前的执行时间

        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("Hello World 当前时间是：" + sf.format(date));

        //获取job的信息
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("job组：" + jobKey.getGroup() + "   job名：" + jobKey.getName());

        //获取trigger的信息
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("trigger组：" + triggerKey.getGroup() + "   trigger名：" + triggerKey.getName());

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap triggerDataMap = jobExecutionContext.getTrigger().getJobDataMap();

        String jobMsg = jobDataMap.getString("stringJobValue");
        float jobFloatV = jobDataMap.getFloat("floatJobValue");

        String triggerMsg = triggerDataMap.getString("stringTriggerValue");
        double triggerDoubleV = triggerDataMap.getDouble("doubleTriggerValue");

        System.out.println("jobMsg:"+ jobMsg + ", jobFloatValue:" + jobFloatV);
        System.out.println("triggerMsg:"+ triggerMsg + ", triggerDoubleValue:" + triggerDoubleV);


        //上面通过 getJobDataMap 和 getJobDataMap 分别获取了各自dataMap中的数据
        //下面可以通过 一个方法来获取 两者合并之后的 dataMap
        //如果 两者dataMap中有相同的key，trigger中的key将会覆盖掉job中的key 比如这里的 "testKey"

        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        System.out.println("获取合并后的dataMao中的数据：" + dataMap.getString("testKey"));


        //通过第二种方式获取参数
        System.out.println("获取dataMap中数据 方法二： string:"+way2_stringValue + "   float:"+ way2_floatValue);

        System.out.println("—————————————————————————————————分割线—————————————————————————————————————————");

    }
}
