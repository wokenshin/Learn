package com.imooc.converter;

import com.imooc.dateobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换器
 * @author kenshin
 * @date 2018/7/26 上午11:50
 */
public class OrderMaster2OrderDTOConverter {

    /**
     * 将 OrderMaster 转换成 OrderDTO
     * @param orderMaster
     * @return
     */
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    /**
     * 将列表进行转换  List<OrderMaster> 转成 List<OrderDTO>
     * @param orderMasterList
     * @return
     */
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){

        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (OrderMaster orderMaster : orderMasterList) {
            orderDTOList.add(convert(orderMaster));
        }

        //我们也可以用 Lambda表达式来完成
//        List<OrderDTO> orderDTOList1 = orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());

        return orderDTOList;

    }
}
