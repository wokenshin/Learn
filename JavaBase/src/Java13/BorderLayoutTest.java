package Java13;

import java.awt.*;

/**
 * @author kenshin
 * @date 2018/5/29 下午2:24
 */
public class BorderLayoutTest {

    public static void main(String[] args) {
        Frame f = new Frame();
        //使用BorderLayout布局
        f.setLayout(new BorderLayout(30, 5));

        f.add(new Button("东"), BorderLayout.EAST);
        f.add(new Button("南"), BorderLayout.SOUTH);
        f.add(new Button("西"), BorderLayout.WEST);
        f.add(new Button("北"), BorderLayout.NORTH);
        f.add(new Button("中"));

        //设置窗口为最佳大小
        f.pack();
        f.setVisible(true);

    }
}
