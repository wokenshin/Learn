package com.imooc.service.impl;

import com.imooc.dateobject.ProductInfo;
import com.imooc.dto.CartDTO;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.repository.ProductInfoRepository;
import com.imooc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author kenshin
 * @date 2018/7/15 下午5:46
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        Optional<ProductInfo> optional = repository.findById(productId);
        if (optional.isPresent()){
            ProductInfo info = optional.get();
            return info;
        }
        else{
            return null;
        }

    }

    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> list = repository.findByProductStatus(ProductStatusEnum.UP.getCode());
        return list;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    /**
     * 加库存
     * @param cartDTOList 购物车列表
     */
    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDto: cartDTOList) {

            ProductInfo productInfo = repository.getOne(cartDto.getProductId());

            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);//商品不存在
            }

            Integer result = productInfo.getProductStock() + cartDto.getProductQuantity();
            //增加库存，并保存
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    /**
     * 减库存
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDto: cartDTOList) {

            ProductInfo productInfo = repository.getOne(cartDto.getProductId());

            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);//商品不存在
            }

            Integer result = productInfo.getProductStock() - cartDto.getProductQuantity();
            if (result < 0){//库存不足
                throw new SellException(ResultEnum.PRODUCT_STOCK_NOT_ENOUGH);
            }

            //减库存，并保存
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    /**
     * 上架
     * @param productId
     * @return
     */
    @Override
    public ProductInfo onSale(String productId) {

        //1.查询到商品
        Optional<ProductInfo> optional = repository.findById(productId);
        if (!optional.isPresent() || optional.get() == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);//商品不存在
        }

        ProductInfo productInfo = optional.get();
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP){
            //说明商品已上架
            throw new SellException(ResultEnum.PRODUCT_STATUC_ERROR);//商品已上架 不允许再修改
        }

        //2.修改上平状态为 上架
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(productInfo);

    }

    /**
     * 下架
     * @param productId
     * @return
     */
    @Override
    public ProductInfo offSale(String productId) {

        //1.查询到商品
        Optional<ProductInfo> optional = repository.findById(productId);
        if (!optional.isPresent() || optional.get() == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);//商品不存在
        }

        ProductInfo productInfo = optional.get();
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN){
            //说明商品已下架
            throw new SellException(ResultEnum.PRODUCT_STATUC_ERROR);//商品已下架 不允许再修改
        }

        //2.修改上平状态为 下架
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }
}
