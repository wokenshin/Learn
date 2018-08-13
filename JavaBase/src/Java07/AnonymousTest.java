package Java07;

/**
 * @author kenshin
 * @date 2018/5/21 下午4:51
 */
public class AnonymousTest {

    public void test(Produce2 p){
        System.out.println("购买类一个:" + p.getName() + ", 花费类:" + p.getPrice());
    }



    public static void main(String[] args) {
        AnonymousTest ta = new AnonymousTest();
        //调用test方法需要传入一个Produce2参数
        //此处传入其匿名实现类的实例
        ta.test(new Produce2() {
            @Override
            public double getPrice() {
                return 567.8;
            }

            @Override
            public String getName() {
                return "玩具飞机";
            }
        });
    }

}

interface Produce2{

    public double getPrice();
    public String getName();
}