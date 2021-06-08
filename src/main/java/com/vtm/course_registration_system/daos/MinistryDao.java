package com.vtm.course_registration_system.daos;

import com.vtm.course_registration_system.configs.HibernateUtil;
import com.vtm.course_registration_system.models.MinistryEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MinistryDao {
    public static List getList() {
        Session session = HibernateUtil.getSession();
        String hql = "select mi from MinistryEntity mi";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }

    public static MinistryEntity get(int id) {
        Session session = HibernateUtil.getSession();
        MinistryEntity ministryEntity = session.get(MinistryEntity.class, id);
        session.close();
        return ministryEntity;
    }

    public static Object[][] getDataTable() {
        Session session = HibernateUtil.getSession();
        String hql = "select mi from MinistryEntity mi";
        Query query = session.createQuery(hql);
        ArrayList<MinistryEntity> list = (ArrayList<MinistryEntity>) query.list();
        Object[][] dataTable = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            dataTable[i] = list.get(i).toArray();
        }
        session.close();
        return dataTable;
    }

    public static Boolean add(MinistryEntity ministryEntity) {
        if (MinistryDao.get(ministryEntity.getId()) != null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(ministryEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean update(MinistryEntity ministryEntity) {
        if (MinistryDao.get(ministryEntity.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(ministryEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean delete(int id) {
        MinistryEntity ministryEntity = MinistryDao.get(id);
        if (ministryEntity == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(ministryEntity);
        transaction.commit();
        session.close();
        return true;
    }
}
