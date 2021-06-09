package com.vtm.course_registration_system.daos;

import com.vtm.course_registration_system.configs.HibernateUtil;
import com.vtm.course_registration_system.models.ClassEntity;
import com.vtm.course_registration_system.models.SemesterEntity;
import com.vtm.course_registration_system.models.StudentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static List getList() {
        Session session = HibernateUtil.getSession();
        String hql = "select sv from StudentEntity sv";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
//        return session.createQuery(hql).list();
    }

    public static StudentEntity get(int id) {
        Session session = HibernateUtil.getSession();
        StudentEntity studentEntity = session.get(StudentEntity.class, id);
        session.close();
        return studentEntity;
    }

    public static Object[][] getTableData() {
        ArrayList<StudentEntity> list = (ArrayList<StudentEntity>) StudentDao.getList();
        Object[][] dataTable = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            dataTable[i] = list.get(i).toArray();
        }
        return dataTable;
    }

    public static Boolean add(StudentEntity studentEntity) {
        if (StudentDao.get(studentEntity.getId()) != null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(studentEntity);
        transaction.commit();
        session.close();
        ClassEntity classEntity = ClassDao.get(studentEntity.getClassByIdcl().getId());
        if (studentEntity.getSex().equals("Nam")) {
            classEntity.setNummale(classEntity.getNummale() + 1);
        }
        else {
            classEntity.setNumfemale(classEntity.getNumfemale() + 1);
        }
        ClassDao.update(classEntity);
        return true;
    }

    public static Boolean update(StudentEntity studentEntity) {
        if (StudentDao.get(studentEntity.getId()) == null) {
            return false;
        }
        StudentEntity oldStudent = StudentDao.get(studentEntity.getId());
        if (oldStudent.getClassByIdcl().getId() != studentEntity.getClassByIdcl().getId() ) {
            if (oldStudent.getSex().equals(studentEntity.getSex())) {
                ClassEntity newClass = ClassDao.get(studentEntity.getClassByIdcl().getId());
                ClassEntity oldClass = ClassDao.get(oldStudent.getClassByIdcl().getId());
                if (studentEntity.getSex().equals("Nam")) {
                    newClass.setNummale(newClass.getNummale() + 1);
                    oldClass.setNummale(oldClass.getNummale() - 1);
                }
                else {
                    newClass.setNumfemale(newClass.getNumfemale() + 1);
                    oldClass.setNumfemale(oldClass.getNumfemale() - 1);
                }
                studentEntity.setClassByIdcl(newClass);
                ClassDao.update(oldClass);
            }
            else {
                ClassEntity newClass = ClassDao.get(studentEntity.getClassByIdcl().getId());
                ClassEntity oldClass = ClassDao.get(oldStudent.getClassByIdcl().getId());
                if (studentEntity.getSex().equals("Nam")) {
                    newClass.setNummale(newClass.getNummale() + 1);
                    oldClass.setNumfemale(oldClass.getNumfemale() - 1);
                }
                else {
                    newClass.setNumfemale(newClass.getNumfemale() + 1);
                    oldClass.setNummale(oldClass.getNummale() - 1);
                }
                studentEntity.setClassByIdcl(newClass);
                ClassDao.update(oldClass);
            }
        }
        else {
            if(!oldStudent.getSex().equals(studentEntity.getSex())) {
                ClassEntity classEntity = ClassDao.get(studentEntity.getClassByIdcl().getId());
                if (studentEntity.getSex().equals("Nam")) {
                    classEntity.setNummale(classEntity.getNummale() + 1);
                    classEntity.setNumfemale(classEntity.getNumfemale() - 1);
                }
                else {
                    classEntity.setNummale(classEntity.getNummale() - 1);
                    classEntity.setNumfemale(classEntity.getNumfemale() + 1);
                }
                studentEntity.setClassByIdcl(classEntity);
            }
        }

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(studentEntity);
        transaction.commit();
        session.close();
        return true;
    }

    public static Boolean delete(int id) {
        StudentEntity studentEntity = StudentDao.get(id);
        if (studentEntity == null) {
            return false;
        }
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(studentEntity);
        transaction.commit();
        session.close();
        ClassEntity classEntity = ClassDao.get(studentEntity.getClassByIdcl().getId());
        if (studentEntity.getSex().equals("Nam")) {
            classEntity.setNummale(classEntity.getNummale() - 1);
        }
        else if (studentEntity.getSex().equals("Nữ")) {
            classEntity.setNumfemale(classEntity.getNumfemale() - 1);
        }
        ClassDao.update(classEntity);
        return true;
    }
}
