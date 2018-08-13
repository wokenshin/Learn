package com.imooc.repository;

import com.imooc.dateobject.SellerInfo;
import com.imooc.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author kenshin
 * @date 2018/8/2 下午3:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    /**
     * 新增
     */
    @Test
    public void save(){
        SellerInfo info = new SellerInfo();
        info.setSellerId(KeyUtil.genUniqueKey());
        info.setUsername("范希望");
        info.setPassword("kenshin");
        info.setOpenid("313911762");

        SellerInfo resultInfo = sellerInfoRepository.save(info);
        Assert.assertTrue("新增卖家", resultInfo != null);

    }
    /**
     * 查询
     */
    @Test
    public void findByOpenid() {
        SellerInfo sellerInfo = sellerInfoRepository.findByOpenid("313911762");
        Assert.assertTrue("查询卖家信息", sellerInfo != null);
    }
}