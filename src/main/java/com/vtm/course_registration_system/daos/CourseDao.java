package com.vtm.course_registration_system.daos;

import com.vtm.course_registration_system.configs.HibernateUtil;
import com.vtm.course_registration_system.models.CourseEntity;
import com.vtm.course_registration_system.models.CourseregistrationEntity;
import com.vtm.course_registration_system.models.MinistryEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
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

    public static Object[][] getTableData() {
        ArrayList<CourseEntity> list = (ArrayList<CourseEntity>) CourseDao.getList();
        Object[][] dataTable = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            dataTable[i] = list.get(i).toArray();
        }
        return dataTable;
    }

    public static Object[][] getTableData(int idStudent) {
        ArrayList<CourseregistrationEntity> listRegistration =
                (ArrayList<CourseregistrationEntity>)CourseregistrationDao.getList();
        ArrayList<CourseEntity> list = new ArrayList<>();
        for (int i = 0; i < listRegistration.size(); i++) {
            if (listRegistration.get(i).getStudentByIdsv().getId() == idStudent) {
                list.add(listRegistration.get(i).getCourseByIdco());
            }
        }
        Object[][] dataTable = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            dataTable[i] = list.get(i).toArray();
        }
        return dataTable;
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
