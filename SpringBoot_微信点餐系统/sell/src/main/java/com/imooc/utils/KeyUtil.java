package com.imooc.utils;

import java.util.Random;

/**
 * @author kenshin
 * @date 2018/7/19 下午11:18
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * synchronized 这个关键子的作用是 防止多线程并发时产生重复值
     * @return
     */
    public static synchronized String genUniqueKey(){

        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;//生成六位数随机数 左边生成的随机数范围在 [0,9000000) + 1000000 == [1000000, 9000000)

        return System.currentTimeMillis() + String.valueOf(number);
    }

}
