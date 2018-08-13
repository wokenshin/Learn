package com.imooc.repository;

import com.imooc.dateobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kenshin
 * @date 2018/7/17 下午10:30
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /***
     * 按照买家的openId来进行分页查询
     * @param buyerOpenId 买家openId
     * @param pageable    分页
     * @return 如果参数不设置 Pageable 将不会分页 一次返回所有符合条件的数据
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
