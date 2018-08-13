package com.imooc.controller;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 卖家端订单
 * @author kenshin
 * @date 2018/7/31 上午9:41
 */
@Controller//现实前端页面 所以用这个注解
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 订单列表
     * @param page 页数 从第0页开始
     * @param size 一页最多这么多条数据
     * @return
     */
    @GetMapping("/list")
    //因为是模版渲染 所以这里的返回类型使用 ModelAndView
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map){

        PageRequest pageRequest = new PageRequest(page -1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);

        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("currentSize", size);
        return new ModelAndView("/order/list", map);//第一个参数是模版的名字

    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String, Object>map){

        //1.先查询到订单
        OrderDTO orderDTO = null;
        try{
            orderDTO = orderService.findOne(orderId);
        }
        catch (SellException e){
            //无此订单
            log.error("【卖家端取消订单】发生异常{}", e);
            //因为是前端页面所以这里不用抛异常
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        //2.取消订单
        orderService.cancel(orderDTO);
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("/common/success", map);
    }

    /**
     * 订单详情
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object>map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            map.put("orderDTO", orderDTO);
            return new ModelAndView("/order/detail", map);
        }
        catch (SellException e){
            //无此订单
            log.error("【卖家端查询订单详情】发生异常{}", e);
            //因为是前端页面所以这里不用抛异常
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

    }

    /**
     * 完结订单
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object>map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
            map.put("url", "/sell/seller/order/list");
            map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
            return new ModelAndView("/common/success", map);
        }
        catch (SellException e){
            log.error("【完结订单】发生异常{}", e);
            //因为是前端页面所以这里不用抛异常
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
    }

}
