package com.testshiro.testshiro;

import com.testshiro.testshiro.service.ServTest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication()
public class TestshiroApplication
{

    public static void main(String[] args)
    {
        //SpringApplication.run(TestshiroApplication.class, args);
        String config = "springContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        /*for (String name : context.getBeanDefinitionNames())
        {
            System.out.println(name);
        }*/
        ServTest servTest= (ServTest) context.getBean("servTest");
        servTest.add("北京大学");
        servTest.list("");
    }
}
