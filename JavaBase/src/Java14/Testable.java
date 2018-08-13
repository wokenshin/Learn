package Java14;

import java.lang.annotation.*;

/**
 * @author kenshin
 * @date 2018/5/30 上午9:19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Testable {

}

class MyClass{

    @Testable
    public void info(){
        System.out.println("info method");
    }
}
