package com.imooc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author kenshin
 * @date 2018/7/30 下午3:58
 */
public class JsonUtil {

    /**
     * 将字典对象以json格式输出 主要用与控制台输出格式化字符串
     * @param object
     * @return
     */
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

}
