package Java03;

/**
 * @author kenshin
 * @date 2018/5/18 下午5:12
 */
public class HideTest {

    public static void main(String[] args) {

        Drived d = new Drived();
        //程序不可访问Driver的私有变量tag，所以下面的语句将引起错误
        //d.tag = "";
        //将d变量显示地向上转型为Parent后，即可访问tag实例变量
        System.out.println(((Parent)d).tag);

    }

}

class Parent{

    public String tag = "《秘密花园》";

}

class Drived extends Parent{

    private String tag = "《我亲爱的甜橙树》";

}