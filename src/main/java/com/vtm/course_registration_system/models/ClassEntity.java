package com.vtm.course_registration_system.models;

import java.util.Objects;

public class ClassEntity {
    private int id;
    private String name;
    private Integer nummale;
    private Integer numfemale;

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

    public Integer getNummale() {
        return nummale;
    }

    public void setNummale(Integer nummale) {
        this.nummale = nummale;
    }

    public Integer getNumfemale() {
        return numfemale;
    }

    public void setNumfemale(Integer numfemale) {
        this.numfemale = numfemale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassEntity that = (ClassEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(nummale, that.nummale) && Objects.equals(numfemale, that.numfemale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nummale, numfemale);
    }

    public ClassEntity(){}

    public ClassEntity(int id, String name, Integer nummale, Integer numfemale) {
        this.id = id;
        this.name = name;
        this.nummale = nummale;
        this.numfemale = numfemale;
    }

    public ClassEntity(String name, Integer nummale, Integer numfemale) {
        this.name = name;
        this.nummale = nummale;
        this.numfemale = numfemale;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nummale=" + nummale +
                ", numfemale=" + numfemale +
                '}';
    }

    public Object[] toArray() {
        Object[] array = new Object[4];
        array[0] = this.id;
        array[1] = this.name;
        array[2] = this.nummale;
        array[3] = this.numfemale;
        return array;
    }
}
