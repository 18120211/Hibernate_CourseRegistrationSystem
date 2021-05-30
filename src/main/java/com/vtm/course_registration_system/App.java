package com.vtm.course_registration_system;

import com.vtm.course_registration_system.daos.*;
import com.vtm.course_registration_system.models.*;


import javax.security.auth.Subject;
import java.io.*;
import java.nio.Buffer;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static SemesterEntity currentSemester;

    public static Boolean readCurrentSemester() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("src/main/resources/CurrentSemester.dat")));
            App.currentSemester = (SemesterEntity)objectInputStream.readObject();
            objectInputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean updateCurrentSemester() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("src/main/resources/CurrentSemester.dat")));
            objectOutputStream.writeObject(App.currentSemester);
            objectOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        App.readCurrentSemester();
        System.out.println(App.currentSemester);

//        Timestamp registrationDate = new Timestamp(211, 8, 16, 10, 0, 0, 0);
//        CourseregistrationEntity courseregistrationEntity = new CourseregistrationEntity(2,registrationDate
//                , StudentDao.get(1), CourseDao.get(2));
//        CourseregistrationDao.add(courseregistrationEntity);
//        courseregistrationEntity = new CourseregistrationEntity(3, registrationDate
//                , StudentDao.get(2), CourseDao.get(2));
//        CourseregistrationDao.add(courseregistrationEntity);
//
        ArrayList<CourseregistrationEntity> list = (ArrayList<CourseregistrationEntity>) CourseregistrationDao.getList();
        for (CourseregistrationEntity object :
                list) {
            System.out.println(object);
        }

    }
}
