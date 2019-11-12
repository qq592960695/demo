package com.maven.demo.doMain;

import net.atomarrow.domains.Domain;
import org.springframework.stereotype.Component;

@Component
public class TbStudent  extends Domain {
    private int id;
    private String name;
    private int age;
    private int gradeId; //成绩表id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }


}
