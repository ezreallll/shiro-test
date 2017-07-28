package com.shiro.test.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hongpengsun on 17/7/25.
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        String loginName=SecurityUtils.getSubject().getPrincipal().toString();

        //todo 通过用户名从数据库获取权限信息


        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        Set<String> role=new HashSet<String>();
        role.add("lll");
        authorizationInfo.setRoles(role);

        Set<String> permissions=new HashSet<String>();
        permissions.add("user:create");
        permissions.add("user:edit");

        authorizationInfo.setStringPermissions(permissions);

        System.out.println("user:"+loginName+"======验证权限");
        return authorizationInfo;
    }

    /**
     * 登录认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();  //得到用户名
        String password = new String((char[])token.getCredentials()); //得到密码

        //todo 验证登录信息
        System.out.println("user:"+username+"======验证登录");

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }
}
