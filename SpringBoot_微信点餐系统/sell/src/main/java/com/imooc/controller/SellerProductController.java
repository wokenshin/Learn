package com.imooc.controller;

import com.imooc.dateobject.ProductCategory;
import com.imooc.dateobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.exception.SellException;
import com.imooc.form.ProductForm;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 卖家端商品
 * @author kenshin
 * @date 2018/8/1 下午2:37
 */
@Slf4j
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 商品列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map){

        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);

        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("currentSize", size);
        return new ModelAndView("/product/list", map);//第一个参数是模版的名字

    }

    /**
     * 商品上架
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("/on_sall")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                               Map<String, Object> map){

        if (StringUtils.isEmpty(productId)){

        }
        try {
            productService.onSale(productId);
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("/common/success", map);
        }
        catch (SellException e){
            log.error("【商品上架】{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("/common/error", map);
        }

    }

    /**
     * 商品下架
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("/off_sall")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                               Map<String, Object> map){

        if (StringUtils.isEmpty(productId)){

        }
        try {
            productService.offSale(productId);
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("/common/success", map);
        }
        catch (SellException e){
            log.error("【商品下架】{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("/common/error", map);
        }

    }

    @GetMapping("index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object>map){

        if (!StringUtils.isEmpty(productId)){//如果进入页面时有传入 productId 那么就给页面赋值，这里是把值传递给页面
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        //查询所有的类目 ->用于页面 菜单选择
        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("productCategoryList", productCategoryList);
        return new ModelAndView("product/index", map);

    }

    /**
     * 保存 or 更新 商品分类信息
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
//    @CachePut(cacheNames = "product", key = "123")//将方法返回的内容设置到redis中 由于这里返回的内容是 ModelAndView 无法序列化 所以不能使用该注解
    @CacheEvict(cacheNames = "product", key = "123")//功能是清除redis中指定的缓存,在访问了本接口方法之后，会清除掉对应的缓存
    public ModelAndView index(@Valid ProductForm form,
                              BindingResult bindingResult,
                              Map<String, Object>map){

        //1.判断参数合法性
        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("/common/error", map);
        }

        try {

            ProductInfo productInfo = null;
            if (!StringUtils.isEmpty(form.getProductId())){//如果有id 说明是修改 就赋值上id
                productInfo = productService.findOne(form.getProductId());
                productInfo.setProductId(form.getProductId());
            }
            else{
                productInfo = new ProductInfo();
                productInfo.setProductId(KeyUtil.genUniqueKey());
                productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
            }
            //如果productInfo没有id 就说明是 新增
            productInfo.setProductStock(form.getProductStock());
            productInfo.setProductPrice(form.getProductPrice());
            productInfo.setProductDescription(form.getProductDescription());
            productInfo.setCategoryType(form.getCategoryType());
            productInfo.setProductName(form.getProductName());
            productInfo.setProductIcon(form.getProductIcon());

            productService.save(productInfo);
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("/common/success", map);
        }
        catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("/common/error", map);
        }

    }

}
