package com.testshiro.testshiro;

import com.testshiro.testshiro.service.ServTest;
import com.testshiro.testshiro.testaop.IOldClass;
import com.testshiro.testshiro.testaop.Student;
import com.testshiro.testshiro.testaop.StudentXml;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

@SpringBootTest
class TestshiroApplicationTests
{
    @Test
    void contextLoads()
    {
        //
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("wang1", "2");
        String msg = "";
        try
        {
            //7.传入上一步骤创建的token对象，登录，即进行身份验证操作
            subject.login(token);
            msg = "登录成功！";
        } catch (UnknownException ex)
        {
            msg = "用户不存在!";
        } catch (IncorrectCredentialsException ex)
        {
            msg = "密码错误!";
        } catch (LockedAccountException ex)
        {
            msg = "用户被锁定！";
        } catch (ExcessiveAttemptsException ex)
        {
            msg = "请求次数已达上限!用户被锁定";
        } catch (AuthenticationException ex)
        {
            msg = "未知错误！无法登录";
        }
        System.out.println(msg);
        Assert.isTrue(subject.isAuthenticated(), "认证失败");
    }

    @Test
    void testspring()
    {
        String config = "setting.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Student student = (Student) context.getBean("student");//注解方式 如component未指定value 则实例类名默认未小写类名
        System.out.println(student);
        StudentXml studentXml = (StudentXml) context.getBean("studentxml");//xml方式 未bean配置的id
        System.out.println(studentXml);
        //动态代理默认使用jdk代理 jdk代理需要类实现接口 IOldClassImpl实现IOldClass com.sun.proxy.$Proxy
        //如果如果代理类没有接口，则使用cflib代理//com.testshiro.testshiro.testaop.IOldClassImpl$$EnhancerBySpringCGLIB$$c0b46a9d
        //可在配置文件<aop:aspectj-autoproxy/>的proxy-target-class属性 true或false 设置是否全用cglib代理
        IOldClass iOldClass = (IOldClass) context.getBean("IOldClassImpl");
        System.out.println("动态代理类:" + iOldClass.getClass().getName());
        iOldClass.before();
        iOldClass.afterreturn("afterreturn");
        iOldClass.around("around");
        //iOldClass.afterthrow();
        iOldClass.after();
    }

    @Test
    void testmybatis()
    {
        String config = "springContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        /*for (String name : context.getBeanDefinitionNames())
        {
            System.out.println(name);
        }*/
        ServTest servSchool= (ServTest) context.getBean("servTest");
        //servSchool.add("北京大学", 2000);
        servSchool.list("");
    }
}