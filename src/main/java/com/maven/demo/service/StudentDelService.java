package com.maven.demo.service;

import com.maven.demo.bean.QueryBean;
import com.maven.demo.dbutil.DBUtils;
import com.maven.demo.doMain.TbResult;
import com.maven.demo.doMain.TbStudent;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class StudentDelService extends Service {
    public void doDel(TbStudent student, TbResult result) throws SQLException {
              del(student,result);
    }
    public void del(TbStudent student, TbResult result) throws SQLException {
        del(student);
        del(result);
    }
}
