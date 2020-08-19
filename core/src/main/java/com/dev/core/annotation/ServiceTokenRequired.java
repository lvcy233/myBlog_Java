package com.dev.core.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
/**
 * 用于标注是否需要验证token
 * @author: max
 */
public @interface ServiceTokenRequired {
}
