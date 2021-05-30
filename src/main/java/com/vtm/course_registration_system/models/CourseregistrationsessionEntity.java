package com.vtm.course_registration_system.models;

import java.sql.Date;
import java.util.Objects;

public class CourseregistrationsessionEntity {
    private int id;
    private Date startdate;
    private Date enddate;
    private SemesterEntity semesterByIdse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseregistrationsessionEntity that = (CourseregistrationsessionEntity) o;
        return id == that.id && Objects.equals(startdate, that.startdate) && Objects.equals(enddate, that.enddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startdate, enddate);
    }

    public SemesterEntity getSemesterByIdse() {
        return semesterByIdse;
    }

    public void setSemesterByIdse(SemesterEntity semesterByIdse) {
        this.semesterByIdse = semesterByIdse;
    }

    public CourseregistrationsessionEntity() {}

    public CourseregistrationsessionEntity(int id, Date startdate, Date enddate, SemesterEntity semesterByIdse) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.semesterByIdse = semesterByIdse;
    }

    @Override
    public String toString() {
        return "CourseregistrationsessionEntity{" +
                "id=" + id +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", semesterByIdse=" + semesterByIdse +
                '}';
    }
}
