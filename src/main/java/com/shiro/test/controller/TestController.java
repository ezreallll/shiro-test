package com.shiro.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hongpengsun on 17/7/26.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("admin")
    public void admin(){
        System.out.print("admin");
    }


    @RequestMapping("list")
    public void list(){
        System.out.print("list");
    }

}

