package com.maven.demo.controller;
import com.maven.demo.bean.ResultBean;
import com.maven.demo.doMain.TbResult;
import com.maven.demo.doMain.TbStudent;
import com.maven.demo.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class ResultController {
    @Autowired
    ResultService service;

    @RequestMapping("/add")
    public String addResult() {
        return "addresult";
    }

    @RequestMapping("/addresult")
    @ResponseBody
    public ResultBean addresult(TbStudent student, TbResult result) throws SQLException {
        ResultBean success = service.addResultSet(student,result);
        return success;

    }
}
