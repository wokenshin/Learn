package com.imooc.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author kenshin
 * @date 2018/8/2 上午8:40
 */
@Data
public class ProductForm {


    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 编号. */
    private Integer categoryType;
}
