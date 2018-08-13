package Java08;

/**
 * @author kenshin
 * @date 2018/5/22 上午8:57
 */
public enum  SeasonEnum {

    //在第一行写出四个枚举实例
    SPRING,SUMMER,FALL,WINTER;
}

class EnumTest{

    public void judge(SeasonEnum s){
        switch (s){
            case SPRING:{
                System.out.println("春");
                break;
            }
            case SUMMER:{
                System.out.println("夏");
                break;
            }
            case FALL:{
                System.out.println("秋");
                break;
            }
            case WINTER:{
                System.out.println("冬");
                break;
            }
        }
    }
    public static void main(String[] args) {

        //枚举类默认有一个values()方法 返回该枚举类的所有实例
        for (SeasonEnum s:SeasonEnum.values()) {
            System.out.println(s);
        }

        //使用枚举实例时，可通过EnumClass.variable形式来访问
        new EnumTest().judge(SeasonEnum.SPRING);

        //输出main函数中 数组的长度 并遍历数组中的每一个元素
        System.out.println(args.length);
        for (String str: args) {
            System.out.println(str);
        }

    }

}
