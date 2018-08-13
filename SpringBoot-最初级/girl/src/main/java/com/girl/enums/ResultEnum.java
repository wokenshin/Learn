package com.girl.enums;

/**
 * @author kenshin
 * @date 2018/7/11 下午3:22
 */
public enum ResultEnum {

    UNKNOWN_ERROR(-1, "未知错误"),
    PRIMARY_SCHOOL(100, "你还在上小学吧"),
    MIDDLE_SCHOOL(101, "你还在上初中吧"),
    SUCCESS(1, "成功"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
