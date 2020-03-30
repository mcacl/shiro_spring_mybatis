package com.testshiro.testshiro.testaop;

/**
 * 创建时间:2020/3/18
 * 创建人:pmc
 * 描述:
 */
public interface IOldClass
{
    void before();

    String afterreturn(String name);

    String around(String name);

    void afterthrow();

    void after();
}
