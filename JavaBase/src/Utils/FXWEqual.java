package Utils;

import java.math.BigDecimal;

/**
 * @author kenshin
 * @date 2018/7/30 下午5:34
 */
public class FXWEqual {

    public static boolean equalDouble(double a, double b){

        return false;

    }

    public static void main(String[] args) {

        double a = 0.1;
        double b = 0.10;
        BigDecimal c = new BigDecimal(0.100);

        if (a == b){
            System.out.println("a == b");
        }
        else{
            System.out.println("a != b");
        }

        if (new BigDecimal(a) == c){
            System.out.println("a == c");
        }
        else{
            System.out.println("a != c");
        }

    }

}
