package com.maven.demo.controller;

import com.maven.demo.bean.ResultBean;
import com.maven.demo.doMain.TbStudent;
import com.maven.demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class StudentController {//录入学生页面
    @Autowired
    InformationService service=new InformationService();
    @RequestMapping("/information")
    public String information(){
        return "information";
    }
    @RequestMapping("/save")
    @ResponseBody
    public ResultBean save(TbStudent student) throws SQLException {//录入学生信息
        ResultBean success = service.addStudent(student);
        return success;
    }
}
