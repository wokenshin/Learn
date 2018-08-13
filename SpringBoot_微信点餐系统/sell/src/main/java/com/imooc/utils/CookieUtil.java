package com.imooc.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Cookie工具类
 * @author kenshin
 * @date 2018/8/3 上午9:40
 */
public class CookieUtil {

    /**
     *设置并添加cookie
     * @param response
     * @param name
     * @param value
     * @param maxAge 过期时间
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge){

        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");//因为这个path一般不用修改 所以这里写死
        cookie.setMaxAge(maxAge);//过期时间
        response.addCookie(cookie);

    }

    /**
     * 返回cookie 根据 name
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request,
                           String name){
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }
        else {
            return null;
        }
    }

    //方法的作用的 将 获取到的 数组形式的cookis 转换成 map 的格式
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Map<String, Cookie> cookieMap = new HashMap<>();
        if (cookies != null){
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
