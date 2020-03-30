package com.testshiro.testshiro.dao;

import com.testshiro.testshiro.model.Test;

import java.util.List;

public interface TestMapper
{
    int add(Test record);

    List<Test> list(Test record);
}