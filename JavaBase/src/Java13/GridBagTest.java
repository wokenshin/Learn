package Java13;

import java.awt.*;

/**
 * @author kenshin
 * @date 2018/5/29 下午2:47
 */
public class GridBagTest {

    private Frame f = new Frame("测试窗口");
    private GridBagLayout gb = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private Button[] bs = new Button[10];

    public void init(){
        f.setLayout(gb);
        for (int i = 0; i <bs.length ; i++) {
            bs[i] = new Button("按钮" + i);
        }
        //所有组件都可以在横向，纵向上扩大
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        addButton(bs[0]);
        addButton(bs[1]);
        addButton(bs[2]);
        //该GridBagConstraints控制的GUI组件将会成为横向最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(bs[3]);

        //该GridBagConstraints控制的GUI组件将向上不会扩展
        gbc.weightx = 0;
        addButton(bs[4]);

        //该GridBagConstraints控制的GUI组件将会横跨两个网格
        gbc.gridwidth = 2;
        addButton(bs[5]);

        //该GridBagConstraints控制的GUI组件将横跨一个网格
        gbc.gridwidth = 1;
        //该GridBagConstraints控制的GUI组件将在纵向上横跨两个网格
        gbc.gridheight = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(bs[6]);
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weighty = 1;
        addButton(bs[7]);

        gbc.weighty = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        addButton(bs[8]);
        addButton(bs[9]);
        f.pack();
        f.setVisible(true);
    }

    private void addButton(Button button){
        gb.setConstraints(button, gbc);
        f.add(button);
    }

    public static void main(String[] args) {
        new GridBagTest().init();
    }
}























