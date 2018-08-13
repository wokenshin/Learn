//package Java13;
//
///**
// * @author kenshin
// * @date 2018/5/29 上午10:29
// */
//public class AuctionTest {
//
//    private double initPrice = 30.0;
//    //因为该方法中显式抛出里AuctionException异常
//    //所以此处需要声明抛出异常
//    public void bid(String bidPrice){
//        double d = 0.0;
//        try {
//            d = Double.parseDouble(bidPrice);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            throw new AuctionException("竞拍价必须是数值，不能包含其他字符串");
//        }
//        if (initPrice > d){
//            throw new AuctionException("竞拍价比起拍价低，不能包含其他字符串");
//        }
//        initPrice = d;
//    }
//
//    public static void main(String[] args) {
//        AutoCloseTest at = new AutoCloseTest();
//        try {
//            at.bid("ff");
//        }
//        catch (AuctionException ae){
//            System.out.println(ae.getMessage());
//        }
//    }
//}
