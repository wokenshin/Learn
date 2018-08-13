package Java13;

/**
 * @author kenshin
 * @date 2018/5/29 上午10:18
 */
public class ActionException extends Exception {

    //无参数的构造器
    public ActionException(){}

    //带一个参数的构造器
    public ActionException(String msg){
        super(msg);
    }
}
