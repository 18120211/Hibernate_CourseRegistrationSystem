
package com.vtm.course_registration_system.jframes;

import com.vtm.course_registration_system.configs.Local;
import com.vtm.course_registration_system.daos.CourseDao;
import com.vtm.course_registration_system.daos.CourseregistrationDao;
import com.vtm.course_registration_system.models.CourseEntity;
import com.vtm.course_registration_system.models.CourseregistrationEntity;
import com.vtm.course_registration_system.models.StudentEntity;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author minht
 */
public class Portal extends javax.swing.JFrame {

    final static int add = 0;
    final static int update = 1;
    final static int delete = 2;
    final static int reset = 3;

    final static int register = 5;
    final static int cancel = 6;

    public static Object[][] listCancel;
    public static Object[][] listRegister;
    public CourseEntity curCourseRegister;
    public CourseEntity curCourseCancel;

    /**
     * Creates new form Portal
     */
    public Portal() {
        initComponents();
        moreConfig();
    }

    public void moreConfig() {
        setLocationRelativeTo(null);
        setResizable(false);

        this.registerInforPanel.setVisible(false);
        this.cancelInforPanel.setVisible(false);

        this.cancelContent.setVisible(false);

        addAction();
    }

    public void addAction() {
//        Menuclick handle
        this.cancelTab.addMouseListener(new MenuClickHandle(this.cancelTab, this.cancelContent));
        this.registerTab.addMouseListener(new MenuClickHandle(this.registerTab, this.registerContent));
        this.logoutTab.addMouseListener(new LogoutListener());

        this.cancelLabel.addMouseListener(new MenuClickHandle(this.cancelTab, this.cancelContent));
        this.registerLabel.addMouseListener(new MenuClickHandle(this.registerTab, this.registerContent));
        this.logoutLabel.addMouseListener(new LogoutListener());

//        Register config
        this.registerSearchBtn.addMouseListener(new SearchBtnListener(this.registerInforPanel, Portal.register));
        this.registerCancelBtn.addMouseListener(new SearchBtnListener(this.registerCancelPanel, Portal.register));
        this.registerAddConf.addMouseListener(new UpdateDataListener(Portal.register, Portal.add));

//        Cancel config
        this.cancelSearchBtn.addMouseListener(new SearchBtnListener(this.cancelInforPanel, Portal.cancel));
        this.cancelCancelBtn.addMouseListener(new SearchBtnListener(this.cancelCancelPanel, Portal.cancel));
        this.cancelDelConf.addMouseListener(new UpdateDataListener(Portal.cancel, Portal.delete));
    }

    class LogoutListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            if (JOptionPane.showConfirmDialog(null, "Đăng xuất khỏi tài khoản", "Xác thực", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                Portal.this.dispose();
                Login.main(null);
            }

        }
    }

    void updateData(int entityType, int editType) {
        try {
            if (entityType == Portal.register) {
                if (editType == Portal.add) {
                    if (!CourseregistrationDao.isRegistered(Local.userID,
                            this.curCourseRegister.getSubjectByIdsu().getId())) {
                        CourseregistrationDao.add(new CourseregistrationEntity(
                                new Timestamp(System.currentTimeMillis()),
                                (StudentEntity) Local.user, this.curCourseRegister
                        ));
                        JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                        Portal.listCancel = CourseDao.getTableData(Local.userID);
                        this.cancelTable.setModel(new DefaultTableModel(
                                Portal.listCancel,
                                new String[] {
                                        "ID", "Mã môn", "Tên môn", "Số tín chỉ", "Giáo viên", "Phòng", "Thứ", "Ca"
                                }
                        ));
                        this.cancelScrollPane.setViewportView(this.cancelTable);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Môn này đã đăng ký rồi",
                                "Đăng ký thất bại", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (entityType == Portal.cancel) {
                if (editType == Portal.delete) {
                    CourseregistrationDao.delete(Local.userID, this.curCourseCancel.getId());
                    JOptionPane.showMessageDialog(null, "Hủy thành công");
                }
                Portal.listCancel = CourseDao.getTableData(Local.userID);
                this.cancelTable.setModel(new DefaultTableModel(
                        Portal.listCancel,
                        new String[] {
                                "ID", "Mã môn", "Tên môn", "Số tín chỉ", "Giáo viên", "Phòng", "Thứ", "Ca"
                        }
                ));
                this.cancelScrollPane.setViewportView(this.cancelTable);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
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

    class SearchBtnListener extends MouseAdapter {

        JPanel panel = new JPanel();
        int entityType;
        Portal portal = Portal.this;

        public SearchBtnListener(JPanel panel, int entityType) {
            this.panel = panel;
            this.entityType = entityType;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
            try {
                boolean isExistEntity = false;
                if (this.entityType == Portal.register) {
                    int id = Integer.parseInt(this.portal.registerSearchField.getText());

                    this.portal.curCourseRegister = CourseDao.get(id);
                    if (this.portal.curCourseRegister != null) {
                        isExistEntity = true;
                        this.portal.registerId.setText(Integer.toString(id));
                        this.portal.registerName.setText(this.portal.curCourseRegister.getName());
                        this.portal.registerYear.setText(Integer.toString(this.portal.curCourseRegister.getYear()));
                        this.portal.registerTeacher.setText(this.portal.curCourseRegister.getTeacher());
                        this.portal.registerRoom.setText(this.portal.curCourseRegister.getRoom());
                        this.portal.registerDay.setText(this.portal.curCourseRegister.getDay());
                        this.portal.registerShift.setText(Integer.toString(this.portal.curCourseRegister.getShift()));
                        this.portal.registerSubject.setText(this.portal.curCourseRegister.getSubjectByIdsu().getName());
                        this.portal.registerMinistry.setText(this.portal.curCourseRegister.getMinistryByIdmi().getName());

                        this.portal.registerInforPanel.setVisible(false);
                        this.portal.registerCancelPanel.setVisible(false);
                    }

                } else if (this.entityType == Portal.cancel) {
                    int id = Integer.parseInt(this.portal.cancelSearchField.getText());
                    this.portal.curCourseCancel = CourseDao.get(id);
                    if (this.portal.curCourseCancel != null) {
                        isExistEntity = true;
                        this.portal.cancelId.setText(Integer.toString(id));
                        this.portal.cancelName.setText(this.portal.curCourseCancel.getName());
                        this.portal.cancelYear.setText(Integer.toString(this.portal.curCourseCancel.getYear()));
                        this.portal.cancelTeacher.setText(this.portal.curCourseCancel.getTeacher());
                        this.portal.cancelRoom.setText(this.portal.curCourseCancel.getRoom());
                        this.portal.cancelDay.setText(this.portal.curCourseCancel.getDay());
                        this.portal.cancelShift.setText(Integer.toString(this.portal.curCourseCancel.getShift()));
                        this.portal.cancelSubject.setText(this.portal.curCourseCancel.getSubjectByIdsu().getName());
                        this.portal.cancelMinistry.setText(this.portal.curCourseCancel.getMinistryByIdmi().getName());


                        this.portal.cancelInforPanel.setVisible(false);
                        this.portal.cancelCancelPanel.setVisible(false);
                    }

                }
                if (isExistEntity) {
                    this.panel.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy",
                            "Không tìm thấy", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập ID hợp lệ",
                        "Nhập không hợp lệ", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }

    private class MenuClickHandle extends MouseAdapter {

        Portal portal = Portal.this;
        JPanel selectedTab;
        JPanel selectedContent;

        public MenuClickHandle(JPanel selectedTab, JPanel selectedContent) {
            this.selectedTab = selectedTab;
            this.selectedContent = selectedContent;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
            this.portal.cancelTab.setBackground(new Color(204, 204, 204));
            this.portal.registerTab.setBackground(new Color(204, 204, 204));
            this.selectedTab.setBackground(new Color(102, 102, 255));

            this.portal.cancelContent.setVisible(false);
            this.portal.registerContent.setVisible(false);
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
        registerTab = new javax.swing.JPanel();
        registerLabel = new javax.swing.JLabel();
        registerIcon = new javax.swing.JLabel();
        cancelTab = new javax.swing.JPanel();
        cancelLabel = new javax.swing.JLabel();
        cancelIcon = new javax.swing.JLabel();
        logoutTab = new javax.swing.JPanel();
        logoutLabel = new javax.swing.JLabel();
        logoutIcon = new javax.swing.JLabel();
        contentPane = new javax.swing.JPanel();
        registerContent = new javax.swing.JPanel();
        registerScrollPane = new javax.swing.JScrollPane();
        registerTable = new javax.swing.JTable();
        minInforLabel24 = new javax.swing.JLabel();
        registerSearchField = new javax.swing.JTextField();
        registerSearchBtn = new javax.swing.JButton();
        registerEditPanel = new javax.swing.JPanel();
        registerCancelPanel = new javax.swing.JPanel();
        registerInforPanel = new javax.swing.JPanel();
        minInforLabel22 = new javax.swing.JLabel();
        minIdLabel6 = new javax.swing.JLabel();
        registerId = new javax.swing.JLabel();
        minUserLabel11 = new javax.swing.JLabel();
        registerName = new javax.swing.JLabel();
        minPassLabel32 = new javax.swing.JLabel();
        registerYear = new javax.swing.JLabel();
        registerAddConf = new javax.swing.JButton();
        minPassLabel33 = new javax.swing.JLabel();
        registerTeacher = new javax.swing.JLabel();
        minPassLabel34 = new javax.swing.JLabel();
        registerRoom = new javax.swing.JLabel();
        minPassLabel35 = new javax.swing.JLabel();
        registerDay = new javax.swing.JLabel();
        minPassLabel36 = new javax.swing.JLabel();
        registerShift = new javax.swing.JLabel();
        minPassLabel37 = new javax.swing.JLabel();
        registerSubject = new javax.swing.JLabel();
        minPassLabel38 = new javax.swing.JLabel();
        registerMinistry = new javax.swing.JLabel();
        registerCancelBtn = new javax.swing.JButton();
        cancelContent = new javax.swing.JPanel();
        cancelScrollPane = new javax.swing.JScrollPane();
        cancelTable = new javax.swing.JTable();
        minInforLabel23 = new javax.swing.JLabel();
        cancelSearchField = new javax.swing.JTextField();
        cancelSearchBtn = new javax.swing.JButton();
        cancelEditPanel = new javax.swing.JPanel();
        cancelCancelPanel = new javax.swing.JPanel();
        cancelInforPanel = new javax.swing.JPanel();
        minInforLabel21 = new javax.swing.JLabel();
        minIdLabel5 = new javax.swing.JLabel();
        cancelId = new javax.swing.JLabel();
        minUserLabel10 = new javax.swing.JLabel();
        cancelName = new javax.swing.JLabel();
        minPassLabel25 = new javax.swing.JLabel();
        cancelYear = new javax.swing.JLabel();
        cancelDelConf = new javax.swing.JButton();
        minPassLabel26 = new javax.swing.JLabel();
        cancelTeacher = new javax.swing.JLabel();
        minPassLabel27 = new javax.swing.JLabel();
        cancelRoom = new javax.swing.JLabel();
        minPassLabel28 = new javax.swing.JLabel();
        cancelDay = new javax.swing.JLabel();
        minPassLabel29 = new javax.swing.JLabel();
        cancelShift = new javax.swing.JLabel();
        minPassLabel30 = new javax.swing.JLabel();
        cancelSubject = new javax.swing.JLabel();
        minPassLabel31 = new javax.swing.JLabel();
        cancelMinistry = new javax.swing.JLabel();
        cancelCancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        mainPane.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N

        paneMenu.setBackground(new java.awt.Color(0, 102, 102));
        paneMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paneMenu.setToolTipText("");
        paneMenu.setPreferredSize(new java.awt.Dimension(240, 455));

        registerTab.setBackground(new java.awt.Color(102, 102, 255));
        registerTab.setPreferredSize(new java.awt.Dimension(100, 45));

        registerLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        registerLabel.setText("Đăng ký");
        registerLabel.setToolTipText("");

        registerIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\List.png")); // NOI18N

        javax.swing.GroupLayout registerTabLayout = new javax.swing.GroupLayout(registerTab);
        registerTab.setLayout(registerTabLayout);
        registerTabLayout.setHorizontalGroup(
                registerTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registerTabLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(registerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(registerLabel))
        );
        registerTabLayout.setVerticalGroup(
                registerTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registerTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(registerLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(registerIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cancelTab.setBackground(new java.awt.Color(204, 204, 204));
        cancelTab.setPreferredSize(new java.awt.Dimension(100, 45));

        cancelLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        cancelLabel.setText("Học phần");
        cancelLabel.setToolTipText("");

        cancelIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\Course.png")); // NOI18N

        javax.swing.GroupLayout cancelTabLayout = new javax.swing.GroupLayout(cancelTab);
        cancelTab.setLayout(cancelTabLayout);
        cancelTabLayout.setHorizontalGroup(
                cancelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cancelTabLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cancelIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(cancelLabel))
        );
        cancelTabLayout.setVerticalGroup(
                cancelTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cancelTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(cancelLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(cancelIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(logoutTabLayout.createSequentialGroup()
                                .addComponent(logoutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout paneMenuLayout = new javax.swing.GroupLayout(paneMenu);
        paneMenu.setLayout(paneMenuLayout);
        paneMenuLayout.setHorizontalGroup(
                paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(registerTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(cancelTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(logoutTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        paneMenuLayout.setVerticalGroup(
                paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneMenuLayout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(registerTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logoutTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPane.setLayout(new javax.swing.OverlayLayout(contentPane));

        registerContent.setBackground(new java.awt.Color(255, 255, 255));
        registerContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        registerTable.setModel(new javax.swing.table.DefaultTableModel(
                Portal.listRegister,
                new String [] {
                        "ID", "Mã môn", "Tên môn", "Số tín chỉ", "Giáo viên", "Phòng", "Thứ", "Ca"
                }
        ));
        registerScrollPane.setViewportView(registerTable);

        minInforLabel24.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel24.setText("Tìm học phần");

        registerSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        registerSearchField.setText("ID");

        registerSearchBtn.setText("Search");

        registerEditPanel.setLayout(new javax.swing.OverlayLayout(registerEditPanel));

        javax.swing.GroupLayout registerCancelPanelLayout = new javax.swing.GroupLayout(registerCancelPanel);
        registerCancelPanel.setLayout(registerCancelPanelLayout);
        registerCancelPanelLayout.setHorizontalGroup(
                registerCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 820, Short.MAX_VALUE)
        );
        registerCancelPanelLayout.setVerticalGroup(
                registerCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 313, Short.MAX_VALUE)
        );

        registerEditPanel.add(registerCancelPanel);

        registerInforPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        minInforLabel22.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel22.setText("Thông tin học phần");

        minIdLabel6.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minIdLabel6.setText("Id:");

        registerId.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        registerId.setText("id");

        minUserLabel11.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel11.setText("Tên học phần:");

        registerName.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        registerName.setText("CTDL&GT 18CTT2");

        minPassLabel32.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel32.setText("Năm:");

        registerYear.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        registerYear.setText("2021");

        registerAddConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registerAddConf.setText("Đăng ký học phần");

        minPassLabel33.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel33.setText("Giáo viên:");

        registerTeacher.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        registerTeacher.setText("Phan Thị Phương Uyên");

        minPassLabel34.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel34.setText("Phòng:");

        registerRoom.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        registerRoom.setText("E104");

        minPassLabel35.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel35.setText("Thứ:");

        registerDay.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        registerDay.setText("2");

        minPassLabel36.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel36.setText("Ca:");

        registerShift.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        registerShift.setText("1");

        minPassLabel37.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel37.setText("Môn học:");

        registerSubject.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        registerSubject.setText("id môn học");

        minPassLabel38.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel38.setText("Giáo vụ:");

        registerMinistry.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        registerMinistry.setText("id giáo vụ");

        registerCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registerCancelBtn.setText("Hủy");

        javax.swing.GroupLayout registerInforPanelLayout = new javax.swing.GroupLayout(registerInforPanel);
        registerInforPanel.setLayout(registerInforPanelLayout);
        registerInforPanelLayout.setHorizontalGroup(
                registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                                .addGap(63, 63, 63)
                                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(registerTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                                                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(registerSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minPassLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(registerDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(minPassLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minPassLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(minIdLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(registerId)
                                                                        .addComponent(registerYear, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(registerRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(registerShift, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(registerMinistry, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                                                .addComponent(minUserLabel11)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(registerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(53, 53, 53))
                                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(minInforLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(registerAddConf, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registerCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56))
        );
        registerInforPanelLayout.setVerticalGroup(
                registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                                .addComponent(minInforLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(minIdLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(registerId))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(minUserLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(registerName)))
                                        .addGroup(registerInforPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(registerAddConf)
                                                .addGap(16, 16, 16)
                                                .addComponent(registerCancelBtn)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel32)
                                        .addComponent(registerYear))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel33)
                                        .addComponent(registerTeacher))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel34)
                                        .addComponent(registerRoom))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel35)
                                        .addComponent(registerDay))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel36)
                                        .addComponent(registerShift))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel37)
                                        .addComponent(registerSubject))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(registerInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel38)
                                        .addComponent(registerMinistry))
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        registerEditPanel.add(registerInforPanel);

        javax.swing.GroupLayout registerContentLayout = new javax.swing.GroupLayout(registerContent);
        registerContent.setLayout(registerContentLayout);
        registerContentLayout.setHorizontalGroup(
                registerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(registerEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(registerScrollPane)
                        .addGroup(registerContentLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(registerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(registerSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(175, 175, 175))
                        .addGroup(registerContentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registerContentLayout.setVerticalGroup(
                registerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(registerContentLayout.createSequentialGroup()
                                .addComponent(registerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minInforLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(registerContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(registerSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(registerSearchBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(registerEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPane.add(registerContent);

        cancelContent.setBackground(new java.awt.Color(255, 255, 255));
        cancelContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        cancelTable.setModel(new javax.swing.table.DefaultTableModel(
                Portal.listCancel,
                new String [] {
                        "ID", "Mã môn", "Tên môn", "Số tín chỉ", "Giáo viên", "Phòng", "Thứ", "Ca"
                }
        ));
        cancelScrollPane.setViewportView(cancelTable);

        minInforLabel23.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel23.setText("Tìm học phần đã đăng ký");

        cancelSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cancelSearchField.setText("ID");


        cancelSearchBtn.setText("Search");

        cancelEditPanel.setLayout(new javax.swing.OverlayLayout(cancelEditPanel));

        javax.swing.GroupLayout cancelCancelPanelLayout = new javax.swing.GroupLayout(cancelCancelPanel);
        cancelCancelPanel.setLayout(cancelCancelPanelLayout);
        cancelCancelPanelLayout.setHorizontalGroup(
                cancelCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        cancelCancelPanelLayout.setVerticalGroup(
                cancelCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 313, Short.MAX_VALUE)
        );

        cancelEditPanel.add(cancelCancelPanel);

        cancelInforPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        minInforLabel21.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel21.setText("Thông tin học phần");

        minIdLabel5.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minIdLabel5.setText("Id:");

        cancelId.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        cancelId.setText("id");

        minUserLabel10.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minUserLabel10.setText("Tên học phần:");

        cancelName.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        cancelName.setText("CTDL&GT 18CTT2");

        minPassLabel25.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel25.setText("Năm:");

        cancelYear.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        cancelYear.setText("2021");

        cancelDelConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelDelConf.setText("Xóa học phần đã đăng ký");

        minPassLabel26.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel26.setText("Giáo viên:");

        cancelTeacher.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        cancelTeacher.setText("Phan Thị Phương Uyên");

        minPassLabel27.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel27.setText("Phòng:");

        cancelRoom.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        cancelRoom.setText("E104");

        minPassLabel28.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel28.setText("Thứ:");

        cancelDay.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        cancelDay.setText("2");

        minPassLabel29.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel29.setText("Ca:");

        cancelShift.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        cancelShift.setText("1");

        minPassLabel30.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel30.setText("Môn học:");

        cancelSubject.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        cancelSubject.setText("id môn học");

        minPassLabel31.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        minPassLabel31.setText("Giáo vụ:");

        cancelMinistry.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        cancelMinistry.setText("id giáo vụ");

        cancelCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelCancelBtn.setText("Hủy");

        javax.swing.GroupLayout cancelInforPanelLayout = new javax.swing.GroupLayout(cancelInforPanel);
        cancelInforPanel.setLayout(cancelInforPanelLayout);
        cancelInforPanelLayout.setHorizontalGroup(
                cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cancelInforPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cancelDelConf, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56))
                        .addGroup(cancelInforPanelLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cancelInforPanelLayout.createSequentialGroup()
                                                .addComponent(minPassLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cancelTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                                        .addGroup(cancelInforPanelLayout.createSequentialGroup()
                                                .addComponent(minPassLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cancelSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(cancelInforPanelLayout.createSequentialGroup()
                                                .addComponent(minPassLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cancelDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(cancelInforPanelLayout.createSequentialGroup()
                                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(minPassLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minPassLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minPassLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minPassLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minIdLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cancelId)
                                                        .addComponent(cancelYear, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cancelRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cancelShift, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cancelMinistry, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(cancelInforPanelLayout.createSequentialGroup()
                                                .addComponent(minUserLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(cancelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(417, 417, 417))
        );
        cancelInforPanelLayout.setVerticalGroup(
                cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cancelInforPanelLayout.createSequentialGroup()
                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(cancelInforPanelLayout.createSequentialGroup()
                                                .addComponent(minInforLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(minIdLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cancelId))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(minUserLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cancelName)))
                                        .addGroup(cancelInforPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(cancelDelConf)
                                                .addGap(16, 16, 16)
                                                .addComponent(cancelCancelBtn)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel25)
                                        .addComponent(cancelYear))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel26)
                                        .addComponent(cancelTeacher))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel27)
                                        .addComponent(cancelRoom))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel28)
                                        .addComponent(cancelDay))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel29)
                                        .addComponent(cancelShift))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel30)
                                        .addComponent(cancelSubject))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(cancelInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel31)
                                        .addComponent(cancelMinistry))
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        cancelEditPanel.add(cancelInforPanel);

        javax.swing.GroupLayout cancelContentLayout = new javax.swing.GroupLayout(cancelContent);
        cancelContent.setLayout(cancelContentLayout);
        cancelContentLayout.setHorizontalGroup(
                cancelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cancelEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                        .addComponent(cancelScrollPane)
                        .addGroup(cancelContentLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(cancelSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(175, 175, 175))
                        .addGroup(cancelContentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cancelContentLayout.setVerticalGroup(
                cancelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cancelContentLayout.createSequentialGroup()
                                .addComponent(cancelScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minInforLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cancelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelSearchBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(cancelEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPane.add(cancelContent);

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
                                        .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>


    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Portal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton cancelCancelBtn;
    private javax.swing.JPanel cancelCancelPanel;
    private javax.swing.JPanel cancelContent;
    private javax.swing.JLabel cancelDay;
    private javax.swing.JButton cancelDelConf;
    private javax.swing.JPanel cancelEditPanel;
    private javax.swing.JLabel cancelIcon;
    private javax.swing.JLabel cancelId;
    private javax.swing.JPanel cancelInforPanel;
    private javax.swing.JLabel cancelLabel;
    private javax.swing.JLabel cancelMinistry;
    private javax.swing.JLabel cancelName;
    private javax.swing.JLabel cancelRoom;
    private javax.swing.JScrollPane cancelScrollPane;
    private javax.swing.JButton cancelSearchBtn;
    private javax.swing.JTextField cancelSearchField;
    private javax.swing.JLabel cancelShift;
    private javax.swing.JLabel cancelSubject;
    private javax.swing.JPanel cancelTab;
    private javax.swing.JTable cancelTable;
    private javax.swing.JLabel cancelTeacher;
    private javax.swing.JLabel cancelYear;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel logoutIcon;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JPanel logoutTab;
    private javax.swing.JPanel mainPane;
    private javax.swing.JLabel minIdLabel5;
    private javax.swing.JLabel minIdLabel6;
    private javax.swing.JLabel minInforLabel21;
    private javax.swing.JLabel minInforLabel22;
    private javax.swing.JLabel minInforLabel23;
    private javax.swing.JLabel minInforLabel24;
    private javax.swing.JLabel minPassLabel25;
    private javax.swing.JLabel minPassLabel26;
    private javax.swing.JLabel minPassLabel27;
    private javax.swing.JLabel minPassLabel28;
    private javax.swing.JLabel minPassLabel29;
    private javax.swing.JLabel minPassLabel30;
    private javax.swing.JLabel minPassLabel31;
    private javax.swing.JLabel minPassLabel32;
    private javax.swing.JLabel minPassLabel33;
    private javax.swing.JLabel minPassLabel34;
    private javax.swing.JLabel minPassLabel35;
    private javax.swing.JLabel minPassLabel36;
    private javax.swing.JLabel minPassLabel37;
    private javax.swing.JLabel minPassLabel38;
    private javax.swing.JLabel minUserLabel10;
    private javax.swing.JLabel minUserLabel11;
    private javax.swing.JPanel paneMenu;
    private javax.swing.JButton registerAddConf;
    private javax.swing.JButton registerCancelBtn;
    private javax.swing.JPanel registerCancelPanel;
    private javax.swing.JPanel registerContent;
    private javax.swing.JLabel registerDay;
    private javax.swing.JPanel registerEditPanel;
    private javax.swing.JLabel registerIcon;
    private javax.swing.JLabel registerId;
    private javax.swing.JPanel registerInforPanel;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel registerMinistry;
    private javax.swing.JLabel registerName;
    private javax.swing.JLabel registerRoom;
    private javax.swing.JScrollPane registerScrollPane;
    private javax.swing.JButton registerSearchBtn;
    private javax.swing.JTextField registerSearchField;
    private javax.swing.JLabel registerShift;
    private javax.swing.JLabel registerSubject;
    private javax.swing.JPanel registerTab;
    private javax.swing.JTable registerTable;
    private javax.swing.JLabel registerTeacher;
    private javax.swing.JLabel registerYear;
    // End of variables declaration
}
