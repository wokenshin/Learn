package com.imooc.repository;

import com.imooc.dateobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author kenshin
 * @date 2018/7/15 下午5:15
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /***
     * 根据状态查询商品 如查询上架商品 传0      查询下架商品 传1
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
