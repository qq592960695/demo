package com.maven.demo.service;

import com.maven.demo.bean.ResultBean;
import com.maven.demo.dbutil.DBUtils;
import com.maven.demo.dbutil.Md5Utils;
import com.maven.demo.doMain.TbAdmin;
import net.atomarrow.db.parser.Conditions;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.sql.SQLException;


@Component
public class AdminService extends Service {
    public ResultBean adminList(TbAdmin admin) throws SQLException {//判断账号密码是否正确

        if (admin.getPassword()==""||admin.getUsername()==""){

            ResultBean success = BaseService.failure("请将内容填写完整");
            return success;
        }else {
            int size = update(admin);
            if (size==0){
                ResultBean success = BaseService.failure("账号不存在");
                return success;
            }else {
                TbAdmin list = list(admin);
                TbAdmin adminPassword = list(admin);
                System.out.println(adminPassword.getPassword().equals(Md5Utils.md5Utils(admin.getPassword())));
                    if (adminPassword.getPassword().equals(Md5Utils.md5Utils(admin.getPassword()))){
                        return BaseService.success();
                    }else {
                        return BaseService.failure("密码不正确");
                    }
            }
        }
    }

    public TbAdmin list(TbAdmin admin) throws SQLException { //查询账号密码
        System.out.println(admin.getUsername()+admin.getPassword());
        Conditions conditions=new Conditions(TbAdmin.class);
        conditions.putEW("username",admin.getUsername());
        TbAdmin one = getOne(conditions);
        return  one;
    }
    public int update(TbAdmin admin) throws SQLException {//询账户是否存在
        Conditions conditions=new Conditions(TbAdmin.class);
        conditions.putEW("username",admin.getUsername());
        int count = getCount(conditions);
        return count;
    }
    public ResultBean updateAdmin(TbAdmin admin) throws SQLException {//注册时判断账号是否重复，是否为空
        System.out.println("service");
        System.out.println("账号"+admin.getUsername());
        System.out.println("密码"+admin.getPassword());
        if (admin.getPassword()==""||admin.getUsername()==""){
            System.out.println("***************");
            ResultBean success = BaseService.failure("输入不能为空");
            return success;
        }else {
            int size = update(admin);
            if (size==0){
                String password = Md5Utils.md5Utils(admin.getPassword());
                admin.setPassword(password);
                add(admin);
                ResultBean success = BaseService.success("注册成功");
                return success;
            }
            else {
                ResultBean success = BaseService.failure("账号已存在");
                return success;
            }
        }

    }

}
