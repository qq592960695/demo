package com.maven.demo.service;


import com.maven.demo.bean.ResultBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class BaseService {
    public static ResultBean success() {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(true);
        resultBean.setCode("0");
        resultBean.setData(null);
        return resultBean;
    }

    public static ResultBean success(Object data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(true);
        resultBean.setCode("0");
        resultBean.setData(data);
        return resultBean;
    }

    public static  ResultBean failure() {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", "");
        return resultBean;
    }

    public static ResultBean failure(String msg) {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", msg);
        return resultBean;
    }

    public static ResultBean failure(int code) {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", "");
        return resultBean;
    }

    public static ResultBean failure(int code, String msg) {
        ResultBean resultBean = new ResultBean();
        resultBean.setSuccess(false);
        resultBean.setCode("-1");
        resultBean.setMsg("msg", msg);
        return resultBean;
    }
}
