package com.dev.core.intercept;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description: 日志切面
 * @Author lvcy
 * @Date 2020/8/17
 **/

@Aspect
@Component
public class LogAopAspect {

    /**
     * 定义切点
     */
    @Pointcut("execution(public * com.dev..controller..*(..)))")
    public void LogAopAspect(){
        System.out.println("LogAopAspect");
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
     * @description  使用环绕通知
     */
    @Around("LogAopAspect()")
    public void doAroundGame(ProceedingJoinPoint pjp) throws Throwable {
        //获取方法名
        String method = pjp.getSignature().getName();
        try{
            System.out.println("执行方法：——————————————————————————————————" + method);
            //调用方法
            pjp.proceed();
            System.out.println("方法执行结束：——————————————————————————————" + method);
        }
        catch(Throwable e){
            System.out.println("异常通知：——————————————————————————————————" + method);
        }
    }
}
