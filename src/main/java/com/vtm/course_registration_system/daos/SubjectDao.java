package com.vtm.course_registration_system.daos;

import com.vtm.course_registration_system.configs.HibernateUtil;
import com.vtm.course_registration_system.models.CourseEntity;
import com.vtm.course_registration_system.models.SubjectEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
    public static List getList() {
        Session session = HibernateUtil.getSession();
        String hql = "select su from SubjectEntity su";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }

    public static SubjectEntity get(int id) {
        Session session = HibernateUtil.getSession();
        SubjectEntity subjectEntity = session.get(SubjectEntity.class, id);
        session.close();
        return subjectEntity;
    }

    public static Boolean add(SubjectEntity subjectEntity) {
        if (SubjectDao.get(subjectEntity.getId()) != null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(subjectEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean update(SubjectEntity subjectEntity) {
        if (SubjectDao.get(subjectEntity.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(subjectEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean delete(int id) {
        SubjectEntity subjectEntity = SubjectDao.get(id);
        if (subjectEntity == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(subjectEntity);
        transaction.commit();
        session.close();
        return true;
    }
    
    public static Boolean deleteAllChild(int id) {
        SubjectEntity subjectEntity = SubjectDao.get(id);
        if (subjectEntity == null) {
            return false;
        }
        ArrayList<CourseEntity> list = (ArrayList<CourseEntity>)CourseDao.getList();
        for (CourseEntity courseEntity :
                list) {
            CourseDao.delete(courseEntity.getId());
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(subjectEntity);
        transaction.commit();
        session.close();
        return true;
    }
}
