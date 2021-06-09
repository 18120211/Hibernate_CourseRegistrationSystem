package com.vtm.course_registration_system.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class SemesterEntity implements Serializable {
    private int id;
    private String name;
    private Integer year;
    private Date startdate;
    private Date enddate;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public SemesterEntity(){}

    public SemesterEntity(int id, String name, Integer year, Date startdate, Date enddate) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.startdate = startdate;
        this.enddate = enddate;
    }
    public SemesterEntity(String name, Integer year, Date startdate, Date enddate) {
        this.name = name;
        this.year = year;
        this.startdate = startdate;
        this.enddate = enddate;
    }


    @Override
    public String toString() {
        return "SemesterEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                '}';
    }

    public Object[] toArray() {
        Object[] array = new Object[5];
        array[0] = this.id;
        array[1] = this.name;
        array[2] = this.year;
        array[3] = this.startdate;
        array[4] = this.enddate;
        return array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemesterEntity that = (SemesterEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(year, that.year) && Objects.equals(startdate, that.startdate) && Objects.equals(enddate, that.enddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, startdate, enddate);
    }
}
