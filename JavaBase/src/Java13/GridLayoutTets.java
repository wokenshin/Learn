package Java13;

import java.awt.*;

/**
 * @author kenshin
 * @date 2018/5/29 下午2:36
 */
public class GridLayoutTets {

    public static void main(String[] args) {
        Frame f = new Frame("计算器");

        Panel p1 = new Panel();
        p1.add(new TextField(30));
        f.add(p1, BorderLayout.NORTH);

        Panel p2 = new Panel();
        //设置p2用GridLayout布局
        p2.setLayout(new GridLayout(3, 5, 4, 4));
        String[] name = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/","." };
        //向Panel中一次加入15个按钮
        for (int i = 0; i < 15; i++) {
            p2.add(new Button(name[i]));
        }

        //默认将p2对象添加到frame窗口中
        f.add(p2);
        f.pack();
        f.setVisible(true);
    }
}
