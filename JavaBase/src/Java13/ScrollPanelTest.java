package Java13;

import java.awt.*;

/**
 * @author kenshin
 * @date 2018/5/29 上午11:47
 */
public class ScrollPanelTest {

    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        //创建一个ScrollPanel指定总是具有滚动条
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        //向ScrollPane中添加两个组件
        sp.add(new TextField(20));
        sp.add(new Button("点击我"));
        f.add(sp);
        f.setBounds(30, 30, 250, 120);
        f.setVisible(true);

    }
}
