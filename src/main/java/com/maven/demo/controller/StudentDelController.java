package com.maven.demo.controller;

import com.maven.demo.bean.QueryBean;
import com.maven.demo.doMain.TbResult;
import com.maven.demo.doMain.TbStudent;
import com.maven.demo.service.StudentDelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class StudentDelController {
    @Autowired
    StudentDelService service;
    @RequestMapping("/del")
    @ResponseBody
    public void del(TbStudent student, TbResult result) throws SQLException {
        service.doDel(student,result);
    }
}
