package com.vtm.course_registration_system.models;

import java.sql.Date;
import java.util.Objects;

public class StudentEntity {
    private int id;
    private String username;
    private String password;
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

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

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

    public StudentEntity(int id, String username, String password, String code,
                         String name, String sex, Date birth, Integer numsubject,
                         ClassEntity classByIdcl) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.numsubject = numsubject;
        this.classByIdcl = classByIdcl;
    }

    public StudentEntity(String username, String password, String code, String name,
                         String sex, Date birth, Integer numsubject, ClassEntity classByIdcl) {
        this.username = username;
        this.password = password;
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", numsubject=" + numsubject +
                ", classByIdcl=" + classByIdcl +
                '}';
    }
}
