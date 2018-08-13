package com.imooc.repository;

import com.imooc.dateobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kenshin
 * @date 2018/8/2 下午3:11
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);

}
