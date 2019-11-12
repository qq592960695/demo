package com.maven.demo.controller;


import com.maven.demo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @RequestMapping("/aa")
    @ResponseBody
    public String a() throws SQLException, IllegalAccessException {
        String excel = excelService.excel();
        return excel;
    }


}
