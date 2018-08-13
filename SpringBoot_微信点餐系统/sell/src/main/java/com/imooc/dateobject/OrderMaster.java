package com.imooc.dateobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 * @author kenshin
 * @date 2018/7/17 下午9:59
 */
@Entity
//@DynamicUpdate//动态更新    数据库中有 「更新时间」 字段时 动态更新该字段
@Data//该注解会自动生成 get set toString 方法
@EntityListeners(AuditingEntityListener.class)
public class OrderMaster {

    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态,默认0位未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //创建时间
    @CreatedDate //需要在本实体累中添加 @EntityListeners(AuditingEntityListener.class) 还要在Application中添加 @EnableJpaAuditing
    private Date createTime;

    //更新时间
    @LastModifiedDate
    private Date updateTime;

}
