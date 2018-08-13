package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.dateobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import com.imooc.utils.EnumUtil;
import com.imooc.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO的意思就是  data transform object 数据传输对象
 * 对应OrderMaster 只是里面多了一些 list
 * @author kenshin
 * @date 2018/7/19 下午10:29
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)//如果属性为 null 就不返回该属性 当然 我们也可以在 配置文件中进行全局配置
public class OrderDTO {

    private String orderId;

    //买家的名字
    private String buyerName;

    //买家电话
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家微信openid
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态,默认0为新下订单
    private Integer orderStatus;

    //支付状态,默认0位未支付
    private Integer payStatus;

    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)//这里 using的类是我们自己创建的 用于将这里的时间转换成 long 秒精度
    private Date createTime;

    //更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    //订单详细列表
    private List<OrderDetail> orderDetailList = new ArrayList<>();//设置一个初始值，这样没有值时就不会为null了

    @JsonIgnore//该注解 在将对象转换成json的时候 就会忽略注解掉的 属性
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore//该注解 在将对象转换成json的时候 就会忽略注解掉的 属性
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }


}
