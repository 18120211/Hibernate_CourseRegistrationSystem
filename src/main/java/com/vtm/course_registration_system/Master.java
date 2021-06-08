package com.vtm.course_registration_system;

import com.vtm.course_registration_system.daos.MinistryDao;
import com.vtm.course_registration_system.jframes.Dashboard;
import com.vtm.course_registration_system.models.MinistryEntity;

import java.util.ArrayList;

public class Master {
    private static Master instance;
    private Master(){
        Dashboard.listMinitry = MinistryDao.getDataTable();
    }
    public static Master getInstance() {
        if (Master.instance == null) {
            Master.instance = new Master();
        }
        return Master.instance;
    }

}
