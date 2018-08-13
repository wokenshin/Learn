package com.imooc.constant;

/**
 * Redis常量
 * @author kenshin
 * @date 2018/8/3 上午9:19
 */
public interface RedisConstant {

    //前缀
    String TOKEN_PREFIX = "token_%s";

    //[过期时间]2小时 单位是秒
    Integer EXPIRE = 7200;

}
