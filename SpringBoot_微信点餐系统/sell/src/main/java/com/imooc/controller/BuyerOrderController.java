package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.converter.OrderForm2OrderDTOConvert;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.OrderService;
import com.imooc.service.impl.BuyerServiceImpl;
import com.imooc.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kenshin
 * @date 2018/7/26 下午4:30
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j //日志
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerServiceImpl buyerService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String >> create(@Valid OrderForm orderForm, BindingResult bindingResult){

        //首先判断表单校验就没有错误
        if (bindingResult.hasErrors()){
            log.error("【创建订单】单数错误 orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());//请求参数错误

        }

        //将表单中的请求数据 转换为 OrderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConvert.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){//购物车为空 创建订单失败
            log.error("【创建订单】购物车不能为空 ");
            throw new SellException(ResultEnum.CART_EMPTY);//购物车不能为空
        }

        //创建订单
        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String > map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam(value = "openid", required = true) String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size){

        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);//openid不能为空 参数不正确
        }

        PageRequest pageRequest = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage  = orderService.findList(openid, pageRequest);

        //不管上面查询的结果 有无 都直接返回
        return ResultVOUtil.success(orderDTOPage.getContent());

    }

    /**
     * 订单详情「查看单个订单」
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam(value = "openid", required = true) String openid,
                                     @RequestParam(value = "orderId", required = true) String orderId){

        if (StringUtils.isEmpty(openid) || StringUtils.isEmpty(orderId)){
            log.error("【查看订单详情】参数错误");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam(value = "openid", required = true) String openid,
                           @RequestParam(value = "orderId", required = true) String orderId){

        if (StringUtils.isEmpty(openid) || StringUtils.isEmpty(orderId)){
            log.error("【取消订单】参数错误");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        buyerService.cancelOrder(openid, orderId);//这里如果出错了会抛异常 所以不需要判断

        return ResultVOUtil.success();

    }



}
