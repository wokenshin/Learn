package com.imooc.handler;

import com.imooc.VO.ResultVO;
import com.imooc.exception.ResponseBankException;
import com.imooc.exception.SellException;
import com.imooc.exception.SellerAuthorizeException;
import com.imooc.utils.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kenshin
 * @date 2018/8/3 上午11:11
 */
@ControllerAdvice
public class SellExceptionHandler {

    //拦截登陆异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:/seller/login");
    }

    //拦截 SellException 异常
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e){

        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    //拦截 ResponseBankException 异常
    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)//这里设置的 http状态码为403 捕获到异常后 前台接收到的http状态码就会变成 403
    public void handleResponseBankException(){
        //有时候 我们会有这样的需求
        //就是在发生异常的时候http的状态码不要返回成200
        //此时我们就可以利用 这里的方法来解决
    }

}
