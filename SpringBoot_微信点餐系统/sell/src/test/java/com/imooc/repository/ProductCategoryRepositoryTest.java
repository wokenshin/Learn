package com.imooc.repository;

import com.imooc.dateobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author kenshin
 * @date 2018/7/13 下午4:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    /***
     * 取出一条数据
     */
//    下面的事物注解是在使用 jpa的 getOne方法的时候用到的 因为不那样会报错
//    @Transactional//这个注释 视频里面并没有 不添加的话会报错 详细：https://blog.csdn.net/zlt995768025/article/details/79603479
    @Test
    public void findOneTest(){
        /*
        * 报错：org.hibernate.LazyInitializationException: could not initialize proxy [com.imooc.dateobject.ProductC
        * */
        Optional<ProductCategory> optional = repository.findById(1);
        System.out.println(optional.get().toString());
    }

    /***
     * 新增一条数据
     */
    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("武瑞丰甜品", 11);
//        productCategory.setCategoryId(); 由于是自增字段 所以不用填写
        ProductCategory result =  repository.save(productCategory);
        System.out.println(result);

        //断言判断 如果值 != null 就是正确的
        Assert.assertNotNull(result);

    }

    @Test
//    @Transactional //如果在测试中使用 事物的话，执行sql之后 会立即回滚
    public void updateTest(){
        //没有生效
        Optional<ProductCategory> optional = repository.findById(5);
        ProductCategory productCategory = optional.get();
        productCategory.setCategoryName("瑞瑞甜食店");
        productCategory.setCategoryType(10);
        ProductCategory result =  repository.save(productCategory);
        System.out.println(result);

        //断言判断 如果值 != null 就是正确的
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> listType = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(listType);

        //断言的意思是 结果 !=0 就算成功
        Assert.assertNotEquals(0, result);
    }

}