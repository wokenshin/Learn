package Java16;

/**
 * @author kenshin
 * @date 2018/6/1 下午5:48
 */
public class MultiThreadDown {

    public static void main(String[] args) throws Exception {
        final DownUtil downUtil = new DownUtil("http://img.zcool.cn/community/01b5ff5621157032f87557019c89de.jpg@2o.jpg",
                "ios.png",
                4);

        //开始下载[图片下载好之后 就保存在工程的根路径下]
        try {
            downUtil.download();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            while (downUtil.getCompleteRate() < 1){
                //每隔0.1s查询一下进度
                System.out.println("已完成：" + downUtil.getCompleteRate());
            }
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }).start();

    }
}
