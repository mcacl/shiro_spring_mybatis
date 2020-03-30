package com.testshiro.testshiro.testaop;

/**
 * 创建时间:2020/3/18
 * 创建人:pmc
 * 描述:
 */
public class SchoolXml
{
    private String name;
    private String adress;

    public SchoolXml()
    {
    }

    public SchoolXml(String name, String adress)
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

    @Override
    public String toString()
    {
        return "SchoolXml{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
