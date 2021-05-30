package com.vtm.course_registration_system.daos;

import com.vtm.course_registration_system.HibernateUtil;
import com.vtm.course_registration_system.models.CourseregistrationsessionEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseregistrationsessionDao {
    public static List getList() {
        String hql = "from CourseregistrationsessionEntity";
        Session session = HibernateUtil.getSession();
        List list = session.createQuery(hql).list();
        session.close();
        return list;
    }
    public static CourseregistrationsessionEntity get(int id) {
        Session session = HibernateUtil.getSession();
        CourseregistrationsessionEntity courseregistrationsessionEntity = session.get(CourseregistrationsessionEntity.class, id);
        session.close();
        return courseregistrationsessionEntity;
    }
    public static Boolean add(CourseregistrationsessionEntity courseregistrationsessionEntity) {
        if(CourseregistrationsessionDao.get(courseregistrationsessionEntity.getId()) != null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction  = session.beginTransaction();
        session.save(courseregistrationsessionEntity);
        transaction.commit();
        session.close();
        return true;
    }
    public static Boolean update(CourseregistrationsessionEntity courseregistrationsessionEntity) {
        if (CourseregistrationsessionDao.get(courseregistrationsessionEntity.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(courseregistrationsessionEntity);
        transaction.commit();
        session.close();
        return true;
    }
    public static Boolean delete(CourseregistrationsessionEntity courseregistrationsessionEntity) {
        if (CourseregistrationsessionDao.get(courseregistrationsessionEntity.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(courseregistrationsessionEntity);
        transaction.commit();
        session.close();
        return true;
    }
}
