package Java02;

/**
 * @author kenshin
 * @date 2018/5/18 下午2:31
 */
public class PersonDemo {
    //使用private修饰成员变量 将这些成员变量隐藏起来
    private String name;
    private int age;

    //提供方法来操作name成员变量
    public void setName(String name){
        //执行合理性校验，要求用户名必须在2~6位之间
        if (name.length() > 6 || name.length() <  2){
            System.out.println("您设置的人名不符合要求");
            return;
        }
        else{
            this.name = name;
        }
    }

    public String getName(){
        return this.name;
    }

    //提供方法来操作age

    public void setAge(int age) {
        if (age > 200 || age < 0){
            System.out.println("您设置的年龄不符合要求");
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
