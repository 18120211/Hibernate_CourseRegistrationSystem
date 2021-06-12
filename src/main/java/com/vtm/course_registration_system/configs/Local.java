package com.vtm.course_registration_system.configs;

import com.vtm.course_registration_system.App;
import com.vtm.course_registration_system.enums.UserType;
import com.vtm.course_registration_system.models.SemesterEntity;

import java.io.*;
import java.sql.Date;

public class Local {
    public static int userID;
    public static UserType userType;
    public static Boolean isAuthenticated;
    public static Object user;
    public static SemesterEntity currentSemester;
    public static final String ministryPngURL = "https://res.cloudinary.com/minhvocloudinary/image/upload/v1623439419/hibernate/image/Ministry_ecbpg0.png";
    public static final String subjectPngURL = "https://res.cloudinary.com/minhvocloudinary/image/upload/v1623439419/hibernate/image/Subject_cervhs.png";
    public static final String semesterPngURL = "https://res.cloudinary.com/minhvocloudinary/image/upload/v1623439419/hibernate/image/Semester_omhsf2.png";
    public static final String classPngURL = "https://res.cloudinary.com/minhvocloudinary/image/upload/v1623439418/hibernate/image/Class_slv8p5.png";
    public static final String studentPngURL = "https://res.cloudinary.com/minhvocloudinary/image/upload/v1623439419/hibernate/image/Student_svrm50.png";
    public static final String sessionPngURL = "https://res.cloudinary.com/minhvocloudinary/image/upload/v1623439419/hibernate/image/Session_g6e5z8.png";
    public static final String coursePngURL = "https://res.cloudinary.com/minhvocloudinary/image/upload/v1623439418/hibernate/image/Course_ynodkr.png";
    public static final String listPngURL = "https://res.cloudinary.com/minhvocloudinary/image/upload/v1623439418/hibernate/image/List_n4kn0e.png";
    public static final String hcmusPngURL = "https://res.cloudinary.com/minhvocloudinary/image/upload/v1623440326/hibernate/image/hcmus_vacpa8.png";
    public static final String logoutPngURL = "https://res.cloudinary.com/minhvocloudinary/image/upload/v1623439419/hibernate/image/Logout_wfmwuj.png";

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
