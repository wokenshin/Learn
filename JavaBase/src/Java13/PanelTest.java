package Java13;

import java.awt.*;

/**
 * @author kenshin
 * @date 2018/5/29 上午11:38
 */
public class PanelTest {

    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        //创建一个panel容器
        Panel p = new Panel();
        //向Panel容器中添加两个组件
        p.add(new TextField(20));
        p.add(new Button("点击我"));
        //将panel容器添加到frame窗口中
        f.add(p);
        //设置窗口的大小和位置
        p.setBounds(30, 30, 250, 250);
        //将窗口显示出来
        f.setVisible(true);

    }
}
