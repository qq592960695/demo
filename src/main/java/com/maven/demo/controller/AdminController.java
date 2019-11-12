package com.maven.demo.controller;

import com.maven.demo.bean.ResultBean;
import com.maven.demo.doMain.TbAdmin;
import com.maven.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")//登陆
    public String login( TbAdmin admin) throws SQLException {
        return "login";
    }

    @RequestMapping("/erro")//判断账号密码
    @ResponseBody
    public ResultBean erro(TbAdmin admin) throws SQLException {
        System.out.println("aaaaaa");
        ResultBean success = adminService.adminList(admin);
        return success;
    }

    @RequestMapping("/registered")//注册
    public String registered() {
        return "registered";
    }

    @RequestMapping("/updateRegistered")//判断账号是否重复
    @ResponseBody
    public ResultBean updateRegistered(TbAdmin admin) throws SQLException {
        ResultBean success = adminService.updateAdmin(admin);
        return success;
    }
}
