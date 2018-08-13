package com;

import com.javase.generic.Box;
import com.javase.generic.GenericMethodTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * 2018.7.6
 * 注意：本类 应该放在其他 Controller类的路径之前
 * 例如 本项目 Application类放在类 com下， 其他Controller类放在类 com之后
 * 这样Controller才会被扫描到，不然需要额外进行配置
 *
 * 项目说明：
 * 1、com.girl 里面的内容来自 慕课网
 * */
@SpringBootApplication
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);

        //runJavaSE();

    }

    /***
     * javaSE部分的内容
     */
    public static void runJavaSE(){
        System.out.println("测试类调用：————————————————————————————————————————————————————————————————————");

        //泛型
        GenericMethodTest.testMain();
        Box.testFunction();

        //其他




    }

}
