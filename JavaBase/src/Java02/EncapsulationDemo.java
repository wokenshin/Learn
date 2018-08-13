package Java02;

/**
 * @author kenshin
 * @date 2018/5/18 下午2:06
 */
public class EncapsulationDemo {

    //访问控制级别由小到大
    //private --> default --> protected --> public

    //封装
    public static void main(String[] args) {

        PersonDemo demo = new PersonDemo();
//        demo.setName("kenshin");
//        demo.setAge(1000);
        demo.setName("希望");
        demo.setAge(100);
        System.out.println("my name is " + demo.getName() + " age is " + demo.getAge());

    }

}

