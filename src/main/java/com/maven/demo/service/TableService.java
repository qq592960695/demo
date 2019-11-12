package com.maven.demo.service;

import com.maven.demo.bean.ResultBean;
import com.maven.demo.bean.TableBean;
import net.atomarrow.services.Service;
import org.springframework.stereotype.Component;

@Component
public class TableService extends Service {
    public static TableBean success(int count,Object object) {
        TableBean tableBean=new TableBean();
        tableBean.setCode(0);
        tableBean.setMsg("");
        tableBean.setCount(count);
        tableBean.setData(object);
        return tableBean;
    }

}
