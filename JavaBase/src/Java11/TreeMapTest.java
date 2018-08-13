package Java11;

import java.util.TreeMap;

/**
 * @author kenshin
 * @date 2018/5/24 上午9:28
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap tm = new TreeMap();
        tm.put(new R(3),  "番茄工作法");
        tm.put(new R(-5), "时间管理");
        tm.put(new R(9),  "学习之道");
        System.out.println(tm);

        System.out.println("返回该TreeMap的第一个Entry对象 " + tm.firstEntry());
        System.out.println("返回TreeMap的最后一个key " + tm.lastKey());
        System.out.println("返回TreeMap的 比 new R（2）大的 最小key值 " + tm.higherKey(new R(2)));
        System.out.println("返回TreeMap的 比 new R（2）小的 最大健值对 " + tm.lowerEntry(new R(2)));
        System.out.println("返回该TreeMap的子TreeMap " + tm.subMap(new R(-1), new R(4)));

    }

}

class R implements Comparable{

    int count;
    public R(int count) {
        this.count = count;
    }

    public String toString(){
        return "R[count:" + count + "]";
    }

    //根据count来判断两个对象是否相等
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == R.class){
            R r = (R)obj;
            if (this.count == r.count){
                return true;
            }
            return false;
        }
        return false;
    }

    //根据count属性值来比较对象的大小
    @Override
    public int compareTo(Object o) {
        R r = (R)o;
        if (count > r.count){
            return 1;
        }
        if (count < r.count){
            return -1;
        }
        return 0;
    }
}
