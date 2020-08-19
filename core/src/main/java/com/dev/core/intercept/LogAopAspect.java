package com.dev.core.intercept;

import com.dev.core.api.R;
import com.dev.core.util.ThrowableMessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: 日志切面
 * @Author lvcy
 * @Date 2020/8/17
 **/

@Aspect
@Component
public class LogAopAspect {
    @Autowired
    private static Logger logger = Logger.getLogger(LogAopAspect.class);

    /**
     * 定义切点
     */
    @Pointcut("execution(public * com.dev..service.impl..*(..)))")
    public void LogAopAspect() {

    }

//    /**
//     * @description  在连接点执行之前执行的通知
//     */
//    @Before("LogAopAspect()")
//    public void doBeforeGame(ProceedingJoinPoint pjp){
//
//    }
//
//    /**
//     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
//     */
//    @After("LogAopAspect()")
//    public void doAfterGame(){
//
//    }
//
//    /**
//     * @description  在连接点执行之后执行的通知（返回通知）
//     */
//    @AfterReturning("LogAopAspect()")
//    public void doAfterReturningGame(){
//
//    }
//
//    /**
//     * @description  在连接点执行之后执行的通知（异常通知）
//     */
//    @AfterThrowing("LogAopAspect()")
//    public void doAfterThrowingGame(){
//
//    }

    /**
     * @description 使用环绕通知
     */
    @Around("LogAopAspect()")
    public Object doAroundGame(ProceedingJoinPoint pjp) throws Throwable {
        //获取方法名
        String method = pjp.getSignature().getName();
        Object o = R.fail("系统异常，请稍后重试！");
        try {
            logger.info("执行方法开始：——————————————————————————————————" + method);
            //调用方法
            o = pjp.proceed();
            logger.info("方法执行结束：——————————————————————————————————" + method);
        } catch (Throwable e) {
            logger.error("方法执行异常：——————————————————————————————————" + method);
            logger.error(ThrowableMessageUtil.getMessage(e));
        } finally {
            return o;
        }
    }
}
