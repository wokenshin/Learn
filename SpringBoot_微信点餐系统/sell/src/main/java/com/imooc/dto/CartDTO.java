package com.imooc.dto;

import lombok.Data;

/**
 * 购物车
 * @author kenshin
 * @date 2018/7/19 下午11:47
 */
@Data
public class CartDTO {

    /**
     * 商品id
     */
    private String productId;

    /**
     * 数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
