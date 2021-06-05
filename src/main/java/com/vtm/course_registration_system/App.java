package com.vtm.course_registration_system;

import com.vtm.course_registration_system.configs.Local;
import com.vtm.course_registration_system.daos.*;
import com.vtm.course_registration_system.models.CourseregistrationEntity;
import com.vtm.course_registration_system.models.SemesterEntity;
import com.vtm.course_registration_system.models.StudentEntity;

import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class App {


    public static void main(String[] args) {
        Local.readCurrentSemester();
        System.out.println(Local.currentSemester);

//        Timestamp registrationDate = new Timestamp(211, 8, 16, 10, 0, 0, 0);
//        CourseregistrationEntity courseregistrationEntity = new CourseregistrationEntity(2,registrationDate
//                , StudentDao.get(1), CourseDao.get(2));
//        CourseregistrationDao.add(courseregistrationEntity);
//        courseregistrationEntity = new CourseregistrationEntity(3, registrationDate
//                , StudentDao.get(2), CourseDao.get(2));
//        CourseregistrationDao.add(courseregistrationEntity);
//

//        Date date = new Date(211, 5, 5);
//        StudentEntity studentEntity = new StudentEntity("temp", "temp", "Nam",
//                date, 5, ClassDao.get(1));
//        StudentDao.add(studentEntity);
//

//        CourseregistrationEntity courseregistrationEntity = new CourseregistrationEntity(
//                new Timestamp(211, 11, 16, 0, 0, 0, 0),
//                StudentDao.get(1), CourseDao.get(1)
//        );
//        CourseregistrationDao.add(courseregistrationEntity);
//        ArrayList<CourseregistrationEntity> list = (ArrayList<CourseregistrationEntity>) CourseregistrationDao.getList();
//        list.forEach(obj -> System.out.println(obj));


    }
}
