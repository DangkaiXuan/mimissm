package com.bjpowernode.service;

import com.bjpowernode.pojo.Admin;

public interface AdminService
{
    //登录
    public Admin login(String name, String pwd);
}
