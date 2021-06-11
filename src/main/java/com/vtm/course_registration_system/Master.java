package com.vtm.course_registration_system;

import com.vtm.course_registration_system.configs.HibernateUtil;
import com.vtm.course_registration_system.configs.Local;
import com.vtm.course_registration_system.daos.*;
import com.vtm.course_registration_system.enums.UserType;
import com.vtm.course_registration_system.jframes.Dashboard;
import com.vtm.course_registration_system.jframes.Login;
import com.vtm.course_registration_system.jframes.Portal;
import com.vtm.course_registration_system.models.MinistryEntity;
import com.vtm.course_registration_system.models.SemesterEntity;
import com.vtm.course_registration_system.models.StudentEntity;
import org.hibernate.Session;

import java.util.ArrayList;

public class Master {
    private static Master instance;

    private Master() {

        Local.currentSemester = SemesterDao.get(1);
        Local.updateCurrentSemester();
        Local.readCurrentSemester();
        System.out.println("HK hiện tại: " + Local.currentSemester.toString());
//        Connect to db;
//        Session session = HibernateUtil.getSession();
//        session.close();
    }

    public static Master getInstance() {
        if (Master.instance == null) {
            Master.instance = new Master();
        }
        return Master.instance;
    }

    public static UserType login(String username, String password) {
        ArrayList<MinistryEntity> listMin = (ArrayList<MinistryEntity>) MinistryDao.getList();
        ArrayList<StudentEntity> listStu = (ArrayList<StudentEntity>) StudentDao.getList();
        for (MinistryEntity obj :
                listMin) {
            if (obj.getUsername().equals(username) && obj.getPassword().equals(password)) {
                Local.userID = obj.getId();
                Local.userType = UserType.MINISTRY;
                Local.isAuthenticated = true;
                Local.user = obj;
                return UserType.MINISTRY;
            }
        }
        for (StudentEntity obj :
                listStu) {
            if (obj.getUsername().equals(username) && obj.getPassword().equals(password)) {
                Local.userID = obj.getId();
                Local.userType = UserType.STUDENT;
                Local.isAuthenticated = true;
                Local.user = obj;
                return UserType.STUDENT;
            }
        }
        return null;
    }

    public static void loadDataMinistry() {
        Dashboard.listMinitry = MinistryDao.getTableData();
        Dashboard.listSubject = SubjectDao.getTableData();
        Dashboard.listSemester = SemesterDao.getTableData();
        Dashboard.listClass = ClassDao.getTableData();
        Dashboard.listStudent = StudentDao.getTableData();
        Dashboard.listSession = CourseregistrationsessionDao.getTableData();
        Dashboard.listCourse = CourseDao.getTableData();
//        Dashboard.listRegistration = CourseregistrationDao.getTableData();
    }

    public static void loadDataStudent() {
        Portal.listCourse = CourseDao.getTableData();
        Portal.listRegister = CourseDao.getTableData(Local.userID);
    }

    public void run() {
        Login.main(null);
    }
}
