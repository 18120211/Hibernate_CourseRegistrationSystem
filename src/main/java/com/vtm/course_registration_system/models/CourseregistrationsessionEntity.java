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

    public CourseregistrationsessionEntity(Date startdate, Date enddate, SemesterEntity semesterByIdse) {
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

    public Object[] toArray() {
        Object[] array = new Object[4];
        array[0] = this.id;
        array[1] = this.startdate;
        array[2] = this.enddate;
        array[3] = this.semesterByIdse.getName();
        return array;
    }

    public static boolean isValid(SemesterEntity semesterEntity, Date startDate, Date endDate) {
        if (startDate.after(semesterEntity.getStartdate()) || endDate.after(semesterEntity.getStartdate())) {
            return false;
        }
        return true;
    }
}
