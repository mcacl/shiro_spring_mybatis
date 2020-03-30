package com.testshiro.testshiro.testaop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 创建时间:2020/3/18
 * 创建人:pmc
 * 描述:
 */
@Component
public class School
{
    @Value("清华大学")
    private String name;
    @Value("北京")
    private String adress;

    private int num;

    public School()
    {
    }

    public School(String name, String adress)
    {
        this.name = name;
        this.adress = adress;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    @Override
    public String toString()
    {
        return "School{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ",num:" + num + "}";
    }
}
