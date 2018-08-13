package Java07;

/**
 * @author kenshin
 * @date 2018/5/21 下午4:27
 */
public class Cow {

    private double weight;

    //外部类的两个重载的构造器
    public Cow(){};

    public Cow(double weight){
        this.weight = weight;
    }

    //定义一个非静态内部类
    private class CowLeg{

        //非静态内部类的2个实例变量
        private double length;
        private String color;

        //非静态内部类的2个重载构造器
        public CowLeg(){}

        public CowLeg(double length, String color){
            this.length = length;
            this.color  = color;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        //非静态内部类的实例方法
        public void info(){
            System.out.println("当前牛腿的颜色：" + color + "高：" + length);
            //直接访问外部类的private修饰的成员变量
            System.out.println("本牛腿所在奶牛重：" + weight);
        }

    }

    public void test(){
        CowLeg cl = new CowLeg(1.12, "黑白相间");
        cl.info();
    }

    public static void main(String[] args) {
        Cow cow = new Cow(378.9);
        cow.test();
    }

}
