package com.vtm.course_registration_system.models;

import java.sql.Timestamp;
import java.util.Objects;

public class CourseregistrationEntity {
    private int id;
    private Timestamp registraiondate;
    private StudentEntity studentByIdsv;
    private CourseEntity courseByIdco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getRegistraiondate() {
        return registraiondate;
    }

    public void setRegistraiondate(Timestamp registraiondate) {
        this.registraiondate = registraiondate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseregistrationEntity that = (CourseregistrationEntity) o;
        return id == that.id && Objects.equals(registraiondate, that.registraiondate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registraiondate);
    }

    public StudentEntity getStudentByIdsv() {
        return studentByIdsv;
    }

    public void setStudentByIdsv(StudentEntity studentByIdsv) {
        this.studentByIdsv = studentByIdsv;
    }

    public CourseEntity getCourseByIdco() {
        return courseByIdco;
    }

    public void setCourseByIdco(CourseEntity courseByIdco) {
        this.courseByIdco = courseByIdco;
    }

    public CourseregistrationEntity(){}

    public CourseregistrationEntity(int id, Timestamp registraiondate, StudentEntity studentByIdsv, CourseEntity courseByIdco) {
        this.id = id;
        this.registraiondate = registraiondate;
        this.studentByIdsv = studentByIdsv;
        this.courseByIdco = courseByIdco;
    }

    public CourseregistrationEntity(Timestamp registraiondate, StudentEntity studentByIdsv, CourseEntity courseByIdco) {
        this.registraiondate = registraiondate;
        this.studentByIdsv = studentByIdsv;
        this.courseByIdco = courseByIdco;
    }

    @Override
    public String toString() {
        return "CourseregistrationEntity{" +
                "id=" + id +
                ", registraiondate=" + registraiondate +
                ", studentByIdsv=" + studentByIdsv +
                ", courseByIdco=" + courseByIdco +
                '}';
    }


    public Object[] toArray() {
        Object[] array = new Object[7];
        array[0] = this.studentByIdsv.getCode();
        array[1] = this.studentByIdsv.getName();
        array[2] = this.courseByIdco.getSubjectByIdsu().getCode();
        array[3] = this.courseByIdco.getSubjectByIdsu().getName();
        array[4] = this.courseByIdco.getTeacher();
        array[5] = this.courseByIdco.getShift();
        array[6] = this.registraiondate;
        return array;
    }

}
