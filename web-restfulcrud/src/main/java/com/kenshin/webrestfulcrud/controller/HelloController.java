package com.kenshin.webrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author kenshin
 * @date 2018/6/15 上午10:11
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")//fxw 这里傻逼了！！！！！千万记住要在括号里面写上地址，不然所有请求都会出发这里的方法
    public String hello(){
        return "hello world!";
    }

    /**
     * 查出一些数据在页面展示
     * @return
     */
    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("张三", "李四", "王五", "赵六"));
        //thymeleaf模版引擎 会去找到 classpath:/tmplates/success.html
        //下面的返回为我们 省略了「全路径」和「后缀」
        return "success";
    }

    /**
     * 访问 index 或 根路径 都返回资源 resources/templates/index.html
     * @return
     */
    @RequestMapping({"/index", "/"})
    public  String index(){
        return "index";
    }

}
