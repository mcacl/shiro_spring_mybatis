package com.testshiro.testshiro.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.omg.CORBA.portable.UnknownException;

/**
 * 创建时间:2019/12/26
 * 创建人:pmc
 * 描述:
 */

public class ConfigShiro
{
    public void testLogin()
    {
        //1.获取SecurityManager工厂，加载shiro.Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2.获取SecurityManager实例
        SecurityManager securityManager = factory.getInstance();
        //3.将SecurityManager实例，绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //4.使用最常见的用户名密码的方式，创建token
        UsernamePasswordToken token = new UsernamePasswordToken("zhao", "1");
        //5.设置记住我
        token.setRememberMe(true);
        //6.获取Subject对象
        Subject subjectuser = SecurityUtils.getSubject();
        String msg = "";
        try
        {
            //7.传入上一步骤创建的token对象，登录，即进行身份验证操作
            subjectuser.login(token);
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
    }
}
