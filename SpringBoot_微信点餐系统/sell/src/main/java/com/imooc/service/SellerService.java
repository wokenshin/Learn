package com.imooc.service;

import com.imooc.dateobject.SellerInfo;

/**
 * 卖家端
 * @author kenshin
 * @date 2018/8/2 下午3:26
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenId(String openid);

}
