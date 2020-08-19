package com.dev.core.util;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * 获取Throwable的错误 信息
 */
public class ThrowableMessageUtil {

    public static String getMessage(Throwable e){
        String msg = null;
        if (e instanceof UndeclaredThrowableException){
            Throwable targetEx = ((UndeclaredThrowableException) e).getUndeclaredThrowable();
            if (targetEx != null){
                msg = targetEx.getMessage();
            }
        } else {
            msg = e.getMessage();
        }
        return msg;
    }
}
