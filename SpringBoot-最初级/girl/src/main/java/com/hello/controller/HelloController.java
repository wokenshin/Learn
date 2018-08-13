package com.hello.controller;

import com.hello.PropertiesKenshin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * @author kenshin
 * @date 2018/6/29 上午12:58
 */
@RestController
@RequestMapping("/kenshin")//如果这样写的话 相当于是类里面所有的 url都要加上这个前路径才能访问 比如 /kenshin/hello
@SuppressWarnings("ALL")
public class HelloController {

    //这里我遇到一个坑爹的事情 就是当我在使用VPN时 无法正常访问
    //注意下面的 {"/hello, "/hi"} 如果只有一个的话 只写一个 不要打括号 如 "/hello"
    //下面的写法的意思是 访问 /hello 或者 /hi 都执行下面同一个方法
    @RequestMapping(value = {"/hello", "hi"}, method = RequestMethod.GET)
    public String hello(){
        return "Hello World!";
    }

    //通过 注解访问 yml中的信息
    @Value("${Naruto}")
    private String naruto;

    @Value("${content}")
    private String content;

    @Value("${Environment}")
    private String env;

    @RequestMapping("/env")//在注解中没有指定请求的类型，那么使用 GET 或 POST 都可以访问 通常不建议这样写
    public String environment(){
        return env;
    }



    @RequestMapping("/naruto")
    public String naruto(){
        return naruto;
    }



    //在配置文件中使用当前配置
    @RequestMapping("/content")
    public String content(){
        return content;
    }


    //定义了一个类集中获取 yml中部分相关属性内容
    @Autowired
    PropertiesKenshin ken;


    //输出yml配置的属性信息
    @RequestMapping("/info")
    public String info(){
        return ken.getName() + " " + ken.getLike() + " " + ken.getGender() + " " + ken.getAge();
    }


    //    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @PostMapping("/post")//这里的注解等同于上一行注释
    public String postTest(){
        return "突如其来的骚，闪了老子的腰 yohohoho!" ;
    }

    //带参数的请求
    @RequestMapping(value = "/getParam", method = RequestMethod.GET)
    public String getTest(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
        //上面的写法意思是 需要传递一个参数 id，它有一个默认值是 "0", false的意思是 这个参数不是必须传如的 也可以不传
        return "id: " + myId;
    }


}
