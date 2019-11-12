package com.maven.demo.service;

import com.maven.demo.bean.ResultBean;
import com.maven.demo.dbutil.DBUtils;
import com.maven.demo.doMain.TbStudent;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.SQLException;

@Component
public class InformationService extends Service {
    public ResultBean addStudent(TbStudent student) throws SQLException {
        TbStudent student1 = addStudentInformation(student);
        if (student1 != null) {
            ResultBean success = BaseService.success("录入成功");
            return success;
        }else {
            ResultBean success = BaseService.failure("录入失败");
            return success;
        }


    }

    public TbStudent addStudentInformation(TbStudent student) {//插入学生信息
         add(student);
        Conditions conditions=new Conditions(TbStudent.class);
        conditions.putEW("name",student.getName());
        TbStudent one = getOne(conditions);
        return one;
    }
}
