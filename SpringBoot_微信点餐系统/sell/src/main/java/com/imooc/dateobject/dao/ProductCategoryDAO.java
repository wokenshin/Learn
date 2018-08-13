package com.imooc.dateobject.dao;

import com.imooc.dateobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author kenshin
 * @date 2018/8/7 上午10:39
 */
public class ProductCategoryDAO {

    @Autowired
    private ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map){
        return mapper.insertByMap(map);
    }
}
