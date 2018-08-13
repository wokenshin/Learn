package com.imooc.service;

import com.imooc.dateobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 * @author kenshin
 * @date 2018/7/15 下午5:39
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /***
     * 查询上架的商品列表 查询条件 状态为 0
     * @return
     */
    List<ProductInfo> findUpAll();

    /***
     * 分页查询 商品
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存 取消订单的时候需要加库存，
     * @param cartDTOList 购物车列表
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存 下订单的时候需要减库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架
     * @param productId
     * @return
     */
    ProductInfo onSale(String productId);

    /**
     * 下架
     * @param productId
     * @return
     */
    ProductInfo offSale(String productId);


}
