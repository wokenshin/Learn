package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.service.PushMessage;
import org.springframework.stereotype.Service;

/**
 * @author kenshin
 * @date 2018/8/3 上午11:37
 */
@Service
public class PushMessageImpl implements PushMessage {

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        //不写了 微信相关的账号没有 而且这里教程中 使用的是第三方SDK来操作的 
    }
}
