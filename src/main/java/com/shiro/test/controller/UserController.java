package com.shiro.test.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hongpengsun on 17/7/25.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String test(String name){
        UsernamePasswordToken token = new UsernamePasswordToken(name, "admin");
        Subject currentUser = SecurityUtils.getSubject();
        //具体响应ShiroRealm doGetAuthenticationInfo 身份认证
        currentUser.login(token);
        System.out.println("login");
        return "login";
    }

    @RequestMapping("admin")
    public void admin(){
        System.out.print("admin");
    }


    @RequestMapping("list")
    public void list(){
        System.out.print("list");
    }



}
