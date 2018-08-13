package com.imooc.repository;

import com.imooc.dateobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kenshin
 * @date 2018/7/15 下午5:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo info = new ProductInfo();
        info.setProductId("123456");
        info.setProductName("皮蛋粥");
        info.setProductPrice(new BigDecimal(3.2));
        info.setProductStock(100);
        info.setProductDescription("很好喝的粥");
        info.setProductIcon("http://wwww.xxx.jpg");
        info.setProductStatus(0);
        info.setCategoryType(2);//2 是 热销榜
        ProductInfo tmp = repository.save(info);
        Assert.assertNotNull(tmp);
    }

    /***
     * 查询上架的商品
     */
    @Test
    public void findByProductStatus() {

        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotNull(list);
    }
}