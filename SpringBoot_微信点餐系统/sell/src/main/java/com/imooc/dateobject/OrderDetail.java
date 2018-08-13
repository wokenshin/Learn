package com.imooc.dateobject;

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
 * @author kenshin
 * @date 2018/7/17 下午10:22
 */
@Entity
@Data//该注解会自动生成 get set toString 方法
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail {

    @Id
    //订单详情id
    private String detailId;

    //订单id
    private String orderId;

    //商品id
    private String productId;

    //商品名
    private String productName;

    //商品价格
    private BigDecimal productPrice;

    //商品数量
    private Integer productQuantity;

    //小图
    private String productIcon;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;


}
