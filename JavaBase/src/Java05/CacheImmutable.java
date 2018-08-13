package Java05;

/**
 * @author kenshin
 * @date 2018/5/21 上午10:49
 */
public class CacheImmutable {

    private static int MAX_SIZE = 10;
    //使用数组来缓存已有实例
    private static CacheImmutable[] cache = new CacheImmutable[MAX_SIZE];

    //记录缓存实例在缓存中的位置 cache[pos-1]是最新缓存的实例
    private static int pos = 0;
    private final String name;
    private CacheImmutable(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static CacheImmutable valueOf(String name){
        //遍历已缓存的对象
        for (int i = 0; i <MAX_SIZE ; i++) {
            //如果已有相同实例 则直接返回该缓存的实例
            if (cache[i] != null && cache[i].getName().equals(name)){
                return cache[i];
            }
        }
        //如果缓存池已满
        if (pos == MAX_SIZE){
            //把缓存池的第一个对象替换为当前对象
            cache[0] = new CacheImmutable(name);
            //把pos设为1
            pos = 1;
        }
        else{
            //把新创建的对象缓存起来，pos+1
            cache[pos++] = new CacheImmutable(name);
        }
        return cache[pos-1];
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == CacheImmutable.class){
            CacheImmutable ci = (CacheImmutable)obj;
            return name.equals(ci.getName());
        }
        return false;
    }

    public int hashCode(){
        return name.hashCode();
    }

    public static void main(String[] args) {
        //缓存
        CacheImmutable c1 = CacheImmutable.valueOf("hell0");
        CacheImmutable c2 = CacheImmutable.valueOf("hell0");
        //下面代码将输出true
        System.out.println(c1 == c2);

    }
}
