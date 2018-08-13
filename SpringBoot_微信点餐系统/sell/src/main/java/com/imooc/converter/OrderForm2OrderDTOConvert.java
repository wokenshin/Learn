package com.imooc.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.dateobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kenshin
 * @date 2018/7/26 下午5:02
 */
@Slf4j
public class OrderForm2OrderDTOConvert {


    public static OrderDTO convert(OrderForm orderForm){

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());



//        不能用下面的方式进行属性拷贝 因为 左边 和 右边 的属性名字不一样 这样无法拷贝
//        BeanUtils.copyProperties();

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try{
            //我们将 orderForm中的 items 其实是一个json字符串 转换成json
            Gson gson = new Gson();
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        }
        catch (Exception s){
            log.error("【对象转换】错误 string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;

    }

}
