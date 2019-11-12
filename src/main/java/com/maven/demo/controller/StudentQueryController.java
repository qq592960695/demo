package com.maven.demo.controller;

import com.maven.demo.bean.QueryBean;
import com.maven.demo.bean.TableBean;
import com.maven.demo.dbutil.Page;
import com.maven.demo.service.StudentQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
public class StudentQueryController {
    @Autowired
    StudentQueryService service;

    @RequestMapping("/Student")
    public String table() {
        return "table";
    }
    @RequestMapping("/all")
    @ResponseBody
    public TableBean all(QueryBean student) throws SQLException {
        TableBean success = service.getPageList(student);
        return success;
    }
    @RequestMapping("/jing")
    @ResponseBody
    public TableBean jing(Page page) throws SQLException {
        TableBean success = service.getJingPage(page);
        return success;
    }

}
