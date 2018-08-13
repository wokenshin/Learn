package com.imooc.enums;

import lombok.Getter;

/**
 * 商品状态
 * @author kenshin
 * @date 2018/7/15 下午5:51
 */
@Getter//提供get方法
public enum ProductStatusEnum implements CodeEnum{
    UP(0, "上架"),
    DOWN(1, "下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
