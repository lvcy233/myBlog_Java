package com.dev.core.intercept;

import com.dev.core.api.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: 全局异常处理
 * @Author lvcy
 * @Date 2020/8/17
 **/

@RestControllerAdvice
public class RExceptionHandler {

    /**
     * 全局异常处理
     * @param e 异常类型
     * @return
     */
    @ExceptionHandler(Exception.class)
    R handleControllerException(Throwable e){
        if (false) {

        }
        return R.fail("系统异常，请稍后重试！");
    }
}
