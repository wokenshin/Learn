package com.imooc.service.impl;

import com.imooc.dateobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kenshin
 * @date 2018/7/15 下午4:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory category = categoryService.findOne(5);
        Assert.assertNotNull(category);

    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotNull(list);

    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> listType = Arrays.asList(1,2,3);
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(listType);
        Assert.assertNotNull(list);

    }

    @Test
    public void save() {
        ProductCategory category = new ProductCategory("kenshin",12);
        ProductCategory tmp =  categoryService.save(category);
        Assert.assertNotNull(tmp);

    }
}