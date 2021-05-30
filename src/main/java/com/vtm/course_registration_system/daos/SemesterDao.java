package com.vtm.course_registration_system.daos;

import com.vtm.course_registration_system.HibernateUtil;
import com.vtm.course_registration_system.models.SemesterEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SemesterDao {
    public static List getList() {
        Session session = HibernateUtil.getSession();
        String hql = "select se from SemesterEntity se";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }

    public static SemesterEntity get(int id) {
        Session session = HibernateUtil.getSession();
        SemesterEntity semesterEntity = session.get(SemesterEntity.class, id);
        session.close();
        return semesterEntity;
    }

    public static Boolean add(SemesterEntity semesterEntity) {
        if (SemesterDao.get(semesterEntity.getId()) != null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(semesterEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean update(SemesterEntity semesterEntity) {
        if (SemesterDao.get(semesterEntity.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(semesterEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean delete(int id) {
        SemesterEntity semesterEntity = SemesterDao.get(id);
        if (semesterEntity == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(semesterEntity);
        transaction.commit();
        session.close();
        return true;
    }
}
