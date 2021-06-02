package com.vtm.course_registration_system.daos;

import com.vtm.course_registration_system.configs.HibernateUtil;
import com.vtm.course_registration_system.models.ClassEntity;
import com.vtm.course_registration_system.models.StudentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ClassDao {
    public static List getList() {
        Session session = HibernateUtil.getSession();
        String hql = "select cl from ClassEntity cl";
        List list = session.createQuery(hql).list();
        session.close();
        return list;
    }
    public static ClassEntity get(int id) {
        Session session = HibernateUtil.getSession();
        ClassEntity classEntity = session.get(ClassEntity.class, id);
        session.close();
        return classEntity;
    }
    public static Boolean add(ClassEntity classEntity) {
        if (ClassDao.get(classEntity.getId()) != null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(classEntity);
        transaction.commit();
        session.close();
        return true;
    }
    public static Boolean update(ClassEntity classEntity) {
        if (ClassDao.get(classEntity.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(classEntity);
        transaction.commit();
        session.close();
        return true;
    }
    public static Boolean updateNumerStudent(ClassEntity classEntity) {
        if (ClassDao.get(classEntity.getId()) == null) {
            return false;
        }
        int nummale = 0;
        int numfemale = 0;
        ArrayList<StudentEntity> list = (ArrayList<StudentEntity>) StudentDao.getList();
        for (StudentEntity studentEntity :
                list) {
            if (studentEntity.getClassByIdcl() == classEntity) {
                if (studentEntity.getSex().equals("Nam")) {
                    nummale  += 1;
                }
                else if(studentEntity.getSex().equals("Nữ")) {
                    numfemale += 1;
                }
            }
        }
        classEntity.setNummale(nummale);
        classEntity.setNumfemale(numfemale);
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(classEntity);
        transaction.commit();
        session.close();
        return true;
    }
    public static Boolean delete(int id) {
        ClassEntity classEntity = ClassDao.get(id);
        if (classEntity == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(classEntity);
        transaction.commit();
        session.close();
        return true;
    }
    public static Boolean deleteClassAndAllChild(int id) {
        ClassEntity classEntity = ClassDao.get(id);
        if (classEntity == null) {
            return false;
        }
        ArrayList<StudentEntity> list = (ArrayList<StudentEntity>)StudentDao.getList();
        for (StudentEntity studentEntity :
                list) {
            StudentDao.deleteStudent(studentEntity.getId());
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(classEntity);
        transaction.commit();
        session.close();
        return true;
    }

}
