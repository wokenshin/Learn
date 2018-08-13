package com.imooc.service;

import com.imooc.dateobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @author kenshin
 * @date 2018/7/15 下午4:26
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
