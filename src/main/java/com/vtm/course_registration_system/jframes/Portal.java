
package com.vtm.course_registration_system.jframes;

import com.vtm.course_registration_system.models.*;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author minht
 */
public class Portal extends javax.swing.JFrame {

    final static int add = 0;
    final static int update = 1;
    final static int delete = 2;
    final static int reset = 3;

    final static int signup = 5;
    final static int course = 6;

    public static Object[][] listCourse;
    public static Object[][] listRegister;

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
        this.couInforPanel.setVisible(false);

        this.courseContent.setVisible(false);

        addAction();
    }

    public void addAction() {
//        Menuclick handle
        this.courseTab.addMouseListener(new MenuClickHandle(this.courseTab, this.courseContent));
        this.signupTab.addMouseListener(new MenuClickHandle(this.signupTab, this.registerContent));
        this.logoutTab.addMouseListener(new LogoutListener());

        this.courseLabel.addMouseListener(new MenuClickHandle(this.courseTab, this.courseContent));
        this.signupLabel.addMouseListener(new MenuClickHandle(this.signupTab, this.registerContent));
        this.logoutLabel.addMouseListener(new LogoutListener());

//        Signup config
        this.registerSearchBtn.addMouseListener(new SearchBtnListener(this.registerInforPanel, Portal.signup));
        this.registerCancelBtn.addMouseListener(new SearchBtnListener(this.registerCancelPanel, Portal.signup));
        this.registerAddConf.addMouseListener(new UpdateDataListener(Portal.signup, Portal.add));

//        Course config
        this.couSearchBtn.addMouseListener(new SearchBtnListener(this.couInforPanel, Portal.course));
        this.couCancelBtn.addMouseListener(new SearchBtnListener(this.couCancelPanel, Portal.course));
        this.couDelConf.addMouseListener(new UpdateDataListener(Portal.course, Portal.delete));
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
        if (entityType == Portal.signup) {
            if (editType == Portal.add) {
                JOptionPane.showMessageDialog(null, "Đăng ký thành công");
            }
        } else if (entityType == Portal.course) {
            if (editType == Portal.delete) {
                JOptionPane.showMessageDialog(null, "Hủy thành công");
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

                if (this.entityType == Portal.course) {
                    this.portal.couInforPanel.setVisible(false);
                    this.portal.couCancelPanel.setVisible(false);
                } else if (this.entityType == Portal.signup) {
                    this.portal.registerInforPanel.setVisible(false);
                    this.portal.registerCancelPanel.setVisible(false);
                }
                this.panel.setVisible(true);
            } catch (Exception ex) {
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
            this.portal.courseTab.setBackground(new Color(204, 204, 204));
            this.portal.signupTab.setBackground(new Color(204, 204, 204));
            this.selectedTab.setBackground(new Color(102, 102, 255));

            this.portal.courseContent.setVisible(false);
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
        signupTab = new javax.swing.JPanel();
        signupLabel = new javax.swing.JLabel();
        signupIcon = new javax.swing.JLabel();
        courseTab = new javax.swing.JPanel();
        courseLabel = new javax.swing.JLabel();
        courseIcon = new javax.swing.JLabel();
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
        courseContent = new javax.swing.JPanel();
        couScrollPane = new javax.swing.JScrollPane();
        couTable = new javax.swing.JTable();
        minInforLabel23 = new javax.swing.JLabel();
        couSearchField = new javax.swing.JTextField();
        couSearchBtn = new javax.swing.JButton();
        couEditPanel = new javax.swing.JPanel();
        couCancelPanel = new javax.swing.JPanel();
        couInforPanel = new javax.swing.JPanel();
        minInforLabel21 = new javax.swing.JLabel();
        minIdLabel5 = new javax.swing.JLabel();
        couId = new javax.swing.JLabel();
        minUserLabel10 = new javax.swing.JLabel();
        couName = new javax.swing.JLabel();
        minPassLabel25 = new javax.swing.JLabel();
        couYear = new javax.swing.JLabel();
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
        couCancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        mainPane.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N

        paneMenu.setBackground(new java.awt.Color(0, 102, 102));
        paneMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paneMenu.setToolTipText("");
        paneMenu.setPreferredSize(new java.awt.Dimension(240, 455));

        signupTab.setBackground(new java.awt.Color(102, 102, 255));
        signupTab.setPreferredSize(new java.awt.Dimension(100, 45));

        signupLabel.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        signupLabel.setText("Đăng ký");
        signupLabel.setToolTipText("");

        signupIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\minht\\Desktop\\List.png")); // NOI18N

        javax.swing.GroupLayout signupTabLayout = new javax.swing.GroupLayout(signupTab);
        signupTab.setLayout(signupTabLayout);
        signupTabLayout.setHorizontalGroup(
                signupTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(signupTabLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(signupIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(signupLabel))
        );
        signupTabLayout.setVerticalGroup(
                signupTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(signupTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(signupLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(signupIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addContainerGap()
                                .addComponent(courseIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(courseLabel))
        );
        courseTabLayout.setVerticalGroup(
                courseTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(courseTabLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(courseLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(courseIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(signupTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(courseTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addComponent(logoutTab, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        paneMenuLayout.setVerticalGroup(
                paneMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneMenuLayout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(signupTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(courseTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logoutTab, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPane.setLayout(new javax.swing.OverlayLayout(contentPane));

        registerContent.setBackground(new java.awt.Color(255, 255, 255));
        registerContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        registerTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {2, "Võ Thế Hùng", "ministry2", "ministry2"},
                        {2, 2, 3, 4},
                        {3, 2, 3, 4},
                        {6, 2, 3, 4},
                        {1, 2, 3, 4},
                },
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
                        .addComponent(registerEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
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

        courseContent.setBackground(new java.awt.Color(255, 255, 255));
        courseContent.setPreferredSize(new java.awt.Dimension(800, 580));

        // Cho phep table sap xep
        couTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {2, "Võ Thế Hùng", "ministry2", "ministry2"},
                        {2, 2, 3, 4},
                        {3, 2, 3, 4},
                        {6, 2, 3, 4},
                        {1, 2, 3, 4},
                },
                new String [] {
                        "ID", "Mã môn", "Tên môn", "Số tín chỉ", "Giáo viên", "Phòng", "Thứ", "Ca"
                }
        ));
        couScrollPane.setViewportView(couTable);

        minInforLabel23.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        minInforLabel23.setText("Tìm học phần đã đăng ký");

        couSearchField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        couSearchField.setText("ID");

        couSearchBtn.setText("Search");

        couEditPanel.setLayout(new javax.swing.OverlayLayout(couEditPanel));

        javax.swing.GroupLayout couCancelPanelLayout = new javax.swing.GroupLayout(couCancelPanel);
        couCancelPanel.setLayout(couCancelPanelLayout);
        couCancelPanelLayout.setHorizontalGroup(
                couCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 820, Short.MAX_VALUE)
        );
        couCancelPanelLayout.setVerticalGroup(
                couCancelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 313, Short.MAX_VALUE)
        );

        couEditPanel.add(couCancelPanel);

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

        couDelConf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        couDelConf.setText("Xóa học phần đã đăng ký");

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

        couCancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        couCancelBtn.setText("Hủy");

        javax.swing.GroupLayout couInforPanelLayout = new javax.swing.GroupLayout(couInforPanel);
        couInforPanel.setLayout(couInforPanelLayout);
        couInforPanelLayout.setHorizontalGroup(
                couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(couDelConf, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couCancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56))
                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                                .addComponent(minPassLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(couTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                                .addComponent(minPassLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(couIdsubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                                .addComponent(minPassLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(couDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(minPassLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minPassLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minPassLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minPassLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(minIdLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(couId)
                                                        .addComponent(couYear, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(couRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(couShift, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(couIdministry, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                                .addComponent(minUserLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(couName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(417, 417, 417))
        );
        couInforPanelLayout.setVerticalGroup(
                couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                                .addComponent(minInforLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(minIdLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(couId))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(minUserLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(couName)))
                                        .addGroup(couInforPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(couDelConf)
                                                .addGap(16, 16, 16)
                                                .addComponent(couCancelBtn)))
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
                                .addGroup(couInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(minPassLabel31)
                                        .addComponent(couIdministry))
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        couEditPanel.add(couInforPanel);

        javax.swing.GroupLayout courseContentLayout = new javax.swing.GroupLayout(courseContent);
        courseContent.setLayout(courseContentLayout);
        courseContentLayout.setHorizontalGroup(
                courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(couEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                        .addComponent(couScrollPane)
                        .addGroup(courseContentLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(couSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(couSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(175, 175, 175))
                        .addGroup(courseContentLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(minInforLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        courseContentLayout.setVerticalGroup(
                courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(courseContentLayout.createSequentialGroup()
                                .addComponent(couScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minInforLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(courseContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(couSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(couSearchBtn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addComponent(couEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPane.add(courseContent);

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
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton couCancelBtn;
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
    private javax.swing.JLabel registerId;
    private javax.swing.JPanel registerInforPanel;
    private javax.swing.JLabel registerMinistry;
    private javax.swing.JLabel registerName;
    private javax.swing.JLabel registerRoom;
    private javax.swing.JScrollPane registerScrollPane;
    private javax.swing.JButton registerSearchBtn;
    private javax.swing.JTextField registerSearchField;
    private javax.swing.JLabel registerShift;
    private javax.swing.JLabel registerSubject;
    private javax.swing.JTable registerTable;
    private javax.swing.JLabel registerTeacher;
    private javax.swing.JLabel registerYear;
    private javax.swing.JLabel signupIcon;
    private javax.swing.JLabel signupLabel;
    private javax.swing.JPanel signupTab;
    // End of variables declaration
}
