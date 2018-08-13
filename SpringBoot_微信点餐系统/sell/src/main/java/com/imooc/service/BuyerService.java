package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * 买家
 * @author kenshin
 * @date 2018/7/27 上午11:19
 */
public interface BuyerService {

    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);


}
