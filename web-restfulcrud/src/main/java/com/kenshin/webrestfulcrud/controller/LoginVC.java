package com.kenshin.webrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author kenshin
 * @date 2018/6/22 下午2:55
 */
@Controller
public class LoginVC {

    //@RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping("/user/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String , Object> map,
                        HttpSession session){

        if (!StringUtils.isEmpty(username) && password.equals("123456")){
            //登录成功

            //将登录信息保存到session中
            session.setAttribute("loginUser", username);

            //为了防止表单重复提交 可以重定向到主页
            return new ModelAndView("redirect:/logined");
        }

        map.put("msg", "用户名或密码错误");
        //登录失败
        return "index";
    }

}
