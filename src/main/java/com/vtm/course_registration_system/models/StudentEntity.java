package com.vtm.course_registration_system.models;

import java.sql.Date;
import java.util.Objects;

public class StudentEntity {
    private int id;
    private String code;
    private String name;
    private String sex;
    private Date birth;
    private Integer numsubject;
    private ClassEntity classByIdcl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getNumsubject() {
        return numsubject;
    }

    public void setNumsubject(Integer numsubject) {
        this.numsubject = numsubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(sex, that.sex) && Objects.equals(birth, that.birth) && Objects.equals(numsubject, that.numsubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, sex, birth, numsubject);
    }

    public ClassEntity getClassByIdcl() {
        return classByIdcl;
    }

    public void setClassByIdcl(ClassEntity classByIdcl) {
        this.classByIdcl = classByIdcl;
    }

    public StudentEntity(){}

    public StudentEntity(int id, String code, String name, String sex, Date birth, Integer numsubject, ClassEntity classByIdcl) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.numsubject = numsubject;
        this.classByIdcl = classByIdcl;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", numsubject=" + numsubject +
                ", classByIdcl=" + classByIdcl +
                '}';
    }
}
