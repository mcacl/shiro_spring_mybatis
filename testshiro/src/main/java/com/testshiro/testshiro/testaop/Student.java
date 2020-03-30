package com.testshiro.testshiro.testaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 创建时间:2020/3/18
 * 创建人:pmc
 * 描述:
 */
@Component
public class Student
{
    @Value("三")
    private String name;
    @Value("20")
    private int age;
    @Autowired
    private School school;

    public Student()
    {
    }

    public Student(String name, int age)
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

    public void setSchool(School school)
    {
        this.school = school;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
