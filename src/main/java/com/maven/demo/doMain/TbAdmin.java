package com.maven.demo.doMain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

@Component
public class TbAdmin extends Domain {
    private int id;//id
    private String username;//用户名
    private String password;//密码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
