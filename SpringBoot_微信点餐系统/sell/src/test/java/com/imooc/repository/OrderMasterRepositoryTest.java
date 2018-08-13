package com.imooc.repository;

import com.imooc.dateobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author kenshin
 * @date 2018/7/17 下午10:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String BUYER_OPENID = "110110";
    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123124357");
        orderMaster.setBuyerName("kenshin");
        orderMaster.setBuyerPhone("18385099600");
        orderMaster.setBuyerAddress("贵阳市高新区管委会");
        orderMaster.setBuyerOpenid(BUYER_OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
        //不知道为什么 新增加的数据 没有设置上 创建时间 和 更新时间的值
    }

    @Test
    public void findByBuyerOpenid() {
        Page<OrderMaster> orderMasterPage = repository.findByBuyerOpenid(BUYER_OPENID, new PageRequest(0, 10));
        Assert.assertNotEquals(0, orderMasterPage.getTotalElements());

    }

}