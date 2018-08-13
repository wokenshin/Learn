package com.imooc.repository;


import com.imooc.dateobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author kenshin
 * @date 2018/7/13 下午4:34
 */
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
