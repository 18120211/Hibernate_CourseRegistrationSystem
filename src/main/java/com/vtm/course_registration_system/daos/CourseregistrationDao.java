package com.vtm.course_registration_system.daos;

import com.vtm.course_registration_system.HibernateUtil;
import com.vtm.course_registration_system.models.CourseregistrationEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CourseregistrationDao {
    public static List getList() {
        Session session = HibernateUtil.getSession();
        String hql = "select sv from CourseregistrationEntity sv";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
//        return session.createQuery(hql).list();
    }

    public static CourseregistrationEntity get(int id) {
        Session session = HibernateUtil.getSession();
        CourseregistrationEntity courseregistrationEntity = session.get(CourseregistrationEntity.class, id);
        session.close();
        return courseregistrationEntity;
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

    public static void deleteAll() {
        
    }
}
