package com.imooc.service.impl;

import com.imooc.dateobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author kenshin
 * @date 2018/7/15 下午5:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo info = productService.findOne("123456");
        Assert.assertNotNull(info);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertNotNull(list);
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0, 2);
        Page<ProductInfo> productInfos = productService.findAll(request);
        System.out.println("所有元素: " + productInfos.getTotalElements());
        Assert.assertNotNull(productInfos);

    }

    @Test
    public void save() {

        ProductInfo info = new ProductInfo();
        info.setProductId("1234567");
        info.setProductName("八宝饭");
        info.setProductPrice(new BigDecimal(4.2));
        info.setProductStock(100);
        info.setProductDescription("很好吃");
        info.setProductIcon("http://wwww.xxx3.jpg");
        info.setProductStatus(ProductStatusEnum.DOWN.getCode());
        info.setCategoryType(2);//2 是 热销榜

        ProductInfo result = productService.save(info);
        Assert.assertNotNull(result);
    }

    //测试修改商品上架
    @Test
    public void onSale(){

        ProductInfo productInfo = productService.onSale("2312");
        Assert.assertTrue("修改商品上架", productInfo!=null && productInfo.getProductStatus() == ProductStatusEnum.UP.getCode());
    }

    //测试修改商品下架
    @Test
    public void offSale(){

        ProductInfo productInfo = productService.offSale("2312");
        Assert.assertTrue("修改商品上架", productInfo!=null && productInfo.getProductStatus() == ProductStatusEnum.DOWN.getCode());

    }
}