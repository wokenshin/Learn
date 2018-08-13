package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * 微信 消息推送
 * @author kenshin
 * @date 2018/8/3 上午11:35
 */
public interface PushMessage {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
