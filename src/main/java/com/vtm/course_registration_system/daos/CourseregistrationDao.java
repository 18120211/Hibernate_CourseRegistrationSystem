package com.vtm.course_registration_system.daos;

import com.vtm.course_registration_system.configs.HibernateUtil;
import com.vtm.course_registration_system.models.CourseEntity;
import com.vtm.course_registration_system.models.CourseregistrationEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseregistrationDao {
    public static List getList() {
        Session session = HibernateUtil.getSession();
        String hql = "select sv from CourseregistrationEntity sv";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }

    public static CourseregistrationEntity get(int id) {
        Session session = HibernateUtil.getSession();
        CourseregistrationEntity courseregistrationEntity = session.get(CourseregistrationEntity.class, id);
        session.close();
        return courseregistrationEntity;
    }

    public static Object[][] getTableData() {
        ArrayList<CourseregistrationEntity> list = (ArrayList<CourseregistrationEntity>) CourseregistrationDao.getList();
        Object[][] dataTable = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            dataTable[i] = list.get(i).toArray();
        }
        return dataTable;
    }

    public static Object[][] getTableData(int idCourse) {
        ArrayList<CourseregistrationEntity> tmp = (ArrayList<CourseregistrationEntity>) CourseregistrationDao.getList();
        ArrayList<CourseregistrationEntity> list = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            if(tmp.get(i).getCourseByIdco().getId() == idCourse) {
                list.add(tmp.get(i));
            }
        }
        Object[][] dataTable = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            dataTable[i] = list.get(i).toArray();
        }
        return dataTable;
    }

    public static Boolean isRegistered(int idStudent, int idSubject) {
        ArrayList<CourseregistrationEntity> list =
                (ArrayList<CourseregistrationEntity>) CourseregistrationDao.getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCourseByIdco().getSubjectByIdsu().getId() == idSubject &&
                    list.get(i).getStudentByIdsv().getId() == idStudent) {
                return true;
            }
        }
        return false;
    }


    public static Boolean add(CourseregistrationEntity courseregistrationEntity) {
        if (CourseregistrationDao.get(courseregistrationEntity.getId()) != null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(courseregistrationEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean update(CourseregistrationEntity courseregistrationEntity) {
        if (CourseregistrationDao.get(courseregistrationEntity.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(courseregistrationEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean delete(int id) {
        CourseregistrationEntity courseregistrationEntity = CourseregistrationDao.get(id);
        if (courseregistrationEntity == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(courseregistrationEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean delete(int idStudent, int idCourse) {
        ArrayList<CourseregistrationEntity> list = (ArrayList<CourseregistrationEntity>)
                CourseregistrationDao.getList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentByIdsv().getId() == idStudent &&
                    list.get(i).getCourseByIdco().getId() == idCourse) {
                CourseregistrationDao.delete(list.get(i).getId());
                return true;
            }
        }
        return false;
    }

    public static void deleteAll() {
        
    }
}
