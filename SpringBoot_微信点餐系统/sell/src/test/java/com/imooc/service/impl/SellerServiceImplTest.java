package com.imooc.service.impl;

import com.imooc.dateobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author kenshin
 * @date 2018/8/2 下午3:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findSellerInfoByOpenId() {
        SellerInfo info = sellerService.findSellerInfoByOpenId("313911762");
        Assert.assertTrue("查询卖家信息", info != null);
    }
}