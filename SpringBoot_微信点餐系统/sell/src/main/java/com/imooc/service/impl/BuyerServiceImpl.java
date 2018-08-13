package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kenshin
 * @date 2018/7/27 上午11:36
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        return checkOrdetOwner(openid, orderId);

    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {

        OrderDTO orderDTO = checkOrdetOwner(openid, orderId);
        if (orderDTO == null){
            log.error("【取消订单】无此订单. openid={}", openid);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);//订单不存在
        }

        OrderDTO resultOrderDTO = orderService.cancel(orderDTO);
        return resultOrderDTO;

    }

    /**
     * 查询订单 如果openid错误 就抛异常
     * @param openid
     * @param orderId
     * @return
     */
    private OrderDTO checkOrdetOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【查询订单】订单openid不一直. openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);//该订单不属于当前用户
        }
        return orderDTO;
    }

}
