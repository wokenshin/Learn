package com.imooc.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * @author kenshin
 * @date 2018/7/15 下午10:40
 */
@Data//这里 implement 是为了能够序列化
public class ResultVO<T> implements Serializable {

    //VO 就是 ViewObject 视图对象

    //快捷键 shift + ctrl + i
    private static final long serialVersionUID = 3068837394742385883L;

    /**
     * 错误码 0:成功
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

}
