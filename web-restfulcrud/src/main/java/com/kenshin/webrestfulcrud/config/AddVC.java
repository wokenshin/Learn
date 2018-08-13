package com.kenshin.webrestfulcrud.config;

import com.kenshin.webrestfulcrud.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kenshin
 * @date 2018/6/22 上午10:45
 */
@Configuration
public class AddVC implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /test 请求 来到 success
        registry.addViewController("/test").setViewName("success");

        //fxw 在 LoginVC中 登录之后 为了防止 表单重复提交 这里做了新的视图映射
        //登录成功后 会重定向到 /logined
        //所以下面的代码会去修改 url 并且设置指定的视图
        registry.addViewController("/logined").setViewName("dashboard");
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //拦截 任意请求 切 排除
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login", "/", "index.html");

    }
}
