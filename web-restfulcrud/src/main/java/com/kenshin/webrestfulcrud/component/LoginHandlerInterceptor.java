package com.kenshin.webrestfulcrud.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author kenshin
 * @date 2018/6/22 下午4:32
 * 这是以个拦截器
 * 作用就是用来做登录检查：没有登录的用户 所请求的url都会跳转到登录页面
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String path = request.getRequestURI();
        if (path.contains("/asserts") || path.contains("/webjars")){
            System.out.println("YES--1-->未拦截："+path);
            return true;
        }

        HttpSession session = request.getSession();
        String user = (String)session.getAttribute("loginUser");
        if (user == null){
            //未登录，返回登录页面
            request.setAttribute("msg", "没有权限，请先登录");
            request.getRequestDispatcher("/").forward(request, response);
            System.out.println("NO--2-->被拦截："+path);
            return false;
        }
        else{
            //已登录，放行请求
            System.out.println("YES--3-->未拦截："+path);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
