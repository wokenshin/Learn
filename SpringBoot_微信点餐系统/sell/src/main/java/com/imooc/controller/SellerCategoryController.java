package com.imooc.controller;

import com.imooc.dateobject.ProductCategory;
import com.imooc.exception.SellException;
import com.imooc.form.CategoryForm;
import com.imooc.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * 卖家类目
 * @author kenshin
 * @date 2018/8/2 上午10:27
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 类目列表
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){

        try {
            List<ProductCategory> categoryList = categoryService.findAll();
            map.put("categoryList", categoryList);
            map.put("url", "/sell/seller/category/list");
            return new ModelAndView("category/list", map);
        }
        catch (SellException e){
            map.put("url", "/sell/seller/category/list");
            return new ModelAndView("common/error", map);
        }

    }

    /**
     * 修改
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map){

        if (categoryId != null){//说明有id
            ProductCategory category = categoryService.findOne(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("category/index", map);
    }

    /**
     * 保存 or 更新 类目
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map){

        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("/common/error", map);
        }

        ProductCategory productCategory = new ProductCategory();
        try {
            if (form.getCategoryId() != null){//更新 因为有id 所以 save的时候是更新
                productCategory = categoryService.findOne(form.getCategoryId());
            }

            BeanUtils.copyProperties(form, productCategory);
            categoryService.save(productCategory);

            map.put("msg", "提交成功");
            map.put("url", "/sell/seller/category/list");
            return new ModelAndView("/common/success", map);
        }
        catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("/common/error", map);
        }

    }
}

















