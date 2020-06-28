package com.dev.common.api;

import java.io.Serializable;

/**
 * @Description: 返回值接口
 * @Author lvcy
 * @Date 2020/6/14
 **/

public interface IResultCode  extends Serializable {

    /**
     * 消息
     *
     * @return String
     */
    String getMessage();

    /**
     * 状态码
     *
     * @return int
     */
    int getCode();

}
