package com.imooc.form;

import lombok.Data;

/**
 * @author kenshin
 * @date 2018/8/2 上午11:19
 */
@Data
public class CategoryForm {

    /** 类目id. */
    private Integer categoryId;

    /** 类目名称. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

}
