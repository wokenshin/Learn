package com.imooc.dateobject.mapper;

import com.imooc.dateobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author kenshin
 * @date 2018/7/17 下午11:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() {

        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "爱吃不吃");
        map.put("category_type", 101);
        int a = mapper.insertByMap(map);
        Assert.assertTrue("插入数据", a > 0);

    }

    @Test
    public  void insertByObject(){
        Map<String, Object> map = new HashMap<>();
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("爱吃不吃系列");
        productCategory.setCategoryType(15);
        int a = mapper.insertByObject(productCategory);
        Assert.assertTrue("插入数据", a > 0);
    }

    @Test
    public void findByCategoryType(){
        ProductCategory category = mapper.findByCategoryType(10);
        Assert.assertTrue("查询类目", category != null);
    }

    @Test
    public void findByCategoryName(){
        List<ProductCategory> productCategoryList = mapper.findByCategoryNme("爱吃不吃");
        Assert.assertTrue("查询类目", productCategoryList.size() > 0);
    }

    @Test
    public void updateCategoryName(){
        int result = mapper.updateByCatgeoryType("好吃得很", 100);
        Assert.assertTrue("修改类目名称", result > 0);
    }

    @Test
    public void updateByObject(){

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(100);
        productCategory.setCategoryName("安逸惨咯");

        int result = mapper.updateByObject(productCategory);
        Assert.assertTrue("修改类目名称", result > 0);
    }

    @Test
    public void deleteByCategoryType(){

        int result = mapper.deleteByCategoryType(100);
        Assert.assertTrue("删除类目", result > 0);
    }

    @Test
    public void selectByCategoryType(){
        ProductCategory productCategory = mapper.selectByCategoryType(101);
        Assert.assertTrue("通过xml查询类目", productCategory != null);

    }

}