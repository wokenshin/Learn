package Java13;

import java.awt.*;

/**
 * @author kenshin
 * @date 2018/5/29 下午2:29
 */
public class BorderLayoutTest2 {

    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("南"), BorderLayout.SOUTH);
        f.add(new Button("北"), BorderLayout.NORTH);

        //创建一个Panel对象
        Panel p = new Panel();
        p.add(new TextField(20));
        p.add(new Button("单击我"));

        //默认添加到中间区域中,向中间区域添加一个panel容器
        f.add(p);
        f.add(new Button("东"), BorderLayout.EAST);

        //设置窗口为最佳大小
        f.pack();
        f.setVisible(true);
    }
}
