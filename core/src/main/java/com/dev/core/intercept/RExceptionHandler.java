package com.dev.core.intercept;

import com.dev.core.api.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RExceptionHandler {

    @ExceptionHandler(Exception.class)
    R handleControllerException(Throwable e){
//        if () {
//
//        } else {
//
//        }
        return R.fail("1");
    }
}
