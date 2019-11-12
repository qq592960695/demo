package com.maven.demo.doMain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

@Component
public class TbResult  extends Domain {
    private int id;
    private int studentid;
    private int result;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
