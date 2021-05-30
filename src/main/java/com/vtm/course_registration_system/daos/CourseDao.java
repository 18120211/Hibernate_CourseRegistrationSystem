package com.vtm.course_registration_system.daos;

import com.vtm.course_registration_system.HibernateUtil;
import com.vtm.course_registration_system.models.CourseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDao {
    public static List getList() {
        Session session = HibernateUtil.getSession();
        String hql = "select co from CourseEntity co";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }

    public static CourseEntity get(int id) {
        Session session = HibernateUtil.getSession();
        CourseEntity courseEntity = session.get(CourseEntity.class, id);
        session.close();
        return courseEntity;
    }

    public static Boolean add(CourseEntity courseEntity) {
        if (CourseDao.get(courseEntity.getId()) != null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(courseEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean update(CourseEntity courseEntity) {
        if (CourseDao.get(courseEntity.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(courseEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean delete(int id) {
        CourseEntity courseEntity = CourseDao.get(id);
        if (courseEntity == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(courseEntity);
        transaction.commit();
        session.close();
        return true;
    }
}
