package com.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author kenshin
 * @date 2018/6/29 上午12:59
 */
//ConfigurationProperties的作用是告诉SpringBoot 将本类中所有属性和配置文件中相关的内容进行绑定
//prefix = "kenshin" ：对配置文件中 哪个属性下的所有属性进行一一映射
@Component
@ConfigurationProperties(prefix = "kenshin")//注意需要在pom.xml中配置依赖
//@Validated
public class PropertiesKenshin {

    //    @Email
    private String name;

    private String like;
    private String gender;
    private int    age;

    @Override
    public String toString() {
        return "PropertiesKenshin{" +
                "name='" + name + '\'' +
                ", like='" + like + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
