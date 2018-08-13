package com.girl.aspect;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kenshin
 * @date 2018/7/10 上午12:01
 */

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //girlList(..) 里面的 .. 表示 方法里面的所有参数都会被拦截
    //@Before("execution(public * com.girl.controller.GirlController.girlList(..))")

    //拦截 GirlController中所有的方法
//    @Before("execution(public * com.girl.controller.GirlController.*(..))")
    @Pointcut("execution(public * com.girl.controller.GirlController.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //记录http请求

        /***
         * 请求地址 url
         * 请求方式 method
         * 客户端   ip
         * 请求的哪个类的方法
         * 请求的参数
         * */

        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("———————————————————————————Before—————————————————————————————————");
        logger.info("url={}", request.getRequestURL());
        logger.info("method={}", request.getMethod());
        logger.info("ip={}", request.getRemoteAddr());
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("args={}", joinPoint.getArgs());
        logger.info("———————————————————————————分割线—————————————————————————————————");
    }

    @After("log()")
    public void doAfter(){
        logger.info("HttpAspect @After >>> 方法被拦截");
    }

    /***
     * 获取请求的返回结果
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("———————————————————————————AfterReturning—————————————————————————————————");
        logger.info("response={}", object);
        logger.info("———————————————————————————分割线—————————————————————————————————");
    }

}
