package com.vtm.course_registration_system.models;

import java.util.Objects;

public class CourseEntity {
    private int id;
    private String name;
    private Integer year;
    private String teacher;
    private String room;
    private String day;
    private Integer shift;
    private SubjectEntity subjectByIdsu;
    private MinistryEntity ministryByIdmi;
    private CourseregistrationsessionEntity courseregistrationsessionByIdcrs;

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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(year, that.year) && Objects.equals(teacher, that.teacher) && Objects.equals(room, that.room) && Objects.equals(day, that.day) && Objects.equals(shift, that.shift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, teacher, room, day, shift);
    }

    public SubjectEntity getSubjectByIdsu() {
        return subjectByIdsu;
    }

    public void setSubjectByIdsu(SubjectEntity subjectByIdsu) {
        this.subjectByIdsu = subjectByIdsu;
    }

    public MinistryEntity getMinistryByIdmi() {
        return ministryByIdmi;
    }

    public void setMinistryByIdmi(MinistryEntity ministryByIdmi) {
        this.ministryByIdmi = ministryByIdmi;
    }

    public CourseregistrationsessionEntity getCourseregistrationsessionByIdcrs() {
        return courseregistrationsessionByIdcrs;
    }

    public void setCourseregistrationsessionByIdcrs(CourseregistrationsessionEntity courseregistrationsessionByIdcrs) {
        this.courseregistrationsessionByIdcrs = courseregistrationsessionByIdcrs;
    }

    public CourseEntity(){}

    public CourseEntity(int id, String name, Integer year, String teacher, String room, String day, Integer shift, SubjectEntity subjectByIdsu, MinistryEntity ministryByIdmi, CourseregistrationsessionEntity courseregistrationsessionByIdcrs) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.teacher = teacher;
        this.room = room;
        this.day = day;
        this.shift = shift;
        this.subjectByIdsu = subjectByIdsu;
        this.ministryByIdmi = ministryByIdmi;
        this.courseregistrationsessionByIdcrs = courseregistrationsessionByIdcrs;
    }

    public CourseEntity(String name, Integer year, String teacher, String room, String day, Integer shift, SubjectEntity subjectByIdsu, MinistryEntity ministryByIdmi, CourseregistrationsessionEntity courseregistrationsessionByIdcrs) {
        this.name = name;
        this.year = year;
        this.teacher = teacher;
        this.room = room;
        this.day = day;
        this.shift = shift;
        this.subjectByIdsu = subjectByIdsu;
        this.ministryByIdmi = ministryByIdmi;
        this.courseregistrationsessionByIdcrs = courseregistrationsessionByIdcrs;
    }
    @Override
    public String toString() {
        return "CourseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", teacher='" + teacher + '\'' +
                ", room='" + room + '\'' +
                ", day='" + day + '\'' +
                ", shift=" + shift +
                ", subjectByIdsu=" + subjectByIdsu +
                ", ministryByIdmi=" + ministryByIdmi +
                ", courseregistrationsessionByIdcrs" + courseregistrationsessionByIdcrs +
                '}';
    }

    public Object[] toArray() {
        Object[] array = new Object[8];
        array[0] = this.id;
        array[1] = this.subjectByIdsu.getCode();
        array[2] = this.subjectByIdsu.getName();
        array[3] = this.subjectByIdsu.getNumcredit();
        array[4] = this.teacher;
        array[5] = this.room;
        array[6] = this.day;
        array[7] = this.shift;
        return array;
    }
}
