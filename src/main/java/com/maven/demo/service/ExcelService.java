package com.maven.demo.service;



import com.maven.demo.bean.ExcelBean;
import com.maven.demo.dbutil.DBUtils;
import com.maven.demo.dbutil.ExcelUtils;
import com.maven.demo.doMain.TbStudent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ExcelService extends BaseService {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        ExcelService a=new ExcelService();
        a.excel();
    }
    /**
     * 导出excel查询方法
     *
     * @return
     */
    public String excel() throws IllegalAccessException, SQLException {
        List<TbStudent> excelList = list();
        System.out.println(excelList);
        ExcelBean excel = new ExcelBean();
        excel.setExcelName("学生管理系统导出表");
        excel.setSheetName("信息表");
        excel.setList(excelList);
        String[] title = new String[]{"学号", "姓名", "年龄", "年级", "分数"};
        excel.setTitle(title);
        String[] keys = new String[]{"id", "name", "age", "grade", "fraction"};
        excel.setKeys(keys);
        excel.setPath("D:\\poi");
        ExcelUtils.createExcel(excel);
        return "导出表.xlxs";
    }

    public List<TbStudent> list() throws SQLException {
        List<TbStudent> l = new ArrayList<>();
        ResultSet rs = DBUtils.getList("select * from tbstudent");
        while(rs.next()){
            TbStudent student=new TbStudent();
            student.setAge(rs.getInt("age"));
            student.setId(rs.getInt("id"));
            student.setGradeId(rs.getInt("gradeid"));
            student.setName(rs.getString("name"));
            l.add(student);
        }
        return l;
    }

}
