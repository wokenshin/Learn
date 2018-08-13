package com.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @author kenshin
 * @date 2018/6/29 上午12:51
 */
@Entity //本注解表示 当前类就是对应类数据库中的一个表
public class Girl {

    //这里就使用到了 jpa的特性，将类中的属性映射到数据库中对应的字段

    @Id
    @GeneratedValue //自增
    private Integer id;

    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;

    //必须要有一个无参的构造方法，不然数据库操作的时候会报错
    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //为了让 HttpAspect 中获取 请求返回的结果的具体内容 所以这里重写了 toStrig方法
    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
