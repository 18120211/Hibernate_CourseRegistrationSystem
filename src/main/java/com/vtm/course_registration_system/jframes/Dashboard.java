/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vtm.course_registration_system.jframes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author minht
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Dashboard() {
//        setExtendedState(Dashboard.MAXIMIZED_BOTH);
//        setUndecorated(true);
        initComponents();
        moreConfig();

    }

    private void moreConfig() {
        setLocationRelativeTo(null);

        minTable.setAutoCreateRowSorter(true);
        minTable.setDefaultEditor(Object.class, null);

        addAction();
    }

    private void addAction() {
//        Disable edit table
        ((DefaultTableCellRenderer) minTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

//        Disable Resizable
        setResizable(false);

//        Menu click handle
        this.ministryTab.addMouseListener(new MenuClickHandle(ministryTab, ministryContent));
        this.subjectTab.addMouseListener(new MenuClickHandle(subjectTab, subjectContent));
        this.semesterTab.addMouseListener(new MenuClickHandle(semesterTab, semesterContent));
        this.classTab.addMouseListener(new MenuClickHandle(classTab, classContent));
        this.studentTab.addMouseListener(new MenuClickHandle(studentTab, studentContent));
        this.sessionTab.addMouseListener(new MenuClickHandle(sessionTab, sessionContent));
        this.courseTab.addMouseListener(new MenuClickHandle(courseTab, courseContent));
        this.listStudentTab.addMouseListener(new MenuClickHandle(listStudentTab, listStudentContent));

        this.ministryLabel.addMouseListener(new MenuClickHandle(ministryTab, ministryContent));
        this.subjectLabel.addMouseListener(new MenuClickHandle(subjectTab, subjectContent));
        this.semesterLabel.addMouseListener(new MenuClickHandle(semesterTab, semesterContent));
        this.classLabel.addMouseListener(new MenuClickHandle(classTab, classContent));
        this.studentLabel.addMouseListener(new MenuClickHandle(studentTab, studentContent));
        this.sessionLabel.addMouseListener(new MenuClickHandle(sessionTab, sessionContent));
        this.courseLabel.addMouseListener(new MenuClickHandle(courseTab, courseContent));
        this.listStudentLabel.addMouseListener(new MenuClickHandle(listStudentTab, listStudentContent));

//        MinistryContent event handle
        this.minTable.getSelectionModel().addListSelectionListener(new tableListener(minTable));
        this.minAddBtn.addMouseListener(new ministryClickListener(this.minAddPanel));
        this.minEditBtn.addMouseListener(new ministryClickListener(this.minEditPanel));
    }

    class ministryClickListener extends MouseAdapter {
        JPanel panel = new JPanel();
        Dashboard dashboard = Dashboard.this;
        public ministryClickListener(JPanel panel) {
            this.panel = panel;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
            dashboard.minAddPanel.setVisible(false);
            dashboard.minEditPanel.setVisible(false);
            this.panel.setVisible(true);
        }

    }

    class tableListener implements ListSelectionListener {

        private JTable table;

        public tableListener(JTable table) {
            this.table = table;
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            for (int i = 0; i < table.getColumnCount(); i++) {
                System.out.print(table.getValueAt(table.getSelectedRow(), i).toString() + " ");
            }
            System.out.println("");
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
            this.dashboard.listStudentTab.setBackground(new Color(204, 204, 204));
            this.selectedTab.setBackground(new Color(102, 102, 255));

            this.dashboard.ministryContent.setVisible(false);
            this.dashboard.subjectContent.setVisible(false);
            this.dashboard.semesterContent.setVisible(false);
            this.dashboard.classContent.setVisible(false);
            this.dashboard.studentContent.setVisible(false);
            this.dashboard.sessionContent.setVisible(false);
            this.dashboard.courseContent.setVisible(false);
            this.dashboard.listStudentContent.setVisible(false);
            this.selectedContent.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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
        listStudentTab = new javax.swing.JPanel();
        listStudentLabel = new javax.swing.JLabel();
        listCourse = new javax.swing.JLabel();
        logoutTab = new javax.swing.JPanel();
        logoutLabel = new javax.swing.JLabel();
        logoutIcon = new javax.swing.JLabel();
        contentPane = new javax.swing.JPanel();
        ministryContent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        minTable = new javax.swing.JTable();
        minInforPane = new javax.swing.JPanel();
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
        minRestBtn = new javax.swing.JButton();
        minEditBtn = new javax.swing.JButton();
        minDelBtn = new javax.swing.JButton();
        ministryEditPanel = new javax.swing.JPanel();
        minAddPanel = new javax.swing.JPanel();
        minAddLabel = new javax.swing.JLabel();
        minAddName = new javax.swing.JLabel();
        minAddUser = new javax.swing.JLabel();
        minAddPass = new javax.swing.JLabel();
        minAddUserField = new javax.swing.JTextField();
        minAddPassField = new javax.swing.JTextField();
        minAddNameField = new javax.swing.JTextField();
        minAddCancel = new javax.swing.JButton();
        minAddPass2 = new javax.swing.JLabel();
        minAddPass2Field = new javax.swing.JTextField();
        minAddConf = new javax.swing.JButton();
        minEditPanel = new javax.swing.JPanel();
        minAddLabel1 = new javax.swing.JLabel();
        minAddName1 = new javax.swing.JLabel();
        minAddPass1 = new javax.swing.JLabel();
        minAddPass3 = new javax.swing.JLabel();
        minEditNameField = new javax.swing.JTextField();
        minEditPassField = new javax.swing.JTextField();
        minEditPass2Field = new javax.swing.JTextField();
        minEditCancel = new javax.swing.JButton();
        minEditConf = new javax.swing.JButton();
        subjectContent = new javax.swing.JPanel();
        semesterContent = new javax.swing.JPanel();
        classContent = new javax.swing.JPanel();
        studentContent = new javax.swing.JPanel();
        sessionContent = new javax.swing.JPanel();
        courseContent = new javax.swing.JPanel();
        listStudentContent = new javax.swing.JPanel();

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

        listStudentTab.setBackground(new java.awt.Color(204, 204, 204));
        listStudentTab.setPreferredSize(new java.awt.Dimension(100, 45));

        listStudentLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        listStudentLabel.setText("Danh sách");
        listStudentLabel.setToolTipText("");

        listCourse.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\List.png")); // NOI18N

        javax.swing.GroupLayout listStudentTabLayout = new javax.swing.GroupLayout(listStudentTab);
        listStudentTab.setLayout(listStudentTabLayout);
        listStudentTabLayout.setHorizontalGroup(
                listStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(listStudentTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(listCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(listStudentLabel))
        );
        listStudentTabLayout.setVerticalGroup(
                listStudentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(listStudentTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(listStudentLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(listCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(listStudentTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(logoutTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        paneMenuLayout.setVerticalGroup(
                paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneMenuLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(listStudentTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPane.setLayout(new javax.swing.OverlayLayout(contentPane));

        ministryContent.setBackground(new java.awt.Color(255, 255, 255));
        ministryContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        minTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {2, "Võ Thế Hùng", "ministry2", "ministry2"},
                        {2, 2, 3, 4},
                        {3, 2, 3, 4},
                        {6, 2, 3, 4},
                        {1, 2, 3, 4},
                },
                new String [] {
                        "ID", "Họ tên", "Tài khoản", "Mật khẩu"
                }
        ));
        jScrollPane1.setViewportView(minTable);

        minInforPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        minInforLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel.setText("Thông tin giáo vụ");

        minNameLabel.setFont(minNameLabel.getFont().deriveFont(minNameLabel.getFont().getSize()+4f));
        minNameLabel.setText("Họ tên:");

        minName.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minName.setText("Võ Thế Hùng");

        minIdLabel.setFont(minIdLabel.getFont().deriveFont(minIdLabel.getFont().getSize()+4f));
        minIdLabel.setText("ID: ");

        minId.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minId.setText("2");

        minUserLabel.setFont(minUserLabel.getFont().deriveFont(minUserLabel.getFont().getSize()+4f));
        minUserLabel.setText("Tài khoản:");

        minUser.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUser.setText("ministry2");

        minPassLabel.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel.setText("Mật khẩu:");

        minPass.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPass.setText("ministry2");

        minAddBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minAddBtn.setText("Thêm giáo vụ");
        minAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minAddBtnActionPerformed(evt);
            }
        });

        minRestBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minRestBtn.setText("Reset mật khẩu");
        minRestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minRestBtnActionPerformed(evt);
            }
        });

        minEditBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minEditBtn.setText("Cập nhật");
        minEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minEditBtnActionPerformed(evt);
            }
        });

        minDelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minDelBtn.setText("Xóa giáo vụ");
        minDelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minDelBtnActionPerformed(evt);
            }
        });

        ministryEditPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ministryEditPanel.setLayout(new javax.swing.OverlayLayout(ministryEditPanel));

        minAddLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minAddLabel.setText("Thêm giáo vụ");

        minAddName.setFont(minAddName.getFont().deriveFont(minAddName.getFont().getSize()+4f));
        minAddName.setText("Họ tên:");

        minAddUser.setFont(minAddUser.getFont().deriveFont(minAddUser.getFont().getSize()+4f));
        minAddUser.setText("Tài khoản:");

        minAddPass.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minAddPass.setText("Mật khẩu:");

        minAddUserField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minAddUserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minAddUserFieldActionPerformed(evt);
            }
        });

        minAddPassField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minAddPassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minAddPassFieldActionPerformed(evt);
            }
        });

        minAddNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minAddNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minAddNameFieldActionPerformed(evt);
            }
        });

        minAddCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minAddCancel.setText("Hủy");
        minAddCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minAddCancelActionPerformed(evt);
            }
        });

        minAddPass2.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minAddPass2.setText("Xác nhận:");

        minAddPass2Field.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minAddPass2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minAddPass2FieldActionPerformed(evt);
            }
        });

        minAddConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minAddConf.setText("Thêm giáo vụ");
        minAddConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minAddConfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout minAddPanelLayout = new javax.swing.GroupLayout(minAddPanel);
        minAddPanel.setLayout(minAddPanelLayout);
        minAddPanelLayout.setHorizontalGroup(
                minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minAddPanelLayout.createSequentialGroup()
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(minAddPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, minAddPanelLayout.createSequentialGroup()
                                                        .addGap(19, 19, 19)
                                                        .addComponent(minAddCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(minAddConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, minAddPanelLayout.createSequentialGroup()
                                                        .addGap(30, 30, 30)
                                                        .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(minAddPanelLayout.createSequentialGroup()
                                                                        .addComponent(minAddPass, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(minAddPassField))
                                                                .addGroup(minAddPanelLayout.createSequentialGroup()
                                                                        .addComponent(minAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(minAddUserField))
                                                                .addGroup(minAddPanelLayout.createSequentialGroup()
                                                                        .addComponent(minAddName, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(35, 35, 35)
                                                                        .addComponent(minAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(minAddPanelLayout.createSequentialGroup()
                                                                        .addComponent(minAddPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(minAddPass2Field))))))
                                .addContainerGap(89, Short.MAX_VALUE))
        );
        minAddPanelLayout.setVerticalGroup(
                minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minAddPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minAddLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minAddName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minAddNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minAddUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minAddPass)
                                        .addComponent(minAddPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minAddPass2)
                                        .addComponent(minAddPass2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(minAddPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minAddCancel)
                                        .addComponent(minAddConf))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ministryEditPanel.add(minAddPanel);

        minAddLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minAddLabel1.setText("Chỉnh sửa giáo vụ");

        minAddName1.setFont(minAddName1.getFont().deriveFont(minAddName1.getFont().getSize()+4f));
        minAddName1.setText("Họ tên:");

        minAddPass1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minAddPass1.setText("Mật khẩu:");

        minAddPass3.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minAddPass3.setText("Xác nhận:");

        minEditNameField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minEditNameField.setText("Võ Thế Hùng");
        minEditNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minEditNameFieldActionPerformed(evt);
            }
        });

        minEditPassField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minEditPassField.setText("vothehung");
        minEditPassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minEditPassFieldActionPerformed(evt);
            }
        });

        minEditPass2Field.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        minEditPass2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minEditPass2FieldActionPerformed(evt);
            }
        });

        minEditCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minEditCancel.setText("Hủy");
        minEditCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minEditCancelActionPerformed(evt);
            }
        });

        minEditConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        minEditConf.setText("Xác nhận");
        minEditConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minEditConfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout minEditPanelLayout = new javax.swing.GroupLayout(minEditPanel);
        minEditPanel.setLayout(minEditPanelLayout);
        minEditPanelLayout.setHorizontalGroup(
                minEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minEditPanelLayout.createSequentialGroup()
                                .addGroup(minEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(minEditPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minAddLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(minEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, minEditPanelLayout.createSequentialGroup()
                                                        .addGap(19, 19, 19)
                                                        .addComponent(minEditCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(minEditConf, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, minEditPanelLayout.createSequentialGroup()
                                                        .addGap(30, 30, 30)
                                                        .addGroup(minEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(minEditPanelLayout.createSequentialGroup()
                                                                        .addComponent(minAddPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(minEditPassField))
                                                                .addGroup(minEditPanelLayout.createSequentialGroup()
                                                                        .addComponent(minAddName1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(35, 35, 35)
                                                                        .addComponent(minEditNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(minEditPanelLayout.createSequentialGroup()
                                                                        .addComponent(minAddPass3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(minEditPass2Field))))))
                                .addContainerGap(89, Short.MAX_VALUE))
        );
        minEditPanelLayout.setVerticalGroup(
                minEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minEditPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minAddLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(minEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minAddName1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minEditNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minAddPass1)
                                        .addComponent(minEditPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minAddPass3)
                                        .addComponent(minEditPass2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(minEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minEditCancel)
                                        .addComponent(minEditConf))
                                .addContainerGap(188, Short.MAX_VALUE))
        );

        ministryEditPanel.add(minEditPanel);

        javax.swing.GroupLayout minInforPaneLayout = new javax.swing.GroupLayout(minInforPane);
        minInforPane.setLayout(minInforPaneLayout);
        minInforPaneLayout.setHorizontalGroup(
                minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minInforPaneLayout.createSequentialGroup()
                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(minInforPaneLayout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(minInforPaneLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(minPass))
                                                        .addGroup(minInforPaneLayout.createSequentialGroup()
                                                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(minNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(minId)
                                                                        .addComponent(minUser)
                                                                        .addComponent(minName)))))
                                        .addGroup(minInforPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(minInforPaneLayout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, minInforPaneLayout.createSequentialGroup()
                                                                .addComponent(minAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(minEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, minInforPaneLayout.createSequentialGroup()
                                                                .addComponent(minRestBtn)
                                                                .addGap(28, 28, 28)
                                                                .addComponent(minDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(ministryEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        minInforPaneLayout.setVerticalGroup(
                minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(minInforPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(minUser))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel)
                                        .addComponent(minPass))
                                .addGap(33, 33, 33)
                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minEditBtn)
                                        .addComponent(minAddBtn))
                                .addGap(18, 18, 18)
                                .addGroup(minInforPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minRestBtn)
                                        .addComponent(minDelBtn))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(ministryEditPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ministryContentLayout = new javax.swing.GroupLayout(ministryContent);
        ministryContent.setLayout(ministryContentLayout);
        ministryContentLayout.setHorizontalGroup(
                ministryContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ministryContentLayout.createSequentialGroup()
                                .addGroup(ministryContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(minInforPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        ministryContentLayout.setVerticalGroup(
                ministryContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ministryContentLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(minInforPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPane.add(ministryContent);

        subjectContent.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout subjectContentLayout = new javax.swing.GroupLayout(subjectContent);
        subjectContent.setLayout(subjectContentLayout);
        subjectContentLayout.setHorizontalGroup(
                subjectContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        subjectContentLayout.setVerticalGroup(
                subjectContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );

        contentPane.add(subjectContent);

        semesterContent.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout semesterContentLayout = new javax.swing.GroupLayout(semesterContent);
        semesterContent.setLayout(semesterContentLayout);
        semesterContentLayout.setHorizontalGroup(
                semesterContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        semesterContentLayout.setVerticalGroup(
                semesterContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );

        contentPane.add(semesterContent);

        classContent.setBackground(new java.awt.Color(0, 255, 102));

        javax.swing.GroupLayout classContentLayout = new javax.swing.GroupLayout(classContent);
        classContent.setLayout(classContentLayout);
        classContentLayout.setHorizontalGroup(
                classContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        classContentLayout.setVerticalGroup(
                classContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );

        contentPane.add(classContent);

        javax.swing.GroupLayout studentContentLayout = new javax.swing.GroupLayout(studentContent);
        studentContent.setLayout(studentContentLayout);
        studentContentLayout.setHorizontalGroup(
                studentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        studentContentLayout.setVerticalGroup(
                studentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );

        contentPane.add(studentContent);

        javax.swing.GroupLayout sessionContentLayout = new javax.swing.GroupLayout(sessionContent);
        sessionContent.setLayout(sessionContentLayout);
        sessionContentLayout.setHorizontalGroup(
                sessionContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        sessionContentLayout.setVerticalGroup(
                sessionContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );

        contentPane.add(sessionContent);

        javax.swing.GroupLayout courseContentLayout = new javax.swing.GroupLayout(courseContent);
        courseContent.setLayout(courseContentLayout);
        courseContentLayout.setHorizontalGroup(
                courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        courseContentLayout.setVerticalGroup(
                courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );

        contentPane.add(courseContent);

        javax.swing.GroupLayout listStudentContentLayout = new javax.swing.GroupLayout(listStudentContent);
        listStudentContent.setLayout(listStudentContentLayout);
        listStudentContentLayout.setHorizontalGroup(
                listStudentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        listStudentContentLayout.setVerticalGroup(
                listStudentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );

        contentPane.add(listStudentContent);

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
                mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPaneLayout.createSequentialGroup()
                                .addComponent(paneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );
        mainPaneLayout.setVerticalGroup(
                mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paneMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
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
    }// </editor-fold>

    private void minAddBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minRestBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minEditBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minDelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minAddUserFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minAddPassFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minAddNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minAddCancelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minAddPass2FieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minAddConfActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minEditPassFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minEditNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minEditCancelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minEditPass2FieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void minEditConfActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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
    // Variables declaration - do not modify
    private javax.swing.JPanel classContent;
    private javax.swing.JLabel classIcon;
    private javax.swing.JLabel classLabel;
    private javax.swing.JPanel classTab;
    private javax.swing.JPanel contentPane;
    private javax.swing.JPanel courseContent;
    private javax.swing.JLabel courseIcon;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JPanel courseTab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listCourse;
    private javax.swing.JPanel listStudentContent;
    private javax.swing.JLabel listStudentLabel;
    private javax.swing.JPanel listStudentTab;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JPanel logoutTab;
    private javax.swing.JPanel mainPane;
    private javax.swing.JButton minAddBtn;
    private javax.swing.JButton minAddCancel;
    private javax.swing.JButton minAddConf;
    private javax.swing.JLabel minAddLabel;
    private javax.swing.JLabel minAddLabel1;
    private javax.swing.JLabel minAddName;
    private javax.swing.JLabel minAddName1;
    private javax.swing.JTextField minAddNameField;
    private javax.swing.JPanel minAddPanel;
    private javax.swing.JLabel minAddPass;
    private javax.swing.JLabel minAddPass1;
    private javax.swing.JLabel minAddPass2;
    private javax.swing.JTextField minAddPass2Field;
    private javax.swing.JLabel minAddPass3;
    private javax.swing.JTextField minAddPassField;
    private javax.swing.JLabel minAddUser;
    private javax.swing.JTextField minAddUserField;
    private javax.swing.JButton minDelBtn;
    private javax.swing.JButton minEditBtn;
    private javax.swing.JButton minEditCancel;
    private javax.swing.JButton minEditConf;
    private javax.swing.JTextField minEditNameField;
    private javax.swing.JPanel minEditPanel;
    private javax.swing.JTextField minEditPass2Field;
    private javax.swing.JTextField minEditPassField;
    private javax.swing.JLabel minId;
    private javax.swing.JLabel minIdLabel;
    private javax.swing.JLabel minInforLabel;
    private javax.swing.JPanel minInforPane;
    private javax.swing.JLabel minName;
    private javax.swing.JLabel minNameLabel;
    private javax.swing.JLabel minPass;
    private javax.swing.JLabel minPassLabel;
    private javax.swing.JButton minRestBtn;
    private javax.swing.JTable minTable;
    private javax.swing.JLabel minUser;
    private javax.swing.JLabel minUserLabel;
    private javax.swing.JPanel ministryContent;
    private javax.swing.JPanel ministryEditPanel;
    private javax.swing.JLabel ministryIcon;
    private javax.swing.JLabel ministryLabel;
    private javax.swing.JPanel ministryTab;
    private javax.swing.JPanel paneMenu;
    private javax.swing.JPanel semesterContent;
    private javax.swing.JLabel semesterIcon;
    private javax.swing.JLabel semesterLabel;
    private javax.swing.JPanel semesterTab;
    private javax.swing.JPanel sessionContent;
    private javax.swing.JLabel sessionIcon;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JPanel sessionTab;
    private javax.swing.JPanel studentContent;
    private javax.swing.JLabel studentIcon;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JPanel studentTab;
    private javax.swing.JPanel subjectContent;
    private javax.swing.JLabel subjectIcon;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JPanel subjectTab;
    // End of variables declaration
}
