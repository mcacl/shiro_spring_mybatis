package com.testshiro.testshiro.service;

import com.testshiro.testshiro.dao.TestMapper;
import com.testshiro.testshiro.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创建时间:2020/3/24
 * 创建人:pmc
 * 描述:
 */
@Service
public class ServTest
{
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private Test test;

    /**
     * 增加事务 传播方式 隔离级别
     *
     * @param name
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 5, rollbackFor = Exception.class)
    public void add(String name)
    {
        test.setName(name);
        testMapper.add(test);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public void list(String name)
    {
        test.setName(name);
        List<Test> schoolList = testMapper.list(test);
        for (Test school : schoolList)
        {
            System.out.println(school);
        }
    }
}
