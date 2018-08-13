package com.girl.exception;

import com.girl.enums.ResultEnum;

/**
 * @author kenshin
 * @date 2018/7/11 下午3:07
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
