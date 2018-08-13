package Java13;

import java.awt.*;

/**
 * @author kenshin
 * @date 2018/5/29 下午2:15
 */
public class FlowLayoutTest {

    public static void main(String[] args) {
        Frame f = new Frame("测试窗口");
        //设置frame容器使用FlowLayout布局管理器
        f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));

        //想窗口中添加10个按钮
        for (int i = 0; i < 10; i++) {
            f.add(new Button("按钮" + i));
        }

        //设置窗口为最佳大小
        f.pack();
        //将窗口显示出来
        f.setVisible(true);
    }
}
