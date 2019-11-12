package com.maven.demo.service;

import com.maven.demo.bean.QueryBean;
import com.maven.demo.bean.TableBean;
import com.maven.demo.dbutil.Page;
import com.maven.demo.doMain.TbStudent;
import net.atomarrow.db.parser.Conditions;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
/**
 * 查询所有学生信息
 */
public class StudentQueryService extends TableService{
    public TableBean getPageList(QueryBean student) throws SQLException {
        List<QueryBean> list = ListPage(student);
        int count = getCount(student);
        return success(count, list);
    }
    public TableBean getJingPage(Page page) throws SQLException {
        List<QueryBean> list = jing(page);
        int count = getjingCount();
        return success(count, list);
    }

    /**
     * 动态生成数据
     *
     * @param
     * @param student
     * @return
     * @throws SQLException
     */
    public List<QueryBean> ListPage(QueryBean student){
        Conditions conditions=new Conditions(TbStudent.class);
        conditions.setReturnClass(QueryBean.class);
        conditions.setSelectValue(" s.id, s.name,s.age,g.grade,r.result");
        conditions.setJoin("s join tbresult as r on s.id = r.studentid join tbgrade as g on s.gradeid = g.id");
        conditions.putLIKE("name",student.getName());
        conditions.putLIKE("grade",student.getGrade());
        List<QueryBean> list = getList(conditions);
        return list;
    }

    /**
     * 动态生成数据总条数
     *
     * @param student
     * @return
     * @throws SQLException
     */
    public int getCount(QueryBean student) throws SQLException {
        Conditions conditions=new Conditions(TbStudent.class);
        conditions.setReturnClass(QueryBean.class);
        conditions.setSelectValue(" s.id, s.name,s.age,g.grade,r.result");
        conditions.setJoin("s join tbresult as r on s.id = r.studentid join tbgrade as g on s.gradeid = g.id");
        conditions.putLIKE("s.name",student.getName());
        conditions.putLIKE("r.grade",student.getGrade());
        int count = getCount(conditions);
        System.out.println("count" + count);
        return count;
    }
    public List<QueryBean> jing(Page page) throws SQLException {
        Conditions conditions=new Conditions(TbStudent.class);
        conditions.setReturnClass(QueryBean.class);
        conditions.setSelectValue(" s.id, s.name,s.age,g.grade,r.result");
        conditions.setJoin("s join tbresult as r on s.id = r.studentid join tbgrade as g on s.gradeid = g.id");
        conditions.putLIKE("s.name","'%%'");
        conditions.putLIKE("r.grade","'%%'");
        List<QueryBean> list = getList(conditions);
        return list;
    }
    public int getjingCount() throws SQLException {
        Conditions conditions=new Conditions(TbStudent.class);
        conditions.setReturnClass(QueryBean.class);
        conditions.setSelectValue(" s.id, s.name,s.age,g.grade,r.result");
        conditions.setJoin("s join tbresult as r on s.id = r.studentid join tbgrade as g on s.gradeid = g.id");
        conditions.putLIKE("s.name","'%%'");
        conditions.putLIKE("r.grade","'%%'");
        int count= getCount(conditions);
        System.out.println("count" + count);
        return count;
    }

}



