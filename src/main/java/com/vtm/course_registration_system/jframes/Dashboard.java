/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vtm.course_registration_system.jframes;

import com.vtm.course_registration_system.daos.MinistryDao;
import com.vtm.course_registration_system.models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author minht
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    final static int add = 0;
    final static int update = 1;
    final static int delete = 2;
    final static int reset = 3;

    final static int ministry = 0;
    final static int subject = 1;
    final static int semester = 2;
    final static int classs = 3;
    final static int student = 4;
    final static int session = 5;
    final static int course = 6;
    final static int registration = 7;

    public MinistryEntity curMinistry;
    public static Object[][] listMinitry;
    public SubjectEntity curSubject;
    public static Object[][] listSubject;
    public SemesterEntity curSemester;
    public static Object[][] listSemester;
    public ClassEntity curClass;
    public static Object[][] listClass;
    public StudentEntity curStudent;
    public static Object[][] listStudent;
    public static Object[][] listSession;
    public CourseEntity curCourse;
    public static Object[][] listCourse;
    public static Object[][] listRegistration;

    public Dashboard() {
//        setExtendedState(Dashboard.MAXIMIZED_BOTH);
//        setUndecorated(true);
        initComponents();
        moreConfig();
    }

    private void moreConfig() {
        setLocationRelativeTo(null);
        setResizable(false);

        //  Disable edit table
        minTable.setAutoCreateRowSorter(true);
        minTable.setDefaultEditor(Object.class, null);

        // Align center header
        ((DefaultTableCellRenderer) minTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        this.minInforPanel.setVisible(false);
        this.minAddPanel.setVisible(false);
        this.minUpPanel.setVisible(false);
        this.subInforPanel.setVisible(false);
        this.subAddPanel.setVisible(false);
        this.subUpPanel.setVisible(false);
        this.semInforPanel.setVisible(false);
        this.semAddPanel.setVisible(false);
        this.classInforPanel.setVisible(false);
        this.classAddPanel.setVisible(false);
        this.stuInforPanel.setVisible(false);
        this.stuAddPanel.setVisible(false);
        this.stuUpPanel.setVisible(false);
        this.sesInforPanel.setVisible(false);
        this.sesAddPanel.setVisible(false);
        this.couInforPanel.setVisible(false);
        this.couAddPanel.setVisible(false);

        this.subjectContent.setVisible(false);
        this.semesterContent.setVisible(false);
        this.classContent.setVisible(false);
        this.studentContent.setVisible(false);
        this.sessionContent.setVisible(false);
        this.courseContent.setVisible(false);
        this.registrationContent.setVisible(false);

        addAction();
    }

    private void addAction() {
//        Menu click handle
        this.ministryTab.addMouseListener(new MenuClickHandle(ministryTab, ministryContent));
        this.subjectTab.addMouseListener(new MenuClickHandle(subjectTab, subjectContent));
        this.semesterTab.addMouseListener(new MenuClickHandle(semesterTab, semesterContent));
        this.classTab.addMouseListener(new MenuClickHandle(classTab, classContent));
        this.studentTab.addMouseListener(new MenuClickHandle(studentTab, studentContent));
        this.sessionTab.addMouseListener(new MenuClickHandle(sessionTab, sessionContent));
        this.courseTab.addMouseListener(new MenuClickHandle(courseTab, courseContent));
        this.lStudentCourseTab.addMouseListener(new MenuClickHandle(lStudentCourseTab, registrationContent));
        this.logoutTab.addMouseListener(new LogoutListener());

        this.ministryLabel.addMouseListener(new MenuClickHandle(ministryTab, ministryContent));
        this.subjectLabel.addMouseListener(new MenuClickHandle(subjectTab, subjectContent));
        this.semesterLabel.addMouseListener(new MenuClickHandle(semesterTab, semesterContent));
        this.classLabel.addMouseListener(new MenuClickHandle(classTab, classContent));
        this.studentLabel.addMouseListener(new MenuClickHandle(studentTab, studentContent));
        this.sessionLabel.addMouseListener(new MenuClickHandle(sessionTab, sessionContent));
        this.courseLabel.addMouseListener(new MenuClickHandle(courseTab, courseContent));
        this.lStudentCourseLabel.addMouseListener(new MenuClickHandle(lStudentCourseTab, registrationContent));
        this.logoutLabel.addMouseListener(new LogoutListener());

//        Ministry Config
        this.minAddBtn.addMouseListener(new editBtnListener(this.minAddPanel, Dashboard.ministry));
        this.minUpBtn.addMouseListener(new editBtnListener(this.minUpPanel, Dashboard.ministry));
        this.minAddCancelBtn.addMouseListener(new editBtnListener(this.minCancelPanel, Dashboard.ministry));
        this.minUpCancelBtn.addMouseListener(new editBtnListener(this.minCancelPanel, Dashboard.ministry));
        this.minSearchBtn.addMouseListener(new SearchBtnListener(Dashboard.ministry));

        this.minAddConf.addMouseListener(new UpdateDataListener(Dashboard.ministry, Dashboard.add));
        this.minUpConf.addMouseListener(new UpdateDataListener(Dashboard.ministry, Dashboard.update));
        this.minDelConf.addMouseListener(new UpdateDataListener(Dashboard.ministry, Dashboard.delete, "Xác nhận", "Xóa giáo vụ"));
        this.minResetConf.addMouseListener(new UpdateDataListener(Dashboard.ministry, Dashboard.reset, "Xác nhận", "Reset mật khẩu giáo vụ"));

//        Subject config
        this.subAddBtn.addMouseListener(new editBtnListener(this.subAddPanel, Dashboard.subject));
        this.subUpBtn.addMouseListener(new editBtnListener(this.subUpPanel, Dashboard.subject));
        this.subAddCancelBtn.addMouseListener(new editBtnListener(this.subCancelPanel, Dashboard.subject));
        this.subUpCancelBtn.addMouseListener(new editBtnListener(this.subCancelPanel, Dashboard.subject));
        this.subSearchBtn.addMouseListener(new SearchBtnListener(Dashboard.subject));

        this.subAddConf.addMouseListener(new UpdateDataListener(Dashboard.subject, Dashboard.add));
        this.subUpConf.addMouseListener(new UpdateDataListener(Dashboard.subject, Dashboard.update));
        this.subDelConf.addMouseListener(new UpdateDataListener(Dashboard.subject, Dashboard.delete, "Xác nhận", "Xóa môn học"));

//        Semester config
        this.semAddBtn.addMouseListener(new editBtnListener(this.semAddPanel, Dashboard.semester));
        this.semAddCancelBtn.addMouseListener(new editBtnListener(this.semCancelPanel, Dashboard.semester));
        this.semSearchBtn.addMouseListener(new SearchBtnListener(Dashboard.semester));

        this.semAddConf.addMouseListener(new UpdateDataListener(Dashboard.semester, Dashboard.add));
        this.semDelConf.addMouseListener(new UpdateDataListener(Dashboard.semester, Dashboard.delete, "Xác nhận", "Xóa học kỳ"));
        this.semSetConf.addMouseListener(new SetSemester());

//        Class config
        this.classAddBtn.addMouseListener(new editBtnListener(this.classAddPanel, Dashboard.classs));
        this.classAddCancelBtn.addMouseListener(new editBtnListener(this.classCancelPanel, Dashboard.classs));
        this.classSearchBtn.addMouseListener(new SearchBtnListener(Dashboard.classs));

        this.classAddConf.addMouseListener(new UpdateDataListener(Dashboard.classs, Dashboard.add));
        this.classDelConf.addMouseListener(new UpdateDataListener(Dashboard.classs, Dashboard.delete, "Xác nhận", "Xóa lớp học"));

//        Student config
        this.stuAddBtn.addMouseListener(new editBtnListener(this.stuAddPanel, Dashboard.student));
        this.stuUpBtn.addMouseListener(new editBtnListener(this.stuUpPanel, Dashboard.student));
        this.stuAddCancelBtn.addMouseListener(new editBtnListener(this.stuCancelPanel, Dashboard.student));
        this.stuUpCancelBtn.addMouseListener(new editBtnListener(this.stuCancelPanel, Dashboard.student));
        this.stuSearchBtn.addMouseListener(new SearchBtnListener(Dashboard.student));

        this.stuAddConf.addMouseListener(new UpdateDataListener(Dashboard.student, Dashboard.add));
        this.stuUpConf.addMouseListener(new UpdateDataListener(Dashboard.student, Dashboard.update));
        this.stuResetConf.addMouseListener(new UpdateDataListener(Dashboard.student, Dashboard.reset, "Xác nhận", "Reset mật khẩu sinh viên"));

//        session config
        this.sesAddBtn.addMouseListener(new editBtnListener(this.sesAddPanel, Dashboard.session));
        this.sesAddCancelBtn.addMouseListener(new editBtnListener(this.sesCancelPanel, Dashboard.session));
        this.sesSearchBtn.addMouseListener(new SearchBtnListener(Dashboard.session));

        this.sesAddConf.addMouseListener(new UpdateDataListener(Dashboard.session, Dashboard.add));

//        Course config
        this.couAddBtn.addMouseListener(new editBtnListener(this.couAddPanel, Dashboard.course));
        this.couAddCancelBtn.addMouseListener(new editBtnListener(this.couCancelPanel, Dashboard.course));
        this.couSearchBtn.addMouseListener(new SearchBtnListener(Dashboard.course));

        this.couAddConf.addMouseListener(new UpdateDataListener(Dashboard.course, Dashboard.add));
        this.couDelConf.addMouseListener(new UpdateDataListener(Dashboard.course, Dashboard.delete, "Xác nhận", "Xóa học phần"));

//        Registration config
        this.regSearchBtn.addMouseListener(new SearchBtnListener(Dashboard.registration));

    }

    class LogoutListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (JOptionPane.showConfirmDialog(null, "Đăng xuất khỏi tài khoản", "Xác thực", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                Dashboard.this.dispose();
                Login.main(null);
            }

        }
    }

    class SetSemester extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
            JOptionPane.showMessageDialog(null, "Set học kỳ hiện tại thành công");
        }

    }

    void updateData(int entityType, int editType) {
        if (entityType == Dashboard.ministry) {
            if (editType == Dashboard.add) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else if (editType == Dashboard.update) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            } else if (editType == Dashboard.delete) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } else if (editType == Dashboard.reset) {
                JOptionPane.showMessageDialog(null, "Reset thành công");
            }
            Dashboard.listMinitry = MinistryDao.getTableData();
            this.minTable.setModel(new DefaultTableModel(Dashboard.listMinitry,
                    new String[]{
                            "ID", "Họ tên", "Tài khoản", "Mật khẩu"
                    }));
            this.minScrollPane.setViewportView(minTable);
        } else if (entityType == Dashboard.subject) {
            if (editType == Dashboard.add) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else if (editType == Dashboard.update) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            } else if (editType == Dashboard.delete) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
//            Dashboard.listSubject = SubjectDao.
            subTable.setModel(new javax.swing.table.DefaultTableModel(
                    Dashboard.listSubject,
                    new String[]{
                            "ID", "Tên môn", "Mã môn", "Số tin chỉ"
                    }
            ));
            subScrollPane.setViewportView(subTable);
        } else if (entityType == Dashboard.semester) {
            if (editType == Dashboard.add) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else if (editType == Dashboard.delete) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
        } else if (entityType == Dashboard.classs) {
            if (editType == Dashboard.add) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else if (editType == Dashboard.delete) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
        } else if (entityType == Dashboard.student) {
            if (editType == Dashboard.add) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else if (editType == Dashboard.update) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            } else if (editType == Dashboard.reset) {
                JOptionPane.showMessageDialog(null, "Reset thành công");
            }
        } else if (entityType == Dashboard.session) {
            if (editType == Dashboard.add) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            }
        } else if (entityType == Dashboard.course) {
            if (editType == Dashboard.add) {
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } else if (editType == Dashboard.delete) {
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }
        }
    }

    class SearchBtnListener extends MouseAdapter {

        private int entityType;
        private Dashboard dashboard = Dashboard.this;

        public SearchBtnListener(int entityType) {
            this.entityType = entityType;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
            try {
                int id = Integer.parseInt(dashboard.minSearchField.getText());
                if (this.entityType == Dashboard.ministry) {
                    dashboard.minInforPanel.setVisible(true);
                } else if (this.entityType == Dashboard.subject) {
                    dashboard.subInforPanel.setVisible(true);
                } else if (this.entityType == Dashboard.semester) {
                    dashboard.semInforPanel.setVisible(true);
                } else if (this.entityType == Dashboard.classs) {
                    dashboard.classInforPanel.setVisible(true);
                } else if (this.entityType == Dashboard.student) {
                    dashboard.stuInforPanel.setVisible(true);
                } else if (this.entityType == Dashboard.session) {
                    dashboard.sesInforPanel.setVisible(true);
                } else if (this.entityType == Dashboard.course) {
                    dashboard.couInforPanel.setVisible(true);
                } else if (this.entityType == Dashboard.registration) {
                    dashboard.regScrollPane.setVisible(true);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class UpdateDataListener extends MouseAdapter {

        private int entityType;
        private int editType;
        private String message;
        private String title;

        public UpdateDataListener(int entityType, int editType) {
            this.editType = editType;
            this.entityType = entityType;

        }

        public UpdateDataListener(int entityType, int editType, String message, String title) {
            this.editType = editType;
            this.entityType = entityType;
            this.message = message;
            this.title = title;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (message == null) {
                updateData(entityType, editType);
            } else {
                if (JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    updateData(entityType, editType);
                }
            }
        }
    }

    class editBtnListener extends MouseAdapter {

        JPanel panel = new JPanel();
        int entityType;
        Dashboard dashboard = Dashboard.this;

        public editBtnListener(JPanel panel, int entityType) {
            this.panel = panel;
            this.entityType = entityType;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
            if (this.entityType == Dashboard.ministry) {
                dashboard.minAddPanel.setVisible(false);
                dashboard.minUpPanel.setVisible(false);
                dashboard.minCancelPanel.setVisible(false);
            } else if (this.entityType == Dashboard.subject) {
                dashboard.subAddPanel.setVisible(false);
                dashboard.subUpPanel.setVisible(false);
                dashboard.subCancelPanel.setVisible(false);
            } else if (this.entityType == Dashboard.semester) {
                dashboard.semAddPanel.setVisible(false);
                dashboard.semCancelPanel.setVisible(false);
            } else if (this.entityType == Dashboard.classs) {
                dashboard.classAddPanel.setVisible(false);
                dashboard.classCancelPanel.setVisible(false);
            } else if (this.entityType == Dashboard.student) {
                dashboard.stuAddPanel.setVisible(false);
                dashboard.stuUpPanel.setVisible(false);
                dashboard.stuCancelPanel.setVisible(false);
            } else if (this.entityType == Dashboard.session) {
                dashboard.sesAddPanel.setVisible(false);
                dashboard.sesCancelPanel.setVisible(false);
            } else if (this.entityType == Dashboard.course) {
                dashboard.couAddPanel.setVisible(false);
                dashboard.couCancelPanel.setVisible(false);
            }
            this.panel.setVisible(true);
        }
    }

    private class MenuClickHandle extends MouseAdapter {

        Dashboard dashboard = Dashboard.this;
        JPanel selectedTab;
        JPanel selectedContent;

        public MenuClickHandle(JPanel selectedTab, JPanel selectedContent) {
            this.selectedTab = selectedTab;
            this.selectedContent = selectedContent;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
            this.dashboard.ministryTab.setBackground(new Color(204, 204, 204));
            this.dashboard.subjectTab.setBackground(new Color(204, 204, 204));
            this.dashboard.semesterTab.setBackground(new Color(204, 204, 204));
            this.dashboard.classTab.setBackground(new Color(204, 204, 204));
            this.dashboard.studentTab.setBackground(new Color(204, 204, 204));
            this.dashboard.sessionTab.setBackground(new Color(204, 204, 204));
            this.dashboard.courseTab.setBackground(new Color(204, 204, 204));
            this.dashboard.lStudentCourseTab.setBackground(new Color(204, 204, 204));
            this.selectedTab.setBackground(new Color(102, 102, 255));

            this.dashboard.ministryContent.setVisible(false);
            this.dashboard.subjectContent.setVisible(false);
            this.dashboard.semesterContent.setVisible(false);
            this.dashboard.classContent.setVisible(false);
            this.dashboard.studentContent.setVisible(false);
            this.dashboard.sessionContent.setVisible(false);
            this.dashboard.courseContent.setVisible(false);
            this.dashboard.registrationContent.setVisible(false);
            this.selectedContent.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JPanel();
        paneMenu = new javax.swing.JPanel();
        ministryTab = new javax.swing.JPanel();
        ministryLabel = new javax.swing.JLabel();
        ministryIcon = new javax.swing.JLabel();
        subjectTab = new javax.swing.JPanel();
        subjectLabel = new javax.swing.JLabel();
        subjectIcon = new javax.swing.JLabel();
        semesterTab = new javax.swing.JPanel();
        semesterLabel = new javax.swing.JLabel();
        semesterIcon = new javax.swing.JLabel();
        classTab = new javax.swing.JPanel();
        classLabel = new javax.swing.JLabel();
        classIcon = new javax.swing.JLabel();
        studentTab = new javax.swing.JPanel();
        studentLabel = new javax.swing.JLabel();
        studentIcon = new javax.swing.JLabel();
        sessionTab = new javax.swing.JPanel();
        sessionLabel = new javax.swing.JLabel();
        sessionIcon = new javax.swing.JLabel();
        courseTab = new javax.swing.JPanel();
        courseLabel = new javax.swing.JLabel();
        courseIcon = new javax.swing.JLabel();
        lStudentCourseTab = new javax.swing.JPanel();
        lStudentCourseLabel = new javax.swing.JLabel();
        lStudentCourseIcon = new javax.swing.JLabel();
        logoutTab = new javax.swing.JPanel();
        logoutLabel = new javax.swing.JLabel();
        logoutIcon = new javax.swing.JLabel();
        contentPane = new javax.swing.JPanel();
        ministryContent = new javax.swing.JPanel();
        minScrollPane = new javax.swing.JScrollPane();
        minTable = new javax.swing.JTable();
        minInforPanel = new javax.swing.JPanel();
        minInforLabel = new javax.swing.JLabel();
        minNameLabel = new javax.swing.JLabel();
        minName = new javax.swing.JLabel();
        minIdLabel = new javax.swing.JLabel();
        minId = new javax.swing.JLabel();
        minUserLabel = new javax.swing.JLabel();
        minUser = new javax.swing.JLabel();
        minPassLabel = new javax.swing.JLabel();
        minPass = new javax.swing.JLabel();
        minAddBtn = new javax.swing.JButton();
        minResetConf = new javax.swing.JButton();
        minUpBtn = new javax.swing.JButton();
        minDelConf = new javax.swing.JButton();
        minEditPanel = new javax.swing.JPanel();
        minCancelPanel = new javax.swing.JPanel();
        minUpPanel = new javax.swing.JPanel();
        minInforLabel2 = new javax.swing.JLabel();
        minNameLabel2 = new javax.swing.JLabel();
        minUpNameField = new javax.swing.JTextField();
        minPassLabel2 = new javax.swing.JLabel();
        minUpPassField = new javax.swing.JTextField();
        minUpConf = new javax.swing.JButton();
        minUpCancelBtn = new javax.swing.JButton();
        minAddPanel = new javax.swing.JPanel();
        minInforLabel1 = new javax.swing.JLabel();
        minNameLabel1 = new javax.swing.JLabel();
        minUserLabel1 = new javax.swing.JLabel();
        minPassLabel1 = new javax.swing.JLabel();
        minAddNameField = new javax.swing.JTextField();
        minAddUserField = new javax.swing.JTextField();
        minAddPassField = new javax.swing.JTextField();
        minAddConf = new javax.swing.JButton();
        minAddCancelBtn = new javax.swing.JButton();
        minInforLabel3 = new javax.swing.JLabel();
        minSearchField = new javax.swing.JTextField();
        minSearchBtn = new javax.swing.JButton();
        subjectContent = new javax.swing.JPanel();
        subScrollPane = new javax.swing.JScrollPane();
        subTable = new javax.swing.JTable();
        subInforPanel = new javax.swing.JPanel();
        minInforLabel4 = new javax.swing.JLabel();
        minNameLabel3 = new javax.swing.JLabel();
        subName = new javax.swing.JLabel();
        minIdLabel1 = new javax.swing.JLabel();
        subId = new javax.swing.JLabel();
        minUserLabel2 = new javax.swing.JLabel();
        subCode = new javax.swing.JLabel();
        minPassLabel3 = new javax.swing.JLabel();
        subCredit = new javax.swing.JLabel();
        subAddBtn = new javax.swing.JButton();
        subUpBtn = new javax.swing.JButton();
        subDelConf = new javax.swing.JButton();
        subEditPanel = new javax.swing.JPanel();
        subCancelPanel = new javax.swing.JPanel();
        subUpPanel = new javax.swing.JPanel();
        minInforLabel5 = new javax.swing.JLabel();
        minNameLabel4 = new javax.swing.JLabel();
        subUpNameField = new javax.swing.JTextField();
        minPassLabel4 = new javax.swing.JLabel();
        subUpPassField = new javax.swing.JTextField();
        subUpConf = new javax.swing.JButton();
        subUpCancelBtn = new javax.swing.JButton();
        minPassLabel6 = new javax.swing.JLabel();
        subUpCreditField = new javax.swing.JTextField();
        subAddPanel = new javax.swing.JPanel();
        minInforLabel6 = new javax.swing.JLabel();
        minNameLabel5 = new javax.swing.JLabel();
        minUserLabel3 = new javax.swing.JLabel();
        minPassLabel5 = new javax.swing.JLabel();
        subAddNameField = new javax.swing.JTextField();
        subAddCodeField = new javax.swing.JTextField();
        subAddCreditField = new javax.swing.JTextField();
        subAddConf = new javax.swing.JButton();
        subAddCancelBtn = new javax.swing.JButton();
        minInforLabel7 = new javax.swing.JLabel();
        subSearchField = new javax.swing.JTextField();
        subSearchBtn = new javax.swing.JButton();
        semesterContent = new javax.swing.JPanel();
        semScrollPane = new javax.swing.JScrollPane();
        semTable = new javax.swing.JTable();
        semInforPanel = new javax.swing.JPanel();
        minInforLabel8 = new javax.swing.JLabel();
        minNameLabel6 = new javax.swing.JLabel();
        minName1 = new javax.swing.JLabel();
        minIdLabel2 = new javax.swing.JLabel();
        minId1 = new javax.swing.JLabel();
        minUserLabel4 = new javax.swing.JLabel();
        minUser1 = new javax.swing.JLabel();
        minPassLabel7 = new javax.swing.JLabel();
        minPass1 = new javax.swing.JLabel();
        semAddBtn = new javax.swing.JButton();
        semDelConf = new javax.swing.JButton();
        semSetConf = new javax.swing.JButton();
        semEditPanel = new javax.swing.JPanel();
        semCancelPanel = new javax.swing.JPanel();
        semAddPanel = new javax.swing.JPanel();
        minInforLabel10 = new javax.swing.JLabel();
        minNameLabel8 = new javax.swing.JLabel();
        minUserLabel5 = new javax.swing.JLabel();
        minPassLabel9 = new javax.swing.JLabel();
        semAddNameField = new javax.swing.JTextField();
        semAddYearField = new javax.swing.JTextField();
        semAddStartField = new javax.swing.JTextField();
        semAddConf = new javax.swing.JButton();
        semAddCancelBtn = new javax.swing.JButton();
        minPassLabel10 = new javax.swing.JLabel();
        semAddEndField = new javax.swing.JTextField();
        minInforLabel11 = new javax.swing.JLabel();
        semSearchField = new javax.swing.JTextField();
        semSearchBtn = new javax.swing.JButton();
        classContent = new javax.swing.JPanel();
        classScrollPane = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();
        classInforPanel = new javax.swing.JPanel();
        minInforLabel9 = new javax.swing.JLabel();
        minNameLabel7 = new javax.swing.JLabel();
        className = new javax.swing.JLabel();
        minIdLabel3 = new javax.swing.JLabel();
        classId = new javax.swing.JLabel();
        minUserLabel6 = new javax.swing.JLabel();
        classNummale = new javax.swing.JLabel();
        minPassLabel8 = new javax.swing.JLabel();
        classNumfemale = new javax.swing.JLabel();
        classAddBtn = new javax.swing.JButton();
        classDelConf = new javax.swing.JButton();
        classEditPanel = new javax.swing.JPanel();
        classCancelPanel = new javax.swing.JPanel();
        classAddPanel = new javax.swing.JPanel();
        minInforLabel12 = new javax.swing.JLabel();
        minNameLabel9 = new javax.swing.JLabel();
        classAddNameField = new javax.swing.JTextField();
        classAddConf = new javax.swing.JButton();
        classAddCancelBtn = new javax.swing.JButton();
        minInforLabel13 = new javax.swing.JLabel();
        classSearchField = new javax.swing.JTextField();
        classSearchBtn = new javax.swing.JButton();
        studentContent = new javax.swing.JPanel();
        stuScrollPane = new javax.swing.JScrollPane();
        stuTable = new javax.swing.JTable();
        stuInforPanel = new javax.swing.JPanel();
        minInforLabel14 = new javax.swing.JLabel();
        minNameLabel10 = new javax.swing.JLabel();
        stuName = new javax.swing.JLabel();
        minUserLabel7 = new javax.swing.JLabel();
        stuMssv = new javax.swing.JLabel();
        minPassLabel11 = new javax.swing.JLabel();
        stuSex = new javax.swing.JLabel();
        stuAddBtn = new javax.swing.JButton();
        stuResetConf = new javax.swing.JButton();
        stuUpBtn = new javax.swing.JButton();
        minPassLabel14 = new javax.swing.JLabel();
        stuBirth = new javax.swing.JLabel();
        minPassLabel15 = new javax.swing.JLabel();
        stuNumsubject = new javax.swing.JLabel();
        minPassLabel16 = new javax.swing.JLabel();
        stuClass = new javax.swing.JLabel();
        stuEditPanel = new javax.swing.JPanel();
        stuCancelPanel = new javax.swing.JPanel();
        stuUpPanel = new javax.swing.JPanel();
        minInforLabel15 = new javax.swing.JLabel();
        minNameLabel11 = new javax.swing.JLabel();
        stuUpNameField = new javax.swing.JTextField();
        minPassLabel12 = new javax.swing.JLabel();
        stuUpCodeField = new javax.swing.JTextField();
        stuUpConf = new javax.swing.JButton();
        stuUpCancelBtn = new javax.swing.JButton();
        minPassLabel17 = new javax.swing.JLabel();
        stuUpSexField = new javax.swing.JTextField();
        minPassLabel18 = new javax.swing.JLabel();
        stuUpBirthField = new javax.swing.JTextField();
        minPassLabel19 = new javax.swing.JLabel();
        stuUpClassField = new javax.swing.JTextField();
        stuAddPanel = new javax.swing.JPanel();
        minInforLabel16 = new javax.swing.JLabel();
        minNameLabel12 = new javax.swing.JLabel();
        minUserLabel8 = new javax.swing.JLabel();
        minPassLabel13 = new javax.swing.JLabel();
        stuAddNameField = new javax.swing.JTextField();
        stuAddUserField = new javax.swing.JTextField();
        stuAddPassField = new javax.swing.JTextField();
        stuAddConf = new javax.swing.JButton();
        stuAddCancelBtn = new javax.swing.JButton();
        minPassLabel20 = new javax.swing.JLabel();
        stuUpCodeField1 = new javax.swing.JTextField();
        minPassLabel21 = new javax.swing.JLabel();
        stuAddSexField = new javax.swing.JTextField();
        minPassLabel22 = new javax.swing.JLabel();
        stuAddBirthField = new javax.swing.JTextField();
        minPassLabel23 = new javax.swing.JLabel();
        stuAddClassField = new javax.swing.JTextField();
        minInforLabel17 = new javax.swing.JLabel();
        stuSearchField = new javax.swing.JTextField();
        stuSearchBtn = new javax.swing.JButton();
        sessionContent = new javax.swing.JPanel();
        sesScrollPane = new javax.swing.JScrollPane();
        sesTable = new javax.swing.JTable();
        sesInforPanel = new javax.swing.JPanel();
        minInforLabel18 = new javax.swing.JLabel();
        minNameLabel13 = new javax.swing.JLabel();
        sesId = new javax.swing.JLabel();
        minIdLabel4 = new javax.swing.JLabel();
        sesStart = new javax.swing.JLabel();
        minUserLabel9 = new javax.swing.JLabel();
        sesEnd = new javax.swing.JLabel();
        minPassLabel24 = new javax.swing.JLabel();
        sesSemester = new javax.swing.JLabel();
        sesAddBtn = new javax.swing.JButton();
        sesEditPanel = new javax.swing.JPanel();
        sesCancelPanel = new javax.swing.JPanel();
        sesAddPanel = new javax.swing.JPanel();
        minInforLabel19 = new javax.swing.JLabel();
        minNameLabel14 = new javax.swing.JLabel();
        sesAddNameField = new javax.swing.JTextField();
        sesAddConf = new javax.swing.JButton();
        sesAddCancelBtn = new javax.swing.JButton();
        minNameLabel15 = new javax.swing.JLabel();
        sesAddStartField = new javax.swing.JTextField();
        minNameLabel16 = new javax.swing.JLabel();
        sesAddEndField = new javax.swing.JTextField();
        minInforLabel20 = new javax.swing.JLabel();
        sesSearchField = new javax.swing.JTextField();
        sesSearchBtn = new javax.swing.JButton();
        courseContent = new javax.swing.JPanel();
        couScrollPane = new javax.swing.JScrollPane();
        couTable = new javax.swing.JTable();
        couInforPanel = new javax.swing.JPanel();
        minInforLabel21 = new javax.swing.JLabel();
        minIdLabel5 = new javax.swing.JLabel();
        couId = new javax.swing.JLabel();
        minUserLabel10 = new javax.swing.JLabel();
        couName = new javax.swing.JLabel();
        minPassLabel25 = new javax.swing.JLabel();
        couYear = new javax.swing.JLabel();
        couAddBtn = new javax.swing.JButton();
        couDelConf = new javax.swing.JButton();
        minPassLabel26 = new javax.swing.JLabel();
        couTeacher = new javax.swing.JLabel();
        minPassLabel27 = new javax.swing.JLabel();
        couRoom = new javax.swing.JLabel();
        minPassLabel28 = new javax.swing.JLabel();
        couDay = new javax.swing.JLabel();
        minPassLabel29 = new javax.swing.JLabel();
        couShift = new javax.swing.JLabel();
        minPassLabel30 = new javax.swing.JLabel();
        couIdsubject = new javax.swing.JLabel();
        minPassLabel31 = new javax.swing.JLabel();
        couIdministry = new javax.swing.JLabel();
        couEditPanel = new javax.swing.JPanel();
        couCancelPanel = new javax.swing.JPanel();
        couAddPanel = new javax.swing.JPanel();
        minInforLabel22 = new javax.swing.JLabel();
        minNameLabel18 = new javax.swing.JLabel();
        couAddNameField = new javax.swing.JTextField();
        couAddConf = new javax.swing.JButton();
        couAddCancelBtn = new javax.swing.JButton();
        minNameLabel19 = new javax.swing.JLabel();
        couAddYearField = new javax.swing.JTextField();
        minNameLabel20 = new javax.swing.JLabel();
        couAddTeacherField = new javax.swing.JTextField();
        minNameLabel21 = new javax.swing.JLabel();
        couAddRoomField = new javax.swing.JTextField();
        minNameLabel22 = new javax.swing.JLabel();
        couAddDayField = new javax.swing.JTextField();
        minNameLabel23 = new javax.swing.JLabel();
        couAddShiftField = new javax.swing.JTextField();
        minNameLabel24 = new javax.swing.JLabel();
        couAddIdsubjectField = new javax.swing.JTextField();
        minNameLabel25 = new javax.swing.JLabel();
        couAddIdsessionField = new javax.swing.JTextField();
        minInforLabel23 = new javax.swing.JLabel();
        couSearchField = new javax.swing.JTextField();
        couSearchBtn = new javax.swing.JButton();
        registrationContent = new javax.swing.JPanel();
        minInforLabel26 = new javax.swing.JLabel();
        regSearchField = new javax.swing.JTextField();
        regSearchBtn = new javax.swing.JButton();
        regCourseScrollPane = new javax.swing.JScrollPane();
        regCourseTable = new javax.swing.JTable();
        regScrollPane = new javax.swing.JScrollPane();
        regTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MainFrame");

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        mainPane.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N

        paneMenu.setBackground(new java.awt.Color(0, 102, 102));
        paneMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paneMenu.setToolTipText("");
        paneMenu.setPreferredSize(new java.awt.Dimension(240, 455));

        ministryTab.setBackground(new java.awt.Color(102, 102, 255));
        ministryTab.setPreferredSize(new java.awt.Dimension(100, 45));

        ministryLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        ministryLabel.setText("Giáo vụ");
        ministryLabel.setToolTipText("");

        ministryIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\Ministry.png")); // NOI18N

        javax.swing.GroupLayout ministryTabLayout = new javax.swing.GroupLayout(ministryTab);
        ministryTab.setLayout(ministryTabLayout);
        ministryTabLayout.setHorizontalGroup(
                ministryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ministryTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ministryIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(ministryLabel))
        );
        ministryTabLayout.setVerticalGroup(
                ministryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ministryTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(ministryLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(ministryIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        subjectTab.setBackground(new java.awt.Color(204, 204, 204));
        subjectTab.setPreferredSize(new java.awt.Dimension(100, 45));

        subjectLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        subjectLabel.setText("Môn học");
        subjectLabel.setToolTipText("");

        subjectIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\Subject.png")); // NOI18N

        javax.swing.GroupLayout subjectTabLayout = new javax.swing.GroupLayout(subjectTab);
        subjectTab.setLayout(subjectTabLayout);
        subjectTabLayout.setHorizontalGroup(
                subjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectTabLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(subjectIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(subjectLabel))
        );
        subjectTabLayout.setVerticalGroup(
                subjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(subjectLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(subjectIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        semesterTab.setBackground(new java.awt.Color(204, 204, 204));
        semesterTab.setPreferredSize(new java.awt.Dimension(100, 45));

        semesterLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        semesterLabel.setText("Học kỳ");
        semesterLabel.setToolTipText("");

        semesterIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\Semester.png")); // NOI18N

        javax.swing.GroupLayout semesterTabLayout = new javax.swing.GroupLayout(semesterTab);
        semesterTab.setLayout(semesterTabLayout);
        semesterTabLayout.setHorizontalGroup(
                semesterTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(semesterTabLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(semesterIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(semesterLabel))
        );
        semesterTabLayout.setVerticalGroup(
                semesterTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(semesterTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(semesterLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(semesterIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        classTab.setBackground(new java.awt.Color(204, 204, 204));
        classTab.setPreferredSize(new java.awt.Dimension(100, 45));

        classLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        classLabel.setText("Lớp học");
        classLabel.setToolTipText("");

        classIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\Class.png")); // NOI18N

        javax.swing.GroupLayout classTabLayout = new javax.swing.GroupLayout(classTab);
        classTab.setLayout(classTabLayout);
        classTabLayout.setHorizontalGroup(
                classTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(classTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(classIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(classLabel))
        );
        classTabLayout.setVerticalGroup(
                classTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(classTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(classLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(classIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        studentTab.setBackground(new java.awt.Color(204, 204, 204));
        studentTab.setPreferredSize(new java.awt.Dimension(100, 45));

        studentLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        studentLabel.setText("Học sinh");
        studentLabel.setToolTipText("");

        studentIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\Student.png")); // NOI18N

        javax.swing.GroupLayout studentTabLayout = new javax.swing.GroupLayout(studentTab);
        studentTab.setLayout(studentTabLayout);
        studentTabLayout.setHorizontalGroup(
                studentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(studentTabLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(studentIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(studentLabel))
        );
        studentTabLayout.setVerticalGroup(
                studentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(studentTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(studentLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(studentIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sessionTab.setBackground(new java.awt.Color(204, 204, 204));
        sessionTab.setPreferredSize(new java.awt.Dimension(100, 45));

        sessionLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        sessionLabel.setText("Kỳ học phần");
        sessionLabel.setToolTipText("");

        sessionIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\Session.png")); // NOI18N

        javax.swing.GroupLayout sessionTabLayout = new javax.swing.GroupLayout(sessionTab);
        sessionTab.setLayout(sessionTabLayout);
        sessionTabLayout.setHorizontalGroup(
                sessionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sessionTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sessionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(sessionLabel))
        );
        sessionTabLayout.setVerticalGroup(
                sessionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sessionTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(sessionLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(sessionIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        courseTab.setBackground(new java.awt.Color(204, 204, 204));
        courseTab.setPreferredSize(new java.awt.Dimension(100, 45));

        courseLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        courseLabel.setText("Học phần");
        courseLabel.setToolTipText("");

        courseIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\Course.png")); // NOI18N

        javax.swing.GroupLayout courseTabLayout = new javax.swing.GroupLayout(courseTab);
        courseTab.setLayout(courseTabLayout);
        courseTabLayout.setHorizontalGroup(
                courseTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(courseTabLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(courseIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(courseLabel))
        );
        courseTabLayout.setVerticalGroup(
                courseTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(courseTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(courseLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(courseIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lStudentCourseTab.setBackground(new java.awt.Color(204, 204, 204));
        lStudentCourseTab.setPreferredSize(new java.awt.Dimension(100, 45));

        lStudentCourseLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lStudentCourseLabel.setText("Danh sách");
        lStudentCourseLabel.setToolTipText("");

        lStudentCourseIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\List.png")); // NOI18N

        javax.swing.GroupLayout lStudentCourseTabLayout = new javax.swing.GroupLayout(lStudentCourseTab);
        lStudentCourseTab.setLayout(lStudentCourseTabLayout);
        lStudentCourseTabLayout.setHorizontalGroup(
                lStudentCourseTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lStudentCourseTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lStudentCourseIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(lStudentCourseLabel))
        );
        lStudentCourseTabLayout.setVerticalGroup(
                lStudentCourseTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lStudentCourseTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lStudentCourseLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(lStudentCourseIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        logoutTab.setBackground(new java.awt.Color(204, 204, 204));
        logoutTab.setPreferredSize(new java.awt.Dimension(100, 45));

        logoutLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        logoutLabel.setText("Đăng xuất");
        logoutLabel.setToolTipText("");

        logoutIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\Logout.png")); // NOI18N

        javax.swing.GroupLayout logoutTabLayout = new javax.swing.GroupLayout(logoutTab);
        logoutTab.setLayout(logoutTabLayout);
        logoutTabLayout.setHorizontalGroup(
                logoutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(logoutTabLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(logoutIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logoutLabel))
        );
        logoutTabLayout.setVerticalGroup(
                logoutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(logoutTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(logoutLabel)
                                .addGap(20, 20, 20))
                        .addComponent(logoutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paneMenuLayout = new javax.swing.GroupLayout(paneMenu);
        paneMenu.setLayout(paneMenuLayout);
        paneMenuLayout.setHorizontalGroup(
                paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ministryTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(subjectTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(semesterTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(classTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(studentTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(sessionTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(courseTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(lStudentCourseTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(logoutTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        paneMenuLayout.setVerticalGroup(
                paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMenuLayout.createSequentialGroup()
                                .addContainerGap(183, Short.MAX_VALUE)
                                .addComponent(ministryTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subjectTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semesterTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(classTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sessionTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lStudentCourseTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPane.setLayout(new javax.swing.OverlayLayout(contentPane));

        ministryContent.setBackground(new java.awt.Color(255, 255, 255));
        ministryContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        minTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {2, "Võ Thế Hùng", "ministry2", "ministry2"},
                        {2, 2, 3, 4},
                        {3, 2, 3, 4},
                        {6, 2, 3, 4},
                        {1, 2, 3, 4},
                },
                new String[]{
                        "ID", "Họ tên", "Tài khoản", "Mật khẩu"
                }
        ));
        minScrollPane.setViewportView(minTable);

        minInforPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        minInforLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel.setText("Thông tin giáo vụ");

        minNameLabel.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel.setText("Họ tên:");

        minName.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minName.setText("ten");

        minIdLabel.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minIdLabel.setText("ID: ");

        minId.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minId.setText("id");

        minUserLabel.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel.setText("Tài khoản:");

        minUser.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUser.setText("taikhoan");

        minPassLabel.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel.setText("Mật khẩu:");

        minPass.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPass.setText("matkhau");

        minAddBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minAddBtn.setText("Thêm giáo vụ");

        minResetConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minResetConf.setText("Reset mật khẩu");

        minUpBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minUpBtn.setText("Cập nhật");

        minDelConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minDelConf.setText("Xóa giáo vụ");

        javax.swing.GroupLayout minInforPanelLayout = new javax.swing.GroupLayout(minInforPanel);
        minInforPanel.setLayout(minInforPanelLayout);
        minInforPanelLayout.setHorizontalGroup(
                minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minInforPanelLayout.createSequentialGroup()
                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(minInforPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(minInforPanelLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(minInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(minPass, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                                        .addGroup(minInforPanelLayout.createSequentialGroup()
                                                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(minNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(minName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(minId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(minUser, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))))
                                        .addGroup(minInforPanelLayout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, minInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(minUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, minInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minResetConf)
                                                                .addGap(28, 28, 28)
                                                                .addComponent(minDelConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        minInforPanelLayout.setVerticalGroup(
                minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minInforPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minUser))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel)
                                        .addComponent(minPass))
                                .addGap(33, 33, 33)
                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minUpBtn)
                                        .addComponent(minAddBtn))
                                .addGap(18, 18, 18)
                                .addGroup(minInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minResetConf)
                                        .addComponent(minDelConf))
                                .addContainerGap(62, Short.MAX_VALUE))
        );

        minEditPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        minEditPanel.setLayout(new javax.swing.OverlayLayout(minEditPanel));

        javax.swing.GroupLayout minCancelPanelLayout = new javax.swing.GroupLayout(minCancelPanel);
        minCancelPanel.setLayout(minCancelPanelLayout);
        minCancelPanelLayout.setHorizontalGroup(
                minCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 413, Short.MAX_VALUE)
        );
        minCancelPanelLayout.setVerticalGroup(
                minCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );

        minEditPanel.add(minCancelPanel);

        minInforLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel2.setText("Cập nhật giáo vụ");

        minNameLabel2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel2.setText("Họ tên:");

        minUpNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minUpNameField.setText("Võ Thế Hùng");

        minPassLabel2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel2.setText("Mật khẩu:");

        minUpPassField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minUpPassField.setText("ministry2");

        minUpConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minUpConf.setText("Xác nhận");

        minUpCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minUpCancelBtn.setText("Hủy");

        javax.swing.GroupLayout minUpPanelLayout = new javax.swing.GroupLayout(minUpPanel);
        minUpPanel.setLayout(minUpPanelLayout);
        minUpPanelLayout.setHorizontalGroup(
                minUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minUpPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(minUpPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(minUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(minUpPanelLayout.createSequentialGroup()
                                                .addGroup(minUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(minPassLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(minUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(minUpNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                                        .addComponent(minUpPassField)))
                                        .addGroup(minUpPanelLayout.createSequentialGroup()
                                                .addComponent(minUpConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(minUpCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(104, Short.MAX_VALUE))
        );
        minUpPanelLayout.setVerticalGroup(
                minUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minUpPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minUpNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel2)
                                        .addComponent(minUpPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(minUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minUpConf)
                                        .addComponent(minUpCancelBtn))
                                .addGap(0, 260, Short.MAX_VALUE))
        );

        minEditPanel.add(minUpPanel);

        minInforLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel1.setText("Thêm tài khoản giáo vụ");

        minNameLabel1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel1.setText("Họ tên:");

        minUserLabel1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel1.setText("Tài khoản:");

        minPassLabel1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel1.setText("Mật khẩu:");

        minAddNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        minAddUserField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minAddUserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minAddUserFieldActionPerformed(evt);
            }
        });

        minAddPassField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        minAddConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minAddConf.setText("Xác nhận");

        minAddCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minAddCancelBtn.setText("Hủy");

        javax.swing.GroupLayout minAddPanelLayout = new javax.swing.GroupLayout(minAddPanel);
        minAddPanel.setLayout(minAddPanelLayout);
        minAddPanelLayout.setHorizontalGroup(
                minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minAddPanelLayout.createSequentialGroup()
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(minAddPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(minAddPanelLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(minAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minAddConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(minAddCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, minAddPanelLayout.createSequentialGroup()
                                                                        .addComponent(minPassLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(minAddPassField))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, minAddPanelLayout.createSequentialGroup()
                                                                        .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(minNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(minUserLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(minAddNameField)
                                                                                .addComponent(minAddUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(81, Short.MAX_VALUE))
        );
        minAddPanelLayout.setVerticalGroup(
                minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minAddPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(minAddUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minUserLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel1)
                                        .addComponent(minAddPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minAddConf)
                                        .addComponent(minAddCancelBtn))
                                .addGap(0, 238, Short.MAX_VALUE))
        );

        minEditPanel.add(minAddPanel);

        minInforLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel3.setText("Tìm giáo vụ");

        minSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minSearchField.setText("ID");

        minSearchBtn.setText("Search");

        javax.swing.GroupLayout ministryContentLayout = new javax.swing.GroupLayout(ministryContent);
        ministryContent.setLayout(ministryContentLayout);
        ministryContentLayout.setHorizontalGroup(
                ministryContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ministryContentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(ministryContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(ministryContentLayout.createSequentialGroup()
                                                .addGroup(ministryContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(minInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minInforLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(ministryContentLayout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(minSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(minSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(minEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(minScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
        );
        ministryContentLayout.setVerticalGroup(
                ministryContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ministryContentLayout.createSequentialGroup()
                                .addComponent(minScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(ministryContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ministryContentLayout.createSequentialGroup()
                                                .addComponent(minInforLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(ministryContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(minSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minSearchBtn))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(minInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(minEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        contentPane.add(ministryContent);

        subjectContent.setBackground(new java.awt.Color(255, 255, 255));
        subjectContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        subTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {2, "Võ Thế Hùng", "ministry2", "ministry2"},
                        {2, 2, 3, 4},
                        {3, 2, 3, 4},
                        {6, 2, 3, 4},
                        {1, 2, 3, 4},
                },
                new String[]{
                        "ID", "Tên môn", "Mã môn", "Số tin chỉ"
                }
        ));
        subScrollPane.setViewportView(subTable);

        subInforPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        minInforLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel4.setText("Thông tin môn học");

        minNameLabel3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel3.setText("Tên môn:");

        subName.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        subName.setText("ten");

        minIdLabel1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minIdLabel1.setText("ID:");

        subId.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        subId.setText("id");

        minUserLabel2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel2.setText("Mã môn:");

        subCode.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        subCode.setText("mamon");

        minPassLabel3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel3.setText("Số tin chỉ");

        subCredit.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        subCredit.setText("sotinchi");

        subAddBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subAddBtn.setText("Thêm môn học");

        subUpBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subUpBtn.setText("Cập nhật");

        subDelConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subDelConf.setText("Xóa môn học");

        javax.swing.GroupLayout subInforPanelLayout = new javax.swing.GroupLayout(subInforPanel);
        subInforPanel.setLayout(subInforPanelLayout);
        subInforPanelLayout.setHorizontalGroup(
                subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subInforPanelLayout.createSequentialGroup()
                                .addGroup(subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(subInforPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(subInforPanelLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(subInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(subCredit, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                                        .addGroup(subInforPanelLayout.createSequentialGroup()
                                                                .addGroup(subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(minIdLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minUserLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minNameLabel3))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(subName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(subId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(subCode, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))))
                                        .addGroup(subInforPanelLayout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(subDelConf, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(subInforPanelLayout.createSequentialGroup()
                                                                .addComponent(subAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(28, 28, 28)
                                                                .addComponent(subUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(79, Short.MAX_VALUE))
        );
        subInforPanelLayout.setVerticalGroup(
                subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subInforPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minIdLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minUserLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subCode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel3)
                                        .addComponent(subCredit))
                                .addGap(33, 33, 33)
                                .addGroup(subInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(subUpBtn)
                                        .addComponent(subAddBtn))
                                .addGap(18, 18, 18)
                                .addComponent(subDelConf)
                                .addContainerGap(62, Short.MAX_VALUE))
        );

        subEditPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        subEditPanel.setLayout(new javax.swing.OverlayLayout(subEditPanel));

        javax.swing.GroupLayout subCancelPanelLayout = new javax.swing.GroupLayout(subCancelPanel);
        subCancelPanel.setLayout(subCancelPanelLayout);
        subCancelPanelLayout.setHorizontalGroup(
                subCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 413, Short.MAX_VALUE)
        );
        subCancelPanelLayout.setVerticalGroup(
                subCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );

        subEditPanel.add(subCancelPanel);

        minInforLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel5.setText("Cập nhật môn học");

        minNameLabel4.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel4.setText("Tên môn:");

        subUpNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        subUpNameField.setText("Võ Thế Hùng");

        minPassLabel4.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel4.setText("Mã môn");

        subUpPassField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        subUpPassField.setText("ministry2");

        subUpConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subUpConf.setText("Xác nhận");

        subUpCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subUpCancelBtn.setText("Hủy");

        minPassLabel6.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel6.setText("Số tín chỉ");

        subUpCreditField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        subUpCreditField.setText("ministry2");
        subUpCreditField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subUpCreditFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subUpPanelLayout = new javax.swing.GroupLayout(subUpPanel);
        subUpPanel.setLayout(subUpPanelLayout);
        subUpPanelLayout.setHorizontalGroup(
                subUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subUpPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(subUpPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(subUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(subUpPanelLayout.createSequentialGroup()
                                                .addComponent(minPassLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(subUpCreditField))
                                        .addGroup(subUpPanelLayout.createSequentialGroup()
                                                .addGroup(subUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(minPassLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minNameLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(subUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(subUpNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                                        .addComponent(subUpPassField)))
                                        .addGroup(subUpPanelLayout.createSequentialGroup()
                                                .addComponent(subUpConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(subUpCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(104, Short.MAX_VALUE))
        );
        subUpPanelLayout.setVerticalGroup(
                subUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subUpPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(subUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subUpNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(subUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel4)
                                        .addComponent(subUpPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(subUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel6)
                                        .addComponent(subUpCreditField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(subUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(subUpConf)
                                        .addComponent(subUpCancelBtn))
                                .addGap(0, 229, Short.MAX_VALUE))
        );

        subEditPanel.add(subUpPanel);

        minInforLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel6.setText("Thêm môn học");

        minNameLabel5.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel5.setText("Tên môn:");

        minUserLabel3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel3.setText("Mã môn:");

        minPassLabel5.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel5.setText("Số tín chỉ:");

        subAddNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        subAddCodeField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        subAddCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subAddCodeFieldActionPerformed(evt);
            }
        });

        subAddCreditField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        subAddConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subAddConf.setText("Xác nhận");

        subAddCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subAddCancelBtn.setText("Hủy");

        javax.swing.GroupLayout subAddPanelLayout = new javax.swing.GroupLayout(subAddPanel);
        subAddPanel.setLayout(subAddPanelLayout);
        subAddPanelLayout.setHorizontalGroup(
                subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subAddPanelLayout.createSequentialGroup()
                                .addGroup(subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(subAddPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(subAddPanelLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(subAddPanelLayout.createSequentialGroup()
                                                                .addComponent(subAddConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(subAddCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, subAddPanelLayout.createSequentialGroup()
                                                                        .addComponent(minPassLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(subAddCreditField))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, subAddPanelLayout.createSequentialGroup()
                                                                        .addGroup(subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(minNameLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(minUserLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(subAddNameField)
                                                                                .addComponent(subAddCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(81, Short.MAX_VALUE))
        );
        subAddPanelLayout.setVerticalGroup(
                subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subAddPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(subAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(subAddCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minUserLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel5)
                                        .addComponent(subAddCreditField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(subAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(subAddConf)
                                        .addComponent(subAddCancelBtn))
                                .addGap(0, 238, Short.MAX_VALUE))
        );

        subEditPanel.add(subAddPanel);

        minInforLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel7.setText("Tìm môn học");

        subSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        subSearchField.setText("ID");

        subSearchBtn.setText("Search");

        javax.swing.GroupLayout subjectContentLayout = new javax.swing.GroupLayout(subjectContent);
        subjectContent.setLayout(subjectContentLayout);
        subjectContentLayout.setHorizontalGroup(
                subjectContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subjectContentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(subjectContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(subjectContentLayout.createSequentialGroup()
                                                .addGroup(subjectContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(subInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minInforLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(subjectContentLayout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(subSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(subSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(subEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(subScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
        );
        subjectContentLayout.setVerticalGroup(
                subjectContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(subjectContentLayout.createSequentialGroup()
                                .addComponent(subScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(subjectContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(subjectContentLayout.createSequentialGroup()
                                                .addComponent(minInforLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(subjectContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(subSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(subSearchBtn))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(subInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(subEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        contentPane.add(subjectContent);

        semesterContent.setBackground(new java.awt.Color(255, 255, 255));
        semesterContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        semTable.setModel(new javax.swing.table.DefaultTableModel(
                Dashboard.listSemester,
                new String[]{
                        "ID", "Tên học kỳ", "Năm học", "Ngày bắt đầu", "Ngày kết thúc"
                }
        ));
        semScrollPane.setViewportView(semTable);

        semInforPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        minInforLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel8.setText("Thông tin học kỳ");

        minNameLabel6.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel6.setText("Tên học kỳ:");

        minName1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minName1.setText("hk");

        minIdLabel2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minIdLabel2.setText("Năm học:");

        minId1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minId1.setText("200");

        minUserLabel4.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel4.setText("Ngày bắt đầu:");

        minUser1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUser1.setText("2021-10-1");

        minPassLabel7.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel7.setText("Ngày kết thúc:");

        minPass1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPass1.setText("2021-1-1");

        semAddBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        semAddBtn.setText("Thêm học kỳ");

        semDelConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        semDelConf.setText("Xóa học kỳ");

        semSetConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        semSetConf.setText("Chọn làm học kỳ hiện tại");

        javax.swing.GroupLayout semInforPanelLayout = new javax.swing.GroupLayout(semInforPanel);
        semInforPanel.setLayout(semInforPanelLayout);
        semInforPanelLayout.setHorizontalGroup(
                semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(semInforPanelLayout.createSequentialGroup()
                                .addGroup(semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(semInforPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, semInforPanelLayout.createSequentialGroup()
                                                        .addGap(42, 42, 42)
                                                        .addGroup(semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(minPassLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(minUserLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(minNameLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(minIdLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(minPass1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                                .addComponent(minName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(minId1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(minUser1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, semInforPanelLayout.createSequentialGroup()
                                                        .addGap(33, 33, 33)
                                                        .addGroup(semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(semSetConf, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(semInforPanelLayout.createSequentialGroup()
                                                                        .addComponent(semAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(28, 28, 28)
                                                                        .addComponent(semDelConf, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        semInforPanelLayout.setVerticalGroup(
                semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(semInforPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minName1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minIdLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minId1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minUserLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minUser1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel7)
                                        .addComponent(minPass1))
                                .addGap(33, 33, 33)
                                .addGroup(semInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(semAddBtn)
                                        .addComponent(semDelConf))
                                .addGap(18, 18, 18)
                                .addComponent(semSetConf)
                                .addContainerGap(62, Short.MAX_VALUE))
        );

        semEditPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        semEditPanel.setLayout(new javax.swing.OverlayLayout(semEditPanel));

        javax.swing.GroupLayout semCancelPanelLayout = new javax.swing.GroupLayout(semCancelPanel);
        semCancelPanel.setLayout(semCancelPanelLayout);
        semCancelPanelLayout.setHorizontalGroup(
                semCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 441, Short.MAX_VALUE)
        );
        semCancelPanelLayout.setVerticalGroup(
                semCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );

        semEditPanel.add(semCancelPanel);

        minInforLabel10.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel10.setText("Thêm học kỳ");

        minNameLabel8.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel8.setText("Tên học kỳ:");

        minUserLabel5.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel5.setText("Năm học:");

        minPassLabel9.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel9.setText("Ngày bắt đầu: ");

        semAddNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        semAddYearField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        semAddYearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semAddYearFieldActionPerformed(evt);
            }
        });

        semAddStartField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        semAddConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        semAddConf.setText("Xác nhận");

        semAddCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        semAddCancelBtn.setText("Hủy");

        minPassLabel10.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel10.setText("Ngày kết thúc:");

        semAddEndField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        javax.swing.GroupLayout semAddPanelLayout = new javax.swing.GroupLayout(semAddPanel);
        semAddPanel.setLayout(semAddPanelLayout);
        semAddPanelLayout.setHorizontalGroup(
                semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(semAddPanelLayout.createSequentialGroup()
                                .addGroup(semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(semAddPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(semAddPanelLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(semAddPanelLayout.createSequentialGroup()
                                                                .addComponent(semAddConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(semAddCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(semAddPanelLayout.createSequentialGroup()
                                                                .addGroup(semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(minUserLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minNameLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel10))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                                                .addGroup(semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(semAddEndField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(semAddStartField, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(semAddNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(semAddYearField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(42, 42, 42))
        );
        semAddPanelLayout.setVerticalGroup(
                semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(semAddPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(semAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(semAddYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minUserLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel9)
                                        .addComponent(semAddStartField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel10)
                                        .addComponent(semAddEndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(semAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(semAddConf)
                                        .addComponent(semAddCancelBtn))
                                .addGap(0, 205, Short.MAX_VALUE))
        );

        semEditPanel.add(semAddPanel);

        minInforLabel11.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel11.setText("Tìm học kỳ");

        semSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        semSearchField.setText("ID");

        semSearchBtn.setText("Search");

        javax.swing.GroupLayout semesterContentLayout = new javax.swing.GroupLayout(semesterContent);
        semesterContent.setLayout(semesterContentLayout);
        semesterContentLayout.setHorizontalGroup(
                semesterContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, semesterContentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(semesterContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(semesterContentLayout.createSequentialGroup()
                                                .addGroup(semesterContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(semInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minInforLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(semesterContentLayout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(semSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(semSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(semEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(semScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
        );
        semesterContentLayout.setVerticalGroup(
                semesterContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(semesterContentLayout.createSequentialGroup()
                                .addComponent(semScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(semesterContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(semesterContentLayout.createSequentialGroup()
                                                .addComponent(minInforLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(semesterContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(semSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(semSearchBtn))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(semInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(semEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        contentPane.add(semesterContent);

        classContent.setBackground(new java.awt.Color(255, 255, 255));
        classContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        classTable.setModel(new javax.swing.table.DefaultTableModel(
                Dashboard.listClass,
                new String[]{
                        "ID", "Tên lớp", "Số bạn nam", "Số bạn nữ"
                }
        ));
        classScrollPane.setViewportView(classTable);

        classInforPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        minInforLabel9.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel9.setText("Thông tin lớp học");

        minNameLabel7.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel7.setText("Tên lớp học:");

        className.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        className.setText("hk");

        minIdLabel3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minIdLabel3.setText("Id:");

        classId.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        classId.setText("200");

        minUserLabel6.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel6.setText("Số bạn nam:");

        classNummale.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        classNummale.setText("0");

        minPassLabel8.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel8.setText("Số bạn nữ:");

        classNumfemale.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        classNumfemale.setText("0");

        classAddBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        classAddBtn.setText("Thêm lớp học");

        classDelConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        classDelConf.setText("Xóa lớp học");

        javax.swing.GroupLayout classInforPanelLayout = new javax.swing.GroupLayout(classInforPanel);
        classInforPanel.setLayout(classInforPanelLayout);
        classInforPanelLayout.setHorizontalGroup(
                classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(classInforPanelLayout.createSequentialGroup()
                                .addGroup(classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(classInforPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, classInforPanelLayout.createSequentialGroup()
                                                        .addGap(42, 42, 42)
                                                        .addGroup(classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(minPassLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(minUserLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(minNameLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(minIdLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(classNumfemale, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                                                .addComponent(className, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(classId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(classNummale, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, classInforPanelLayout.createSequentialGroup()
                                                        .addGap(33, 33, 33)
                                                        .addComponent(classAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(28, 28, 28)
                                                        .addComponent(classDelConf, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(58, Short.MAX_VALUE))
        );
        classInforPanelLayout.setVerticalGroup(
                classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(classInforPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(className))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minIdLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(classId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minUserLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(classNummale))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel8)
                                        .addComponent(classNumfemale))
                                .addGap(33, 33, 33)
                                .addGroup(classInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(classAddBtn)
                                        .addComponent(classDelConf))
                                .addContainerGap(105, Short.MAX_VALUE))
        );

        classEditPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        classEditPanel.setLayout(new javax.swing.OverlayLayout(classEditPanel));

        javax.swing.GroupLayout classCancelPanelLayout = new javax.swing.GroupLayout(classCancelPanel);
        classCancelPanel.setLayout(classCancelPanelLayout);
        classCancelPanelLayout.setHorizontalGroup(
                classCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 441, Short.MAX_VALUE)
        );
        classCancelPanelLayout.setVerticalGroup(
                classCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );

        classEditPanel.add(classCancelPanel);

        minInforLabel12.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel12.setText("Thêm lớp học");

        minNameLabel9.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel9.setText("Tên lớp học:");

        classAddNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        classAddConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        classAddConf.setText("Xác nhận");

        classAddCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        classAddCancelBtn.setText("Hủy");

        javax.swing.GroupLayout classAddPanelLayout = new javax.swing.GroupLayout(classAddPanel);
        classAddPanel.setLayout(classAddPanelLayout);
        classAddPanelLayout.setHorizontalGroup(
                classAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(classAddPanelLayout.createSequentialGroup()
                                .addGroup(classAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(classAddPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(classAddPanelLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(classAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(classAddPanelLayout.createSequentialGroup()
                                                                .addComponent(classAddConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(classAddCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(classAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minNameLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(classAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(93, Short.MAX_VALUE))
        );
        classAddPanelLayout.setVerticalGroup(
                classAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(classAddPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(classAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(classAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(classAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(classAddConf)
                                        .addComponent(classAddCancelBtn))
                                .addGap(0, 299, Short.MAX_VALUE))
        );

        classEditPanel.add(classAddPanel);

        minInforLabel13.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel13.setText("Tìm lớp học");

        classSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        classSearchField.setText("ID");

        classSearchBtn.setText("Search");

        javax.swing.GroupLayout classContentLayout = new javax.swing.GroupLayout(classContent);
        classContent.setLayout(classContentLayout);
        classContentLayout.setHorizontalGroup(
                classContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, classContentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(classContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(classContentLayout.createSequentialGroup()
                                                .addGroup(classContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(classInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minInforLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(classContentLayout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(classSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(classSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(classEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(classScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
        );
        classContentLayout.setVerticalGroup(
                classContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(classContentLayout.createSequentialGroup()
                                .addComponent(classScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(classContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(classContentLayout.createSequentialGroup()
                                                .addComponent(minInforLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(classContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(classSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(classSearchBtn))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(classInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(classEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        contentPane.add(classContent);

        studentContent.setBackground(new java.awt.Color(255, 255, 255));
        studentContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        stuTable.setModel(new javax.swing.table.DefaultTableModel(
                Dashboard.listStudent,
                new String[]{
                        "ID", "Họ tên", "MSSV", "Tài khoản", "Giới tính", "Ngày sinh", "Số môn đã đk", "Mã lớp"
                }
        ));
        stuScrollPane.setViewportView(stuTable);

        stuInforPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        minInforLabel14.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel14.setText("Thông tin sinh viên");

        minNameLabel10.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel10.setText("Họ tên:");

        stuName.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        stuName.setText("ten");

        minUserLabel7.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel7.setText("Mssv:");

        stuMssv.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        stuMssv.setText("mssv");

        minPassLabel11.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel11.setText("Giới tính:");

        stuSex.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        stuSex.setText("gioitinh");

        stuAddBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stuAddBtn.setText("Thêm học sinh");

        stuResetConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stuResetConf.setText("Reset mật khẩu");
        stuResetConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuResetConfActionPerformed(evt);
            }
        });

        stuUpBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stuUpBtn.setText("Cập nhật");
        stuUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuUpBtnActionPerformed(evt);
            }
        });

        minPassLabel14.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel14.setText("Sinh nhật:");

        stuBirth.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        stuBirth.setText("sinhnhat");

        minPassLabel15.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel15.setText("Số môn đk:");

        stuNumsubject.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        stuNumsubject.setText("somondk ");

        minPassLabel16.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel16.setText("Lớp:");

        stuClass.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        stuClass.setText("lop");

        javax.swing.GroupLayout stuInforPanelLayout = new javax.swing.GroupLayout(stuInforPanel);
        stuInforPanel.setLayout(stuInforPanelLayout);
        stuInforPanelLayout.setHorizontalGroup(
                stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stuInforPanelLayout.createSequentialGroup()
                                .addGroup(stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(stuInforPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(stuInforPanelLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(stuInforPanelLayout.createSequentialGroup()
                                                                .addComponent(stuAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(28, 28, 28)
                                                                .addComponent(stuUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(stuInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minNameLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(56, 56, 56)
                                                                .addComponent(stuName, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stuInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(stuBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(stuInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(stuNumsubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(stuInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(stuSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(stuInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minUserLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(stuMssv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(stuInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(stuClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addComponent(stuResetConf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        stuInforPanelLayout.setVerticalGroup(
                stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stuInforPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stuName))
                                .addGap(1, 1, 1)
                                .addGroup(stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minUserLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stuMssv))
                                .addGap(4, 4, 4)
                                .addGroup(stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel11)
                                        .addComponent(stuSex))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel14)
                                        .addComponent(stuBirth))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel15)
                                        .addComponent(stuNumsubject))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel16)
                                        .addComponent(stuClass))
                                .addGap(18, 18, 18)
                                .addGroup(stuInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(stuUpBtn)
                                        .addComponent(stuAddBtn))
                                .addGap(18, 18, 18)
                                .addComponent(stuResetConf)
                                .addContainerGap(46, Short.MAX_VALUE))
        );

        stuEditPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        stuEditPanel.setLayout(new javax.swing.OverlayLayout(stuEditPanel));

        javax.swing.GroupLayout stuCancelPanelLayout = new javax.swing.GroupLayout(stuCancelPanel);
        stuCancelPanel.setLayout(stuCancelPanelLayout);
        stuCancelPanelLayout.setHorizontalGroup(
                stuCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 413, Short.MAX_VALUE)
        );
        stuCancelPanelLayout.setVerticalGroup(
                stuCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );

        stuEditPanel.add(stuCancelPanel);

        minInforLabel15.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel15.setText("Cập nhật sinh viên");

        minNameLabel11.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel11.setText("Họ tên:");

        stuUpNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuUpNameField.setText("Võ Thế Minh");

        minPassLabel12.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel12.setText("Mssv:");

        stuUpCodeField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuUpCodeField.setText("18120211");

        stuUpConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stuUpConf.setText("Xác nhận");

        stuUpCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stuUpCancelBtn.setText("Hủy");

        minPassLabel17.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel17.setText("Giới tính:");

        stuUpSexField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuUpSexField.setText("Nam");

        minPassLabel18.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel18.setText("Sinh nhật:");

        stuUpBirthField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuUpBirthField.setText("18120211");
        stuUpBirthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuUpBirthFieldActionPerformed(evt);
            }
        });

        minPassLabel19.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel19.setText("Lớp:");

        stuUpClassField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuUpClassField.setText("ID");

        javax.swing.GroupLayout stuUpPanelLayout = new javax.swing.GroupLayout(stuUpPanel);
        stuUpPanel.setLayout(stuUpPanelLayout);
        stuUpPanelLayout.setHorizontalGroup(
                stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stuUpPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(stuUpPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(stuUpPanelLayout.createSequentialGroup()
                                                .addComponent(minPassLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(stuUpClassField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, stuUpPanelLayout.createSequentialGroup()
                                                        .addComponent(minPassLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(stuUpSexField))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, stuUpPanelLayout.createSequentialGroup()
                                                        .addGroup(stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(minPassLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(minNameLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(stuUpCodeField)
                                                                .addComponent(stuUpNameField)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, stuUpPanelLayout.createSequentialGroup()
                                                        .addComponent(stuUpConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(stuUpCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(stuUpPanelLayout.createSequentialGroup()
                                                        .addComponent(minPassLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(stuUpBirthField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(88, Short.MAX_VALUE))
        );
        stuUpPanelLayout.setVerticalGroup(
                stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stuUpPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stuUpNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel12)
                                        .addComponent(stuUpCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel17)
                                        .addComponent(stuUpSexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel18)
                                        .addComponent(stuUpBirthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel19)
                                        .addComponent(stuUpClassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(stuUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(stuUpConf)
                                        .addComponent(stuUpCancelBtn))
                                .addContainerGap(150, Short.MAX_VALUE))
        );

        stuEditPanel.add(stuUpPanel);

        minInforLabel16.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel16.setText("Thêm tài khoản giáo vụ");

        minNameLabel12.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel12.setText("Họ tên:");

        minUserLabel8.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel8.setText("Tài khoản:");

        minPassLabel13.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel13.setText("Mật khẩu:");

        stuAddNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuAddNameField.setText("hoten");

        stuAddUserField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuAddUserField.setText("taikhoan");

        stuAddPassField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuAddPassField.setText("matkhau");

        stuAddConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stuAddConf.setText("Xác nhận");

        stuAddCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stuAddCancelBtn.setText("Hủy");

        minPassLabel20.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel20.setText("Mssv:");

        stuUpCodeField1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuUpCodeField1.setText("18120211");

        minPassLabel21.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel21.setText("Giới tính:");

        stuAddSexField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuAddSexField.setText("Nam");

        minPassLabel22.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel22.setText("Sinh nhật:");

        stuAddBirthField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuAddBirthField.setText("2000-11-16");

        minPassLabel23.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel23.setText("Lớp:");

        stuAddClassField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuAddClassField.setText("ID");

        javax.swing.GroupLayout stuAddPanelLayout = new javax.swing.GroupLayout(stuAddPanel);
        stuAddPanel.setLayout(stuAddPanelLayout);
        stuAddPanelLayout.setHorizontalGroup(
                stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stuAddPanelLayout.createSequentialGroup()
                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(stuAddPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(stuAddPanelLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(stuAddPanelLayout.createSequentialGroup()
                                                                .addComponent(stuAddConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(stuAddCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(stuAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(stuAddPassField))
                                                        .addGroup(stuAddPanelLayout.createSequentialGroup()
                                                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(minNameLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minUserLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(stuAddUserField)
                                                                        .addComponent(stuAddNameField)))
                                                        .addGroup(stuAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(stuAddClassField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(stuAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(stuAddSexField))
                                                        .addGroup(stuAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(stuUpCodeField1))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stuAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(stuAddBirthField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(75, Short.MAX_VALUE))
        );
        stuAddPanelLayout.setVerticalGroup(
                stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(stuAddPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stuAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(stuAddUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minUserLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel13)
                                        .addComponent(stuAddPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel20)
                                        .addComponent(stuUpCodeField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel21)
                                        .addComponent(stuAddSexField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel22)
                                        .addComponent(stuAddBirthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel23)
                                        .addComponent(stuAddClassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(stuAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(stuAddConf)
                                        .addComponent(stuAddCancelBtn))
                                .addContainerGap(107, Short.MAX_VALUE))
        );

        stuEditPanel.add(stuAddPanel);

        minInforLabel17.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel17.setText("Tìm sinh viên");

        stuSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        stuSearchField.setText("ID");

        stuSearchBtn.setText("Search");

        javax.swing.GroupLayout studentContentLayout = new javax.swing.GroupLayout(studentContent);
        studentContent.setLayout(studentContentLayout);
        studentContentLayout.setHorizontalGroup(
                studentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentContentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(studentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(studentContentLayout.createSequentialGroup()
                                                .addGroup(studentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(stuInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minInforLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(studentContentLayout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(stuSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(stuSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(stuEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(stuScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
        );
        studentContentLayout.setVerticalGroup(
                studentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(studentContentLayout.createSequentialGroup()
                                .addComponent(stuScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(studentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(studentContentLayout.createSequentialGroup()
                                                .addComponent(minInforLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(studentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(stuSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(stuSearchBtn))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(stuInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(stuEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        contentPane.add(studentContent);

        sessionContent.setBackground(new java.awt.Color(255, 255, 255));
        sessionContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        sesTable.setModel(new javax.swing.table.DefaultTableModel(
                Dashboard.listSession,
                new String[]{
                        "ID", "Ngày bắt đầu", "Ngày kết thúc", "Học kỳ"
                }
        ));
        sesScrollPane.setViewportView(sesTable);

        sesInforPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        minInforLabel18.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel18.setText("Thông tin kỳ đăng ký");

        minNameLabel13.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel13.setText("ID:");

        sesId.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        sesId.setText("id");

        minIdLabel4.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minIdLabel4.setText("Ngày bắt đầu: ");

        sesStart.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        sesStart.setText("200");

        minUserLabel9.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel9.setText("Ngày kết thúc:");

        sesEnd.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        sesEnd.setText("2021-9-1");

        minPassLabel24.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel24.setText("Học kỳ");

        sesSemester.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        sesSemester.setText("2021-10-1");

        sesAddBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sesAddBtn.setText("Thêm lớp học");

        javax.swing.GroupLayout sesInforPanelLayout = new javax.swing.GroupLayout(sesInforPanel);
        sesInforPanel.setLayout(sesInforPanelLayout);
        sesInforPanelLayout.setHorizontalGroup(
                sesInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sesInforPanelLayout.createSequentialGroup()
                                .addGroup(sesInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(sesAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(sesInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(sesInforPanelLayout.createSequentialGroup()
                                                        .addGap(42, 42, 42)
                                                        .addGroup(sesInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(minPassLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(minUserLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(minNameLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(minIdLabel4))
                                                        .addGap(50, 50, 50)
                                                        .addGroup(sesInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(sesSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(sesId, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(sesStart, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(sesEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(sesInforPanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(minInforLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(58, Short.MAX_VALUE))
        );
        sesInforPanelLayout.setVerticalGroup(
                sesInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sesInforPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(sesInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sesId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sesInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minIdLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sesStart))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(sesInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minUserLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sesEnd))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(sesInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel24)
                                        .addComponent(sesSemester))
                                .addGap(33, 33, 33)
                                .addComponent(sesAddBtn)
                                .addContainerGap(105, Short.MAX_VALUE))
        );

        sesEditPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sesEditPanel.setLayout(new javax.swing.OverlayLayout(sesEditPanel));

        javax.swing.GroupLayout sesCancelPanelLayout = new javax.swing.GroupLayout(sesCancelPanel);
        sesCancelPanel.setLayout(sesCancelPanelLayout);
        sesCancelPanelLayout.setHorizontalGroup(
                sesCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 441, Short.MAX_VALUE)
        );
        sesCancelPanelLayout.setVerticalGroup(
                sesCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );

        sesEditPanel.add(sesCancelPanel);

        minInforLabel19.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel19.setText("Thêm lớp học");

        minNameLabel14.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel14.setText("ID học kỳ");

        sesAddNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        sesAddConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sesAddConf.setText("Xác nhận");

        sesAddCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sesAddCancelBtn.setText("Hủy");

        minNameLabel15.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel15.setText("Ngày bắt đầu:");

        sesAddStartField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        minNameLabel16.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel16.setText("Ngày kết thúc:");

        sesAddEndField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        javax.swing.GroupLayout sesAddPanelLayout = new javax.swing.GroupLayout(sesAddPanel);
        sesAddPanel.setLayout(sesAddPanelLayout);
        sesAddPanelLayout.setHorizontalGroup(
                sesAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sesAddPanelLayout.createSequentialGroup()
                                .addGroup(sesAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(sesAddPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(sesAddPanelLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(sesAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(sesAddPanelLayout.createSequentialGroup()
                                                                .addComponent(sesAddConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(sesAddCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(sesAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minNameLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(sesAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(sesAddPanelLayout.createSequentialGroup()
                                                                .addGroup(sesAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(minNameLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                                                        .addComponent(minNameLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(sesAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(sesAddPanelLayout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(sesAddStartField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sesAddPanelLayout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addComponent(sesAddEndField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(93, Short.MAX_VALUE))
        );
        sesAddPanelLayout.setVerticalGroup(
                sesAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sesAddPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(sesAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sesAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(sesAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sesAddStartField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(sesAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sesAddEndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(sesAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sesAddConf)
                                        .addComponent(sesAddCancelBtn))
                                .addGap(0, 219, Short.MAX_VALUE))
        );

        sesEditPanel.add(sesAddPanel);

        minInforLabel20.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel20.setText("Tìm kỳ đăng ký");

        sesSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        sesSearchField.setText("ID");
        sesSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sesSearchFieldActionPerformed(evt);
            }
        });

        sesSearchBtn.setText("Search");

        javax.swing.GroupLayout sessionContentLayout = new javax.swing.GroupLayout(sessionContent);
        sessionContent.setLayout(sessionContentLayout);
        sessionContentLayout.setHorizontalGroup(
                sessionContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sessionContentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(sessionContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(sessionContentLayout.createSequentialGroup()
                                                .addGroup(sessionContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(sesInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minInforLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(sessionContentLayout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(sesSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(sesSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(sesEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(sesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
        );
        sessionContentLayout.setVerticalGroup(
                sessionContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(sessionContentLayout.createSequentialGroup()
                                .addComponent(sesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(sessionContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(sessionContentLayout.createSequentialGroup()
                                                .addComponent(minInforLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(sessionContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sesSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sesSearchBtn))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(sesInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(sesEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        contentPane.add(sessionContent);

        courseContent.setBackground(new java.awt.Color(255, 255, 255));
        courseContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        couTable.setModel(new javax.swing.table.DefaultTableModel(
                Dashboard.listCourse,
                new String[]{
                        "ID", "Mã môn", "Tên môn", "Số tín chỉ", "Giáo viên", "Phòng", "Thứ", "Ca"
                }
        ));
        couScrollPane.setViewportView(couTable);

        couInforPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        minInforLabel21.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel21.setText("Thông tin học phần");

        minIdLabel5.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minIdLabel5.setText("Id:");

        couId.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        couId.setText("id");

        minUserLabel10.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel10.setText("Tên học phần:");

        couName.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        couName.setText("CTDL&GT 18CTT2");

        minPassLabel25.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel25.setText("Năm:");

        couYear.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        couYear.setText("2021");

        couAddBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        couAddBtn.setText("Thêm học phần");

        couDelConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        couDelConf.setText("Xóa học phần");

        minPassLabel26.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel26.setText("Giáo viên:");

        couTeacher.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        couTeacher.setText("Phan Thị Phương Uyên");

        minPassLabel27.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel27.setText("Phòng:");

        couRoom.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        couRoom.setText("E104");

        minPassLabel28.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel28.setText("Thứ:");

        couDay.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        couDay.setText("2");

        minPassLabel29.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel29.setText("Ca:");

        couShift.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        couShift.setText("1");

        minPassLabel30.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel30.setText("Môn học:");

        couIdsubject.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        couIdsubject.setText("id môn học");

        minPassLabel31.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel31.setText("Giáo vụ:");

        couIdministry.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        couIdministry.setText("id giáo vụ");

        javax.swing.GroupLayout couInforPanelLayout = new javax.swing.GroupLayout(couInforPanel);
        couInforPanel.setLayout(couInforPanelLayout);
        couInforPanelLayout.setHorizontalGroup(
                couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(minInforLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(minPassLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minUserLabel10)
                                                                        .addComponent(minIdLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(couYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(couId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(couName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(couTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(couRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(couDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(couShift, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(couIdsubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(couIdministry, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                                                .addComponent(couAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(42, 42, 42)
                                                                .addComponent(couDelConf, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        couInforPanelLayout.setVerticalGroup(
                couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minIdLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couId))
                                .addGap(4, 4, 4)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minUserLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel25)
                                        .addComponent(couYear))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel26)
                                        .addComponent(couTeacher))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel27)
                                        .addComponent(couRoom))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel28)
                                        .addComponent(couDay))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel29)
                                        .addComponent(couShift))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel30)
                                        .addComponent(couIdsubject))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(couIdministry)
                                        .addComponent(minPassLabel31))
                                .addGap(18, 18, 18)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(couAddBtn)
                                        .addComponent(couDelConf)))
        );

        couEditPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        couEditPanel.setLayout(new javax.swing.OverlayLayout(couEditPanel));

        javax.swing.GroupLayout couCancelPanelLayout = new javax.swing.GroupLayout(couCancelPanel);
        couCancelPanel.setLayout(couCancelPanelLayout);
        couCancelPanelLayout.setHorizontalGroup(
                couCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 446, Short.MAX_VALUE)
        );
        couCancelPanelLayout.setVerticalGroup(
                couCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );

        couEditPanel.add(couCancelPanel);

        minInforLabel22.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel22.setText("Thêm học phần");

        minNameLabel18.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel18.setText("Tên học phần:");

        couAddNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        couAddNameField.setText("CTDL&GT 19CTT2");

        couAddConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        couAddConf.setText("Xác nhận");

        couAddCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        couAddCancelBtn.setText("Hủy");
        couAddCancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                couAddCancelBtnActionPerformed(evt);
            }
        });

        minNameLabel19.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel19.setText("Năm:");

        couAddYearField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        couAddYearField.setText("2021");

        minNameLabel20.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel20.setText("Giáo viên:");

        couAddTeacherField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        couAddTeacherField.setText("Phương Uyên");

        minNameLabel21.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel21.setText("Phòng học:");

        couAddRoomField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        couAddRoomField.setText("F203");

        minNameLabel22.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel22.setText("Thứ:");

        couAddDayField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        couAddDayField.setText("Thứ 2");

        minNameLabel23.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel23.setText("Ca:");

        couAddShiftField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        couAddShiftField.setText("3");

        minNameLabel24.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel24.setText("Id môn học:");

        couAddIdsubjectField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        couAddIdsubjectField.setText("1");

        minNameLabel25.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minNameLabel25.setText("Id kì đăng ký:");

        couAddIdsessionField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        couAddIdsessionField.setText("1");

        javax.swing.GroupLayout couAddPanelLayout = new javax.swing.GroupLayout(couAddPanel);
        couAddPanel.setLayout(couAddPanelLayout);
        couAddPanelLayout.setHorizontalGroup(
                couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(couAddPanelLayout.createSequentialGroup()
                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(couAddPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(couAddPanelLayout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(couAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minNameLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(couAddRoomField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(couAddPanelLayout.createSequentialGroup()
                                                                        .addComponent(minNameLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(30, 30, 30)
                                                                        .addComponent(couAddYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(couAddPanelLayout.createSequentialGroup()
                                                                        .addComponent(minNameLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(couAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(couAddPanelLayout.createSequentialGroup()
                                                                        .addComponent(minNameLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(30, 30, 30)
                                                                        .addComponent(couAddTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(couAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minNameLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(couAddDayField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(couAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minNameLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(couAddShiftField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(couAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minNameLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30, 30, 30)
                                                                .addComponent(couAddIdsubjectField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(couAddPanelLayout.createSequentialGroup()
                                                                .addComponent(minNameLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(couAddIdsessionField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(couAddPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(couAddConf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(couAddCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))
        );
        couAddPanelLayout.setVerticalGroup(
                couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(couAddPanelLayout.createSequentialGroup()
                                .addComponent(minInforLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couAddYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couAddTeacherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couAddRoomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couAddDayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couAddShiftField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couAddIdsubjectField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couAddIdsessionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(couAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(couAddConf)
                                        .addComponent(couAddCancelBtn))
                                .addContainerGap(72, Short.MAX_VALUE))
        );

        couEditPanel.add(couAddPanel);

        minInforLabel23.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel23.setText("Tìm học phần");

        couSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        couSearchField.setText("ID");

        couSearchBtn.setText("Search");

        javax.swing.GroupLayout courseContentLayout = new javax.swing.GroupLayout(courseContent);
        courseContent.setLayout(courseContentLayout);
        courseContentLayout.setHorizontalGroup(
                courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, courseContentLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(courseContentLayout.createSequentialGroup()
                                                .addGroup(courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(minInforLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(courseContentLayout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(couSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(couSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(couInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addComponent(couEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(couScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
        );
        courseContentLayout.setVerticalGroup(
                courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(courseContentLayout.createSequentialGroup()
                                .addComponent(couScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(courseContentLayout.createSequentialGroup()
                                                .addComponent(minInforLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(couSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(couSearchBtn))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(couInforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(couEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        contentPane.add(courseContent);

        registrationContent.setBackground(new java.awt.Color(255, 255, 255));
        registrationContent.setPreferredSize(new java.awt.Dimension(800, 580));

        minInforLabel26.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel26.setText("Tìm danh sách sinh viên đăng ký học phần ");

        regSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        regSearchField.setText("ID");

        regSearchBtn.setText("Search");

        // Cho phep table sap xep
        regCourseTable.setModel(new javax.swing.table.DefaultTableModel(
                Dashboard.listCourse,
                new String[]{
                        "ID", "Mã môn", "Tên môn", "Số tín chỉ", "Giáo viên", "Phòng", "Thứ", "Ca"
                }
        ));
        regCourseScrollPane.setViewportView(regCourseTable);

        // Cho phep table sap xep
        regTable.setModel(new javax.swing.table.DefaultTableModel(
                Dashboard.listRegistration,
                new String[]{
                        "Mssv", "Họ tên", "Mã môn", "Tên môn", "Giáo viên", "Ca học", "Thời điểm đăng ký"
                }
        ));
        regScrollPane.setViewportView(regTable);

        javax.swing.GroupLayout registrationContentLayout = new javax.swing.GroupLayout(registrationContent);
        registrationContent.setLayout(registrationContentLayout);
        registrationContentLayout.setHorizontalGroup(
                registrationContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrationContentLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(regSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(regSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(448, 448, 448))
                        .addComponent(regCourseScrollPane)
                        .addGroup(registrationContentLayout.createSequentialGroup()
                                .addComponent(minInforLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(regScrollPane)
        );
        registrationContentLayout.setVerticalGroup(
                registrationContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registrationContentLayout.createSequentialGroup()
                                .addComponent(regCourseScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minInforLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(registrationContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(regSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(regSearchBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(regScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
        );

        contentPane.add(registrationContent);

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
                mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPaneLayout.createSequentialGroup()
                                .addComponent(paneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );
        mainPaneLayout.setVerticalGroup(
                mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(paneMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                                        .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minUpCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minUpCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minUpCancelActionPerformed

    private void minUpPass2FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minUpPass2FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minUpPass2FieldActionPerformed

    private void minSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minSearchBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minSearchBtnActionPerformed

    private void minSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minSearchFieldActionPerformed

    private void minUpNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minAddNameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minAddNameField1ActionPerformed

    private void minUpPassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minAddPassField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minAddPassField1ActionPerformed

    private void minUpConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minAddConf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minAddConf1ActionPerformed

    private void minAddUserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minAddUserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minAddUserFieldActionPerformed

    private void subAddCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subAddCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subAddCodeFieldActionPerformed

    private void subUpCreditFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subUpCreditFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subUpCreditFieldActionPerformed

    private void semAddYearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semAddYearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semAddYearFieldActionPerformed

    private void stuUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuUpBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuUpBtnActionPerformed

    private void stuResetConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuResetConfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuResetConfActionPerformed

    private void stuUpBirthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuUpBirthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuUpBirthFieldActionPerformed

    private void sesSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sesSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sesSearchFieldActionPerformed

    private void couAddCancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_couAddCancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_couAddCancelBtnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton classAddBtn;
    private javax.swing.JButton classAddCancelBtn;
    private javax.swing.JButton classAddConf;
    private javax.swing.JTextField classAddNameField;
    private javax.swing.JPanel classAddPanel;
    private javax.swing.JPanel classCancelPanel;
    private javax.swing.JPanel classContent;
    private javax.swing.JButton classDelConf;
    private javax.swing.JPanel classEditPanel;
    private javax.swing.JLabel classIcon;
    private javax.swing.JLabel classId;
    private javax.swing.JPanel classInforPanel;
    private javax.swing.JLabel classLabel;
    private javax.swing.JLabel className;
    private javax.swing.JLabel classNumfemale;
    private javax.swing.JLabel classNummale;
    private javax.swing.JScrollPane classScrollPane;
    private javax.swing.JButton classSearchBtn;
    private javax.swing.JTextField classSearchField;
    private javax.swing.JPanel classTab;
    private javax.swing.JTable classTable;
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton couAddBtn;
    private javax.swing.JButton couAddCancelBtn;
    private javax.swing.JButton couAddConf;
    private javax.swing.JTextField couAddDayField;
    private javax.swing.JTextField couAddIdsessionField;
    private javax.swing.JTextField couAddIdsubjectField;
    private javax.swing.JTextField couAddNameField;
    private javax.swing.JPanel couAddPanel;
    private javax.swing.JTextField couAddRoomField;
    private javax.swing.JTextField couAddShiftField;
    private javax.swing.JTextField couAddTeacherField;
    private javax.swing.JTextField couAddYearField;
    private javax.swing.JPanel couCancelPanel;
    private javax.swing.JLabel couDay;
    private javax.swing.JButton couDelConf;
    private javax.swing.JPanel couEditPanel;
    private javax.swing.JLabel couId;
    private javax.swing.JLabel couIdministry;
    private javax.swing.JLabel couIdsubject;
    private javax.swing.JPanel couInforPanel;
    private javax.swing.JLabel couName;
    private javax.swing.JLabel couRoom;
    private javax.swing.JScrollPane couScrollPane;
    private javax.swing.JButton couSearchBtn;
    private javax.swing.JTextField couSearchField;
    private javax.swing.JLabel couShift;
    private javax.swing.JTable couTable;
    private javax.swing.JLabel couTeacher;
    private javax.swing.JLabel couYear;
    private javax.swing.JPanel courseContent;
    private javax.swing.JLabel courseIcon;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JPanel courseTab;
    private javax.swing.JLabel lStudentCourseIcon;
    private javax.swing.JLabel lStudentCourseLabel;
    private javax.swing.JPanel lStudentCourseTab;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JPanel logoutTab;
    private javax.swing.JPanel mainPane;
    private javax.swing.JButton minAddBtn;
    private javax.swing.JButton minAddCancelBtn;
    private javax.swing.JButton minAddConf;
    private javax.swing.JTextField minAddNameField;
    private javax.swing.JPanel minAddPanel;
    private javax.swing.JTextField minAddPassField;
    private javax.swing.JTextField minAddUserField;
    private javax.swing.JPanel minCancelPanel;
    private javax.swing.JButton minDelConf;
    private javax.swing.JPanel minEditPanel;
    private javax.swing.JLabel minId;
    private javax.swing.JLabel minId1;
    private javax.swing.JLabel minIdLabel;
    private javax.swing.JLabel minIdLabel1;
    private javax.swing.JLabel minIdLabel2;
    private javax.swing.JLabel minIdLabel3;
    private javax.swing.JLabel minIdLabel4;
    private javax.swing.JLabel minIdLabel5;
    private javax.swing.JLabel minInforLabel;
    private javax.swing.JLabel minInforLabel1;
    private javax.swing.JLabel minInforLabel10;
    private javax.swing.JLabel minInforLabel11;
    private javax.swing.JLabel minInforLabel12;
    private javax.swing.JLabel minInforLabel13;
    private javax.swing.JLabel minInforLabel14;
    private javax.swing.JLabel minInforLabel15;
    private javax.swing.JLabel minInforLabel16;
    private javax.swing.JLabel minInforLabel17;
    private javax.swing.JLabel minInforLabel18;
    private javax.swing.JLabel minInforLabel19;
    private javax.swing.JLabel minInforLabel2;
    private javax.swing.JLabel minInforLabel20;
    private javax.swing.JLabel minInforLabel21;
    private javax.swing.JLabel minInforLabel22;
    private javax.swing.JLabel minInforLabel23;
    private javax.swing.JLabel minInforLabel26;
    private javax.swing.JLabel minInforLabel3;
    private javax.swing.JLabel minInforLabel4;
    private javax.swing.JLabel minInforLabel5;
    private javax.swing.JLabel minInforLabel6;
    private javax.swing.JLabel minInforLabel7;
    private javax.swing.JLabel minInforLabel8;
    private javax.swing.JLabel minInforLabel9;
    private javax.swing.JPanel minInforPanel;
    private javax.swing.JLabel minName;
    private javax.swing.JLabel minName1;
    private javax.swing.JLabel minNameLabel;
    private javax.swing.JLabel minNameLabel1;
    private javax.swing.JLabel minNameLabel10;
    private javax.swing.JLabel minNameLabel11;
    private javax.swing.JLabel minNameLabel12;
    private javax.swing.JLabel minNameLabel13;
    private javax.swing.JLabel minNameLabel14;
    private javax.swing.JLabel minNameLabel15;
    private javax.swing.JLabel minNameLabel16;
    private javax.swing.JLabel minNameLabel18;
    private javax.swing.JLabel minNameLabel19;
    private javax.swing.JLabel minNameLabel2;
    private javax.swing.JLabel minNameLabel20;
    private javax.swing.JLabel minNameLabel21;
    private javax.swing.JLabel minNameLabel22;
    private javax.swing.JLabel minNameLabel23;
    private javax.swing.JLabel minNameLabel24;
    private javax.swing.JLabel minNameLabel25;
    private javax.swing.JLabel minNameLabel3;
    private javax.swing.JLabel minNameLabel4;
    private javax.swing.JLabel minNameLabel5;
    private javax.swing.JLabel minNameLabel6;
    private javax.swing.JLabel minNameLabel7;
    private javax.swing.JLabel minNameLabel8;
    private javax.swing.JLabel minNameLabel9;
    private javax.swing.JLabel minPass;
    private javax.swing.JLabel minPass1;
    private javax.swing.JLabel minPassLabel;
    private javax.swing.JLabel minPassLabel1;
    private javax.swing.JLabel minPassLabel10;
    private javax.swing.JLabel minPassLabel11;
    private javax.swing.JLabel minPassLabel12;
    private javax.swing.JLabel minPassLabel13;
    private javax.swing.JLabel minPassLabel14;
    private javax.swing.JLabel minPassLabel15;
    private javax.swing.JLabel minPassLabel16;
    private javax.swing.JLabel minPassLabel17;
    private javax.swing.JLabel minPassLabel18;
    private javax.swing.JLabel minPassLabel19;
    private javax.swing.JLabel minPassLabel2;
    private javax.swing.JLabel minPassLabel20;
    private javax.swing.JLabel minPassLabel21;
    private javax.swing.JLabel minPassLabel22;
    private javax.swing.JLabel minPassLabel23;
    private javax.swing.JLabel minPassLabel24;
    private javax.swing.JLabel minPassLabel25;
    private javax.swing.JLabel minPassLabel26;
    private javax.swing.JLabel minPassLabel27;
    private javax.swing.JLabel minPassLabel28;
    private javax.swing.JLabel minPassLabel29;
    private javax.swing.JLabel minPassLabel3;
    private javax.swing.JLabel minPassLabel30;
    private javax.swing.JLabel minPassLabel31;
    private javax.swing.JLabel minPassLabel4;
    private javax.swing.JLabel minPassLabel5;
    private javax.swing.JLabel minPassLabel6;
    private javax.swing.JLabel minPassLabel7;
    private javax.swing.JLabel minPassLabel8;
    private javax.swing.JLabel minPassLabel9;
    private javax.swing.JButton minResetConf;
    private javax.swing.JScrollPane minScrollPane;
    private javax.swing.JButton minSearchBtn;
    private javax.swing.JTextField minSearchField;
    private javax.swing.JTable minTable;
    private javax.swing.JButton minUpBtn;
    private javax.swing.JButton minUpCancelBtn;
    private javax.swing.JButton minUpConf;
    private javax.swing.JTextField minUpNameField;
    private javax.swing.JPanel minUpPanel;
    private javax.swing.JTextField minUpPassField;
    private javax.swing.JLabel minUser;
    private javax.swing.JLabel minUser1;
    private javax.swing.JLabel minUserLabel;
    private javax.swing.JLabel minUserLabel1;
    private javax.swing.JLabel minUserLabel10;
    private javax.swing.JLabel minUserLabel2;
    private javax.swing.JLabel minUserLabel3;
    private javax.swing.JLabel minUserLabel4;
    private javax.swing.JLabel minUserLabel5;
    private javax.swing.JLabel minUserLabel6;
    private javax.swing.JLabel minUserLabel7;
    private javax.swing.JLabel minUserLabel8;
    private javax.swing.JLabel minUserLabel9;
    private javax.swing.JPanel ministryContent;
    private javax.swing.JLabel ministryIcon;
    private javax.swing.JLabel ministryLabel;
    private javax.swing.JPanel ministryTab;
    private javax.swing.JPanel paneMenu;
    private javax.swing.JScrollPane regCourseScrollPane;
    private javax.swing.JTable regCourseTable;
    private javax.swing.JScrollPane regScrollPane;
    private javax.swing.JButton regSearchBtn;
    private javax.swing.JTextField regSearchField;
    private javax.swing.JTable regTable;
    private javax.swing.JPanel registrationContent;
    private javax.swing.JButton semAddBtn;
    private javax.swing.JButton semAddCancelBtn;
    private javax.swing.JButton semAddConf;
    private javax.swing.JTextField semAddEndField;
    private javax.swing.JTextField semAddNameField;
    private javax.swing.JPanel semAddPanel;
    private javax.swing.JTextField semAddStartField;
    private javax.swing.JTextField semAddYearField;
    private javax.swing.JPanel semCancelPanel;
    private javax.swing.JButton semDelConf;
    private javax.swing.JPanel semEditPanel;
    private javax.swing.JPanel semInforPanel;
    private javax.swing.JScrollPane semScrollPane;
    private javax.swing.JButton semSearchBtn;
    private javax.swing.JTextField semSearchField;
    private javax.swing.JButton semSetConf;
    private javax.swing.JTable semTable;
    private javax.swing.JPanel semesterContent;
    private javax.swing.JLabel semesterIcon;
    private javax.swing.JLabel semesterLabel;
    private javax.swing.JPanel semesterTab;
    private javax.swing.JButton sesAddBtn;
    private javax.swing.JButton sesAddCancelBtn;
    private javax.swing.JButton sesAddConf;
    private javax.swing.JTextField sesAddEndField;
    private javax.swing.JTextField sesAddNameField;
    private javax.swing.JPanel sesAddPanel;
    private javax.swing.JTextField sesAddStartField;
    private javax.swing.JPanel sesCancelPanel;
    private javax.swing.JPanel sesEditPanel;
    private javax.swing.JLabel sesEnd;
    private javax.swing.JLabel sesId;
    private javax.swing.JPanel sesInforPanel;
    private javax.swing.JScrollPane sesScrollPane;
    private javax.swing.JButton sesSearchBtn;
    private javax.swing.JTextField sesSearchField;
    private javax.swing.JLabel sesSemester;
    private javax.swing.JLabel sesStart;
    private javax.swing.JTable sesTable;
    private javax.swing.JPanel sessionContent;
    private javax.swing.JLabel sessionIcon;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JPanel sessionTab;
    private javax.swing.JTextField stuAddBirthField;
    private javax.swing.JButton stuAddBtn;
    private javax.swing.JButton stuAddCancelBtn;
    private javax.swing.JTextField stuAddClassField;
    private javax.swing.JButton stuAddConf;
    private javax.swing.JTextField stuAddNameField;
    private javax.swing.JPanel stuAddPanel;
    private javax.swing.JTextField stuAddPassField;
    private javax.swing.JTextField stuAddSexField;
    private javax.swing.JTextField stuAddUserField;
    private javax.swing.JLabel stuBirth;
    private javax.swing.JPanel stuCancelPanel;
    private javax.swing.JLabel stuClass;
    private javax.swing.JPanel stuEditPanel;
    private javax.swing.JPanel stuInforPanel;
    private javax.swing.JLabel stuMssv;
    private javax.swing.JLabel stuName;
    private javax.swing.JLabel stuNumsubject;
    private javax.swing.JButton stuResetConf;
    private javax.swing.JScrollPane stuScrollPane;
    private javax.swing.JButton stuSearchBtn;
    private javax.swing.JTextField stuSearchField;
    private javax.swing.JLabel stuSex;
    private javax.swing.JTable stuTable;
    private javax.swing.JTextField stuUpBirthField;
    private javax.swing.JButton stuUpBtn;
    private javax.swing.JButton stuUpCancelBtn;
    private javax.swing.JTextField stuUpClassField;
    private javax.swing.JTextField stuUpCodeField;
    private javax.swing.JTextField stuUpCodeField1;
    private javax.swing.JButton stuUpConf;
    private javax.swing.JTextField stuUpNameField;
    private javax.swing.JPanel stuUpPanel;
    private javax.swing.JTextField stuUpSexField;
    private javax.swing.JPanel studentContent;
    private javax.swing.JLabel studentIcon;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JPanel studentTab;
    private javax.swing.JButton subAddBtn;
    private javax.swing.JButton subAddCancelBtn;
    private javax.swing.JTextField subAddCodeField;
    private javax.swing.JButton subAddConf;
    private javax.swing.JTextField subAddCreditField;
    private javax.swing.JTextField subAddNameField;
    private javax.swing.JPanel subAddPanel;
    private javax.swing.JPanel subCancelPanel;
    private javax.swing.JLabel subCode;
    private javax.swing.JLabel subCredit;
    private javax.swing.JButton subDelConf;
    private javax.swing.JPanel subEditPanel;
    private javax.swing.JLabel subId;
    private javax.swing.JPanel subInforPanel;
    private javax.swing.JLabel subName;
    private javax.swing.JScrollPane subScrollPane;
    private javax.swing.JButton subSearchBtn;
    private javax.swing.JTextField subSearchField;
    private javax.swing.JTable subTable;
    private javax.swing.JButton subUpBtn;
    private javax.swing.JButton subUpCancelBtn;
    private javax.swing.JButton subUpConf;
    private javax.swing.JTextField subUpCreditField;
    private javax.swing.JTextField subUpNameField;
    private javax.swing.JPanel subUpPanel;
    private javax.swing.JTextField subUpPassField;
    private javax.swing.JPanel subjectContent;
    private javax.swing.JLabel subjectIcon;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JPanel subjectTab;
    // End of variables declaration//GEN-END:variables
}
