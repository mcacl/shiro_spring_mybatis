package com.testshiro.testshiro.testaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 创建时间:2020/3/18
 * 创建人:pmc
 * 描述:
 */
@Aspect
@Component
public class AopLog
{
    @Before(value = "execution(void com.testshiro.testshiro.testaop.IOldClassImpl.before(..))")
    public void before(JoinPoint joinPoint)
    {
        System.out.println("前置通知增强");
    }

    //AfterReturning后置通知可以得到有返回值的方法的返回值
    @AfterReturning(value = "execution(String com.testshiro.testshiro.testaop.IOldClassImpl.afterreturn(..))", returning = "result")
    public void afterreturning(Object result)
    {
        System.out.println("后置返回值增强:" + result);
    }

    @Around(value = "execution(String com.testshiro.testshiro.testaop.IOldClassImpl.around(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        System.out.println("环绕通知之前");
        Object resu = proceedingJoinPoint.proceed();
        System.out.println("环绕返回值：" + resu);
        System.out.println("环绕通知之后");
    }

    @AfterThrowing(value = "execution(* com.testshiro.testshiro.testaop.IOldClassImpl.afterthrow(..))", throwing = "ex")
    public void afterthrow(Throwable ex)
    {
        System.out.println("异常原因：" + ex.getMessage());
    }


    @After(value = "execution(void com.testshiro.testshiro.testaop.IOldClassImpl.after(..))")
    public void after(JoinPoint joinPoint)
    {
        System.out.println("最终通知增强");
    }

    @Pointcut(value = "execution(* com.testshiro.testshiro.testaop.IOldClassImpl.*())")
    private void mycut(){
        //定义一个方法代表空通用切入点
        //使用时 通知的value写改方法名即可;
        //例 @After(value="mycut()")
    }

}
