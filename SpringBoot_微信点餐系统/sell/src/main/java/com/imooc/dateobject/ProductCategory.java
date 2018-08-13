package com.imooc.dateobject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author kenshin
 * @date 2018/7/13 下午4:34
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data//该注解会自动生成 get set toString 方法
public class ProductCategory {

    /** 类目id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//起初是没有括号中的内容的 后来测试保存方法的时候报错 就新增了括号中的内容 详细：https://blog.csdn.net/heatdeath/article/details/79841171
    private Integer categoryId;

    /** 类目名称. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

    //定义以个无参的构造方法 用于兼容 例如 查询多条数据的时候的方法需要有一个 无参构造方法
    public ProductCategory() {
    }

    /***
     * 构造方法
     * @param categoryName 名字
     * @param categoryType 编号
     */
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }


}
