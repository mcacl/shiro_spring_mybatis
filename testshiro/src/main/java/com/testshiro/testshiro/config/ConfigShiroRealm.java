package com.testshiro.testshiro.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 创建时间:2019/12/26
 * 创建人:pmc
 * 描述:
 */
public class ConfigShiroRealm extends AuthenticatingRealm
{
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException
    {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = "";
        List<Map<String, String>> userlist = new ArrayList<Map<String, String>>();
        return null;
    }
}
