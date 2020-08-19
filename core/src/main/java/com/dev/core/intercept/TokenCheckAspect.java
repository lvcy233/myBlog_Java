package com.dev.core.intercept;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: token验证切面
 * @Author max
 * @Date 2020/8/19
 **/

@Aspect
@Component
class TokenCheckAspect {
    /**
     * 请求头认证字段
     */
    private static final String HEAD_AUTHORIZATION = "Authorization";

    /**
     * 请求切点方法()
     */
//    @Pointcut(" @annotation(org.springframework.web.bind.annotation.RequestMapping) || " +
//            "   @annotation(org.springframework.web.bind.annotation.GetMapping) || " +
//            "   @annotation(org.springframework.web.bind.annotation.PostMapping)")
//    void requestMapping() {}

    /**
     * 范围切点方法
     */
    @Pointcut("@annotation(com.dev.core.annotation.ServiceTokenRequired)")
    public void validateAnnotation() {
    }



    @Pointcut("validateAnnotation()")
    private void validateToken() {
    }

    /**
     * 验证token
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     * @author: max
     */
    @Around("validateToken()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //逻辑代码
        return null;
    }
}