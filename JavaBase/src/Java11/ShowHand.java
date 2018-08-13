package Java11;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/5/24 上午11:30
 */
public class ShowHand {

    //定义该游戏最多支持多少个玩家
    private final int PLAY_NUM = 5;
    //定义扑克牌的所有花色，和数值
    private String[] types = {"♠️", "♥️", "♣️", "♦️"};
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    //cards 是一局游戏中剩下的扑克牌
    private List<String> cards = new LinkedList<String>();
    //定义所有的玩家
    private String[] players = new String[PLAY_NUM];
    //所有玩家手上的扑克牌
    private List<String>[] playersCards = new List[PLAY_NUM];
    /*
    * 初始化扑克牌，放入52张扑克牌
    * 并且使用shuffle方法 将它们按随机顺序排列
    * */
    public void initCards(){

        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                cards.add(types[i] + values[j]);
            }
        }
        //随机排列
        Collections.shuffle(cards);
    }

    /*
    * 初始化玩家，为每个玩家分派用户名
    * */
    public void initPlayer(String... names)
    {
        if (names.length > PLAY_NUM || names.length < 2){
            //校验玩家数量，此处使用异常机制更合理
            System.out.println("玩家数量不对");
            return;
        }
        else{
            //初始化玩家用户名
            for (int i = 0; i < names.length; i++) {
                players[i] = names[i];
            }
        }
    }

    /*
    * 初始化玩家手上的扑克牌，开始游戏时每个玩家手上的扑克牌为空
    * 程序使用一个长度为0的LinkedList来表示
    * */
    public void initPlayerCards(){
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null && !players[i].equals("")){
                playersCards[i] = new LinkedList<String>();
            }
        }
    }

    /*
    * 输出全部扑克牌，该方法没有实际作用 仅仅用做测试
    * */
    public void showAllCards(){
        for (String card:cards) {
            System.out.println(card);
        }
    }

    /**
    * 派扑克牌
    * @param first 最先派给谁
    * */
    public void deliverCard(String first){
        //调用ArrayUtils工具类的search方法
        //查询出指定元素在数组中的引用
//        int firstPos = ArrayUtils.search(players, first);
    }

    public static void main(String[] args) {

        //本类作废

    }

}
