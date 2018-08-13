package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * @author kenshin
 * @date 2018/7/15 下午11:06
 */
@Data
public class ProductVO<T> implements Serializable {

    private static final long serialVersionUID = 7097863777546530545L;

    @JsonProperty("name")//该注解的意思是返回的属性为 name， 而后台实际的属性是 categoryName
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
