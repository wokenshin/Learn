package Java04;

/**
 * @author kenshin
 * @date 2018/5/19 下午2:59
 */
public class MyToString {

    public static void main(String[] args) {
        //重写 toString方法
        Apple a = new Apple();
        a.setColor("红色");
        a.setWeight(500);
        System.out.println(a);
    }

}

class Apple{

    private String color;
    private double weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Apple(){}

    public Apple(String color, double weight){
        this.color  = color;
        this.weight = weight;
    }

    //重写 toString（）方法，用于实现 Apple 对象的“自我描述”
    public String toString(){
        return "一个苹果，颜色是 " + color + " 重量是 " + weight;
    }


}