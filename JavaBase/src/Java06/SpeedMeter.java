package Java06;

/**
 * @author kenshin
 * @date 2018/5/21 上午11:48
 */
public abstract class SpeedMeter {

    //转速
    private double turnRate;
    public SpeedMeter(){};

    //把返回车轮半径的方法定义成抽象方法
    public abstract double getRadius();
    public void setTurnRate(double turnRate){
        this.turnRate = turnRate;
    }

    //定义计算速度的通用方法
    public double getSpeed(){

        return  2 * Math.PI * getRadius() * turnRate;

    }

}

class CarSpeedMeter extends SpeedMeter{

    public double getRadius(){
        return 0.28;
    }

    public static void main(String[] args) {
        CarSpeedMeter cas = new CarSpeedMeter();
        cas.setTurnRate(15);
        System.out.println(cas.getSpeed());
    }

}
