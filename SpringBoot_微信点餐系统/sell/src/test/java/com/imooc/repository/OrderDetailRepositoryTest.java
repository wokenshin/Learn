package com.imooc.repository;

import com.imooc.dateobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author kenshin
 * @date 2018/7/17 下午11:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1002430");
        orderDetail.setOrderId("110110");
        orderDetail.setProductId("121414");
        orderDetail.setProductName("素粉");
        orderDetail.setProductPrice(new BigDecimal(2.5));
        orderDetail.setProductQuantity(100);
        orderDetail.setProductIcon("http://www.xxx.jpg");
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrderId() {
         List<OrderDetail> orderDetailList = repository.findByOrderId("110110");
         Assert.assertNotEquals(0, orderDetailList.size());
    }
}