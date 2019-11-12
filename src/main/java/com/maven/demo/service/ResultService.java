package com.maven.demo.service;

import com.maven.demo.bean.ResultBean;
import com.maven.demo.doMain.TbResult;
import com.maven.demo.doMain.TbStudent;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;
import java.sql.SQLException;


@Component
public class ResultService extends Service {
    public ResultBean addResultSet(TbStudent student,TbResult result) throws SQLException {
        addResult(result,student);
        return BaseService.success("录入成功");
    }

    public  TbStudent getStudentId(TbStudent student)  {//获取学生id
        Conditions conditions=new Conditions(TbStudent.class);
        conditions.putEW("name",student.getName());
        TbStudent studentId = getOne(conditions);
        return studentId;
    }

    public void addResult(TbResult result,TbStudent student) {//插入数据库
        TbStudent studentId = getStudentId(student);
            result.setStudentid(studentId.getId());
            add(result);
    }
}
