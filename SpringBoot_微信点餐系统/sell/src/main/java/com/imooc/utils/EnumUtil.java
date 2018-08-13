package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * @author kenshin
 * @date 2018/7/31 上午11:25
 */
public class EnumUtil {

    public static<T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
