package Java02;

/**
 * @author kenshin
 * @date 2018/5/18 上午9:57
 */
public class RecursiveDemo {

    public static void main(String[] args){

        //递归
        /*
        * f(0) = 1
        * f(1) = 4
        * f(n+2) = 2 * f(n+1) + f(n); n>0 求f(10)?
        * */
        System.out.println(fn(10));
    }

    public static int fn(int num){

        if (num < 0){
            return 0;
        }
        else if(num == 0){
            return 1;
        }
        else if(num == 1){
            return 4;
        }
        else{
            return (2*fn(num-1) + fn(num-2));
            /*
            * logic 犹豫递归应该朝向已知的数据推到结果 也就只我们已知 f(0)=1; f(1)=4
            * 所以我们的递归参数最终应该越来越小 这样才能根据已知结果倒推未知结果
            * 因此将等式  f(n+2) = 2 * f(n+1) + f(n) 中的 n+2 看作一个整体 X
            * 得出 f(X) = 2 * f(X-1) + f(X-2)
            * 所以得出 这里的return
            * */
        }

    }

}
