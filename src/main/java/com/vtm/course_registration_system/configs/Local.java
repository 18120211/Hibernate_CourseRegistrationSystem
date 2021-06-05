package com.vtm.course_registration_system.configs;

import com.vtm.course_registration_system.App;
import com.vtm.course_registration_system.enums.UserType;
import com.vtm.course_registration_system.models.SemesterEntity;

import java.io.*;

public class Local {
    public static String userID;
    public static UserType userType;
    public static Boolean isAuthenticated;
    public static Boolean isLogged;
    public static SemesterEntity currentSemester;

    public static Boolean readCurrentSemester() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("src/main/resources/CurrentSemester.dat")));
            Local.currentSemester = (SemesterEntity) objectInputStream.readObject();
            objectInputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean updateCurrentSemester() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("src/main/resources/CurrentSemester.dat")));
            objectOutputStream.writeObject(Local.currentSemester);
            objectOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
