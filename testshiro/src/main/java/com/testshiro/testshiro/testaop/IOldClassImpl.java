package com.testshiro.testshiro.testaop;

import org.springframework.stereotype.Component;

/**
 * 创建时间:2020/3/18
 * 创建人:pmc
 * 描述:
 */
@Component
public class IOldClassImpl implements IOldClass
{

    @Override
    public void before()
    {
        System.out.println("前置通知");
    }

    @Override
    public String afterreturn(String name)
    {
        System.out.println("带返回值的后置通知");
        return "后置通知返回值:" + name;
    }

    @Override
    public String around(String name)
    {
        System.out.println("环绕通知");
        return "环绕通知返回值:" + name;
    }

    @Override
    public void afterthrow()
    {
        System.out.println("异常通知");
        int i = 1 / 0;
    }

    @Override
    public void after()
    {
        System.out.println("最终通知");
        int i = 1 / 0;
    }
}
