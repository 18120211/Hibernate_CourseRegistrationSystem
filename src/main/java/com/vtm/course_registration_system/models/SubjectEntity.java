package com.vtm.course_registration_system.models;

import java.util.Objects;

public class SubjectEntity {
    private int id;
    private String code;
    private String name;
    private Integer numcredit;

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

    public Integer getNumcredit() {
        return numcredit;
    }

    public void setNumcredit(Integer numcredit) {
        this.numcredit = numcredit;
    }

    public SubjectEntity() {}

    public SubjectEntity(int id, String code, String name, Integer numcredit) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.numcredit = numcredit;
    }

    public SubjectEntity(String code, String name, Integer numcredit) {
        this.code = code;
        this.name = name;
        this.numcredit = numcredit;
    }


    @Override
    public String toString() {
        return "SubjectEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", numcredit=" + numcredit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return id == that.id && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(numcredit, that.numcredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, numcredit);
    }
}
