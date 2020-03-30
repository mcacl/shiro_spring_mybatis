package com.testshiro.testshiro.testaop;

/**
 * 创建时间:2020/3/18
 * 创建人:pmc
 * 描述:
 */

public class StudentXml
{

    private String name;

    private int age;

    private SchoolXml schoolXml;

    public StudentXml()
    {
    }

    public StudentXml(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setSchool(SchoolXml schoolXml)
    {
        this.schoolXml = schoolXml;
    }

    @Override
    public String toString()
    {
        return "StudentXml{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + schoolXml +
                '}';
    }
}
