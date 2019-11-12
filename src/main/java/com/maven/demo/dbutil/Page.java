package com.maven.demo.dbutil;

import com.maven.demo.bean.QueryBean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Page {
    private int count;//数据总条数
    private int page=1;//当前页数

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
