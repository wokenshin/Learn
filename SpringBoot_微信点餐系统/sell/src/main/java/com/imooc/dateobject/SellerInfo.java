package com.imooc.dateobject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/8/2 下午3:08
 */
@Entity
@Data//该注解会自动生成 get set toString 方法
@EntityListeners(AuditingEntityListener.class)
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    //微信openid
    private String password;

    private String openid;


    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

}
