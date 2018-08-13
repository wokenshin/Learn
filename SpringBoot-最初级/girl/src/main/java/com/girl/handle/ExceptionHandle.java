package com.girl.handle;

import com.girl.domain.Result;
import com.girl.exception.GirlException;
import com.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kenshin
 * @date 2018/7/11 下午3:01
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)//注解 声明了要捕获的异常类
    @ResponseBody
    public Result handle(Exception e){

        if (e instanceof GirlException){
            GirlException ge = (GirlException)e;
            return ResultUtil.error(ge.getCode(), ge.getMessage());
        }
        else{
            logger.info("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }

    }
}
