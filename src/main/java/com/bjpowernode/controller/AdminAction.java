package com.bjpowernode.controller;

import com.bjpowernode.pojo.Admin;
import com.bjpowernode.service.AdminService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@MapperScan("com.bjpowernode.controller")
@Controller
@RequestMapping("/admin")
public class AdminAction {
    //切记：再所有的界面层,一定会有业务逻辑层的对象
    @Resource
    AdminService adminService;

    //实现登录判断，并进行相应的跳转
    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request) {

        Admin admin = adminService.login(name,pwd);
        if (admin != null) {
            //登录成功
            request.setAttribute("admin",admin);
            return "main";
        } else {
            //登录失败
            request.setAttribute("errmsg","用户名或密码不正确");
            return "login";
        }

    }
}
