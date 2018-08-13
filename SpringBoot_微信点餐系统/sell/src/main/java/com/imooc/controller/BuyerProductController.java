package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dateobject.ProductCategory;
import com.imooc.dateobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.service.impl.ProductServiceImpl;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 买家商品
 * @author kenshin
 * @date 2018/7/15 下午10:35
 */
@RestController
@RequestMapping("/buyer/product")//设置以个url的前缀
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product", key = "123")//首次访问时会进入方法内部，将返回的数据序列化后保存到redis中，下次请求的时候就不会在进入方法了，而是直接从redis中获取缓存数据，除非redis数据被更新
    public ResultVO list(){

        /*
        * 逻辑
        * 1、查询所有的上架商品
        * 2、查询类目[一次性查询]
        * 3、数据拼装
        *
        * */

        //1、查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2、查询类目[一次性查询]
        List<Integer> categoryTypeList = new ArrayList<>();

        //下面的for 也可以用 lambda表达式来实现 略
        for (ProductInfo productInfo : productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //a 遍历类目
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVOTmp = new ProductVO();
            productVOTmp.setCategoryType(productCategory.getCategoryType());
            productVOTmp.setCategoryName(productCategory.getCategoryName());

            //遍历商品详情
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){

                //判断类目是否相等
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVOTmp = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVOTmp);
                    productInfoVOList.add(productInfoVOTmp);
                }
            }
            productVOTmp.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVOTmp);
        }

        return ResultVOUtil.success(productVOList);
    }


}
